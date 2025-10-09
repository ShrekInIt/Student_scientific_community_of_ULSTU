package com.nso.project.mapper;

import com.nso.project.dto.Supervisor;
import com.nso.project.entity.SupervisorEntity;
import org.springframework.stereotype.Component;

@Component
public class SupervisorMapper {

    public Supervisor toSupervisor(SupervisorEntity entity) {
        return new Supervisor(
                entity.getId(),
                entity.getName(),
                entity.getSurname(),
                entity.getPatronymic(),
                entity.getEmail(),
                entity.getContactPhone(),
                entity.getUrlToCard()
        );
    }

    public SupervisorEntity toEntity(Supervisor supervisor) {
        return new SupervisorEntity(
                supervisor.getId(),
                supervisor.getName(),
                supervisor.getSurname(),
                supervisor.getPatronymic(),
                supervisor.getEmail(),
                supervisor.getContactPhone(),
                supervisor.getUrlToCard()
        );
    }
}
