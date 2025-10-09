package com.nso.project.dto.card;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class MemberCard {

    private Long id;

    //Фото, которое хранится в бд
    private URL photoUrl;

    //Имя автора
    private String nameAuthor;

    //Фамилия автора
    private String surNameAuthor;

    //Отчество автора
    private String patronymicAuthor;

    //Должность
    private MemberPost post;

    //Логин
    private String email;

    //Пароль
    private String password;

    //Контактный номер телефона
    private String contactPhone;

    //Поле "О себе"
    private String aboutMe;

    //Название и ссылку на событие
    private List<URL> events;

    //Доступна ли карточка
    private boolean available;
}
