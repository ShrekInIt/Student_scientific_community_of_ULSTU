package com.nso.project.controller;

import com.nso.project.dto.Organizer;
import com.nso.project.service.OrganizerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizer")
@RequiredArgsConstructor
public class OrganizerController {

    private static final Logger log = LoggerFactory.getLogger(OrganizerController.class);

    private final OrganizerService service;

    @GetMapping
    public ResponseEntity<List<Organizer>> findAllOrganizers() {
        log.info("[Controller] find all organizers");
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organizer> findOrganizerById(@PathVariable Long id) {
        log.info("[Controller] find organizer by id: {}", id);
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Organizer> createOrganizer(@RequestBody Organizer organizer) {
        log.info("[Controller] Create organizer: {}", organizer);
        return ResponseEntity.ok(service.create(organizer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Organizer> updateOrganizer(
            @PathVariable Long id,
            @RequestBody Organizer organizer
    ) {
        log.info("[Controller] Update organizer by id={}", id);
        return ResponseEntity.ok(service.update(id, organizer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Organizer> deleteOrganizer(@PathVariable Long id) {
        log.info("[Controller] Delete organizer by id: {}", id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
