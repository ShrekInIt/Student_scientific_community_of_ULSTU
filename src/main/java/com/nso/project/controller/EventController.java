package com.nso.project.controller;

import com.nso.project.dto.card.EventCard;
import com.nso.project.service.EventService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {
    
    private static final Logger log = LoggerFactory.getLogger(EventController.class);
    
    private final EventService service;

    @GetMapping
    public ResponseEntity<List<EventCard>> findAllEvents() {
        log.info("[Controller] find all members");
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventCard> findEventById(@PathVariable Long id) {
        log.info("[Controller] find member by id: {}", id);
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<EventCard> createEvent(@RequestBody EventCard EventCard) {
        log.info("[Controller] Create a new member: {}", EventCard);
        return ResponseEntity.ok(service.create(EventCard));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventCard> updateEvent(
            @PathVariable Long id,
            @RequestBody EventCard EventCard
    ) {
        log.info("[Controller] Update a member: {}", EventCard);
        return ResponseEntity.ok(service.update(id, EventCard));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EventCard> deleteEvent(@PathVariable Long id) {
        log.info("[Controller] Delete a member: {}", id);
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
