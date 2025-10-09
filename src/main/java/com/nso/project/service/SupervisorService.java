package com.nso.project.service;

import com.nso.project.dto.Supervisor;
import com.nso.project.mapper.SupervisorMapper;
import com.nso.project.repository.SupervisorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SupervisorService {

    private static final Logger log = LoggerFactory.getLogger(SupervisorService.class);

    private SupervisorRepository repository;

    private SupervisorMapper mapper;

    public List<Supervisor> findAll() {
        log.info("[Service] find all supervisors");

        return repository.findAll()
                .stream()
                .map(mapper::toSupervisor)
                .toList();
    }

    public Supervisor findById(Long id) {
        log.info("[Service] find supervisor by id: {}", id);

        var supervisor = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Supervisor with id " + id + " not found"));

        return mapper.toSupervisor(supervisor);
    }

    public Supervisor create(Supervisor supervisorToCreate) {
        log.info("[Service] create supervisor: {}", supervisorToCreate);

        var supervisorToSave = mapper.toEntity(supervisorToCreate);
        repository.save(supervisorToSave);
        return mapper.toSupervisor(supervisorToSave);
    }

    public Supervisor update(Long id, Supervisor supervisorToUpdate) {
        log.info("[Service] update supervisor by id={}", id);

        var supervisorToSave = mapper.toEntity(supervisorToUpdate);
        supervisorToSave.setId(id);
        repository.save(supervisorToSave);
        return mapper.toSupervisor(supervisorToSave);
    }

    public void delete(Long id) {
        log.info("[Service] delete supervisor by id: {}", id);
        repository.deleteById(id);
    }
}
