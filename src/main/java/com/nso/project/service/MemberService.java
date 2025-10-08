package com.nso.project.service;

import com.nso.project.dto.card.MemberCard;
import com.nso.project.mapper.MemberMapper;
import com.nso.project.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MemberService {

    private static final Logger log = LoggerFactory.getLogger(MemberService.class);

    private final MemberMapper mapper;

    private final MemberRepository repository;

    public List<MemberCard> findAll() {
        log.info("[Service] Find all members");

        return repository.findAll()
                .stream()
                .map(mapper::toMember)
                .toList();
    }

    public MemberCard findById(Long id){
        log.info("[Service] find member by id={}", id);

        var member = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not member with id=" + id));
        return mapper.toMember(member);
    }

    public MemberCard create(MemberCard memberToCreate) {
        log.info("[Service] Create member: {}", memberToCreate);

        var memberToSave = mapper.toEntity(memberToCreate);
        memberToSave = repository.save(memberToSave);

        return mapper.toMember(memberToSave);
    }

    public MemberCard update(Long id, MemberCard memberToUpdate) {
        log.info("[Service] Update member by id={}", id);

        var memberToSave = mapper.toEntity(memberToUpdate);
        memberToSave.setId(id);
        repository.save(memberToSave);

        return mapper.toMember(memberToSave);
    }

    public void delete(Long id) {
        log.info("[Service] Delete member by id={}", id);
        repository.deleteById(id);
    }
}
