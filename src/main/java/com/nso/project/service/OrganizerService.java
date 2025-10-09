package com.nso.project.service;

import com.nso.project.dto.Organizer;
import com.nso.project.mapper.OrganizerMapper;
import com.nso.project.repository.OrganizerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizerService {

    private static final Logger log = LoggerFactory.getLogger(OrganizerService.class);

    private final OrganizerRepository repository;

    private final OrganizerMapper mapper;

    public OrganizerService(OrganizerRepository repository, OrganizerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Organizer> findAll() {
        log.info("[Service] find all organizers");

        return repository.findAll()
                .stream()
                .map(mapper::toOrganizer)
                .toList();
    }

    public Organizer findById(Long id) {
        log.info("[Service] find organizer by id {}", id);

        var organizer = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Organizer not found by id=" + id));

        return mapper.toOrganizer(organizer);
    }

    public Organizer create(Organizer organizerToCreate) {
        log.info("[Service] create organizer: {}", organizerToCreate);

        var organizerToSave = mapper.toEntity(organizerToCreate);
        repository.save(organizerToSave);
        return  mapper.toOrganizer(organizerToSave);
    }

    public Organizer update(Long id, Organizer organizerToUpdate) {
        log.info("[Service] update organizer by id={}", id);

        var organizerToSave = mapper.toEntity(organizerToUpdate);
        organizerToSave.setId(id);
        repository.save(organizerToSave);

        return mapper.toOrganizer(organizerToSave);
    }

    public void delete(Long id) {
        log.info("[Service] delete organizer by id={}", id);
        repository.deleteById(id);
    }
}
