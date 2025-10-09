package com.nso.project.dto.card;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;


@Getter
@Setter
@AllArgsConstructor
public class EventCard {

    private Long id;

    //ссылка на фотографию, которая хранится в бд
    private URL photoUrl;

    //Название
    private String name;

    //Ссылка на альбом или пост в ВКонтакте
    private URL urlToPost;

    //Описание
    private String description;

    //Руководитель
    private URL supervisor;

    //Команда организаторов
    private URL organizedTeam;

    //Доступна ли карточка
    private boolean available;
}
