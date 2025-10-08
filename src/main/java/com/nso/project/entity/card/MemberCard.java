package com.nso.project.entity.card;

import com.nso.project.entity.intetfaceEntity.Card;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
public class MemberCard implements Card {
    //Фото, которое хранится в бд
    private String photoUrl;

    //Имя автора
    private String nameAuthor;

    //Фамилия автора
    private String surNameAuthor;

    //Отчество автора
    private String patronymicAuthor;

    //Должность
    private String post;

    //Контакты
    private String contact;

    //Поле "О себе"
    private String aboutMe;

    //Доступна ли карточка
    private boolean available;

    //Название и ссылку на событие
    private Map<String, URL> events = new ConcurrentHashMap<>();

}
