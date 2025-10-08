package com.nso.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Getter
@Setter
@AllArgsConstructor
public class Supervisor {

    private Long id;

    /// Имя
    private String name;

    /// Фамилия
    private String surname;

    /// Отчество
    private String patronymic;

    /// Логин
    private String email;

    /// Конактный номер телефона
    private String contactPhone;

    /// Ссылка на карточку
    private URL urlToCard;
}
