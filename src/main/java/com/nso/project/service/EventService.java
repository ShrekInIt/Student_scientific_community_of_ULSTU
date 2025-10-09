package com.nso.project.service;

import com.nso.project.dto.card.EventCard;
import com.nso.project.mapper.EventMapper;
import com.nso.project.repository.EventRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private static final Logger log = LoggerFactory.getLogger(EventService.class);

    private final EventRepository repository;

    private final EventMapper mapper;

    public EventService(EventRepository repository, EventMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<EventCard> findAll() {

        log.info("[Service] Find all events");
        return repository.findAll()
                .stream()
                .map(mapper::toEvent)
                .toList();
    }

    public EventCard findById(Long id) {

        log.info("[Service] Find event by id={}", id);
        var event = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Event not found with id " + id));

        return mapper.toEvent(event);
    }

    public EventCard create(EventCard eventToCreate) {
        log.info("[Service] Create event: {}", eventToCreate);

        var eventToSave = mapper.toEntity(eventToCreate);
        repository.save(eventToSave);
        return mapper.toEvent(eventToSave);
    }

    public EventCard update(Long id, EventCard eventToUpdate) {
        log.info("[Service] Update event by id={}", id);

        var eventToSave = mapper.toEntity(eventToUpdate);
        eventToSave.setId(id);
        repository.save(eventToSave);

        return mapper.toEvent(eventToSave);
    }

    public void delete(Long id) {
        log.info("[Service] Delete event by id={}", id);
        repository.deleteById(id);
    }
}
