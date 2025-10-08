package com.nso.project.mapper;

import com.nso.project.dto.Organizer;
import com.nso.project.entity.OrganizerEntity;
import org.springframework.stereotype.Component;

@Component
public class OrganizerMapper {

    public Organizer toOrganizer(OrganizerEntity entity) {
        return new Organizer(
                entity.getId(),
                entity.getName(),
                entity.getSurname(),
                entity.getPatronymic(),
                entity.getUrToCard(),
                entity.getPost(),
                entity.getEmail(),
                entity.getContactPhone()
        );
    }

    public OrganizerEntity toEntity(Organizer organizer) {
        return new OrganizerEntity(
                organizer.getId(),
                organizer.getName(),
                organizer.getSurname(),
                organizer.getPatronymic(),
                organizer.getUrlToCard(),
                organizer.getPost(),
                organizer.getEmail(),
                organizer.getContactPhone()
        );
    }

}
