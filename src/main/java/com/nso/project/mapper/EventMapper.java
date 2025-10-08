package com.nso.project.mapper;

import com.nso.project.dto.card.EventCard;
import com.nso.project.entity.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public EventCard toEvent(EventEntity entity) {
        return new  EventCard(
                entity.getId(),
                entity.getPhotoUrl(),
                entity.getName(),
                entity.getUrlToPost(),
                entity.getDescription(),
                entity.getSupervisor(),
                entity.getOrganizedTeam(),
                entity.isAvailable()
        );
    }

    public EventEntity toEntity(EventCard event) {
        return new  EventEntity(
                event.getId(),
                event.getPhotoUrl(),
                event.getName(),
                event.getUrlToPost(),
                event.getDescription(),
                event.getSupervisor(),
                event.getOrganizedTeam(),
                event.isAvailable()
        );
    }
}
