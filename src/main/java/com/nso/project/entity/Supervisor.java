package com.nso.project.entity;

import com.nso.project.entity.intetfaceEntity.Organizer;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Getter
@Setter
public class Supervisor implements Organizer {
    //Имя
    private String name;

    //Ссылка на карточку
    private URL urlToCard;

    public Supervisor(String name, URL urlToCard) {
        this.name = name;
        this.urlToCard = urlToCard;
    }
}
