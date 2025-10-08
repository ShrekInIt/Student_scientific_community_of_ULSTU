package com.nso.project.entity.card;

import com.nso.project.entity.OrganizedTeam;
import com.nso.project.entity.Supervisor;
import com.nso.project.entity.intetfaceEntity.Card;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EventCard implements Card {
    //ссылка на фотографию, которая хранится в бд
    private String photoUrl;

    //Название
    private String name;

    //Ссылка на альбом или пост в ВКонтакте
    private String urlToPost;

    //Описание
    private String description;

    //Руководитель
    private Supervisor supervisor;

    //Команда организаторов
    private OrganizedTeam organizedTeam;

    //Доступна ли карточка
    private boolean available;

    //Конструктор
    public EventCard(String photoUrl, String name, String urlToPost,
                     String description, Supervisor supervisor, OrganizedTeam organizedTeam) {
        this.photoUrl = photoUrl;
        this.name = name;
        this.urlToPost = urlToPost;
        this.description = description;
        this.supervisor = supervisor;
        this.organizedTeam = organizedTeam;
    }
}
