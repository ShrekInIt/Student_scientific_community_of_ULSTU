package com.nso.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Getter
@Setter
@AllArgsConstructor
public class Organizer {

    private Long id;

    /// Имя
    private String name;

    /// Фамилия
    private String surname;

    /// Отчество
    private String patronymic;

    /// Ссылка на карточку
    private URL urlToCard;

    /// Должность
    private OrganizerPost post;

    /// Логин
    private String email;

    /// Контактный номер телефона
    private String contactPhone;
}
