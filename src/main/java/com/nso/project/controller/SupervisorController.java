package com.nso.project.controller;

import com.nso.project.dto.Supervisor;
import com.nso.project.repository.SupervisorRepository;
import com.nso.project.service.SupervisorService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supervisor")
@RequiredArgsConstructor
public class SupervisorController {

    private static final Logger log = LoggerFactory.getLogger(SupervisorController.class);

    private final SupervisorService service;

    @GetMapping
    public ResponseEntity<List<Supervisor>> findAllSupervisor() {
        log.info("[Service] findAllSupervisor");
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supervisor> findSupervisorById(@PathVariable Long id) {
        log.info("[Service] findSupervisorById: {}", id);
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Supervisor> createSupervisor(@RequestBody Supervisor supervisor) {
        log.info("[Service] createSupervisor: {}", supervisor);
        return ResponseEntity.ok(service.create(supervisor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supervisor> updateSupervisor(
            @PathVariable Long id,
            @RequestBody Supervisor supervisor
    ) {
        log.info("[Service] updateSupervisor by id={}", id);
        return ResponseEntity.ok(service.update(id, supervisor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Supervisor> deleteSupervisor(@PathVariable Long id) {
        log.info("[Service] deleteSupervisor: {}", id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
