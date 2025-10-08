package com.nso.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URL;

@Getter
@Setter
@Entity
@Table(name = "event")
@AllArgsConstructor
@NoArgsConstructor
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "url_to_photo")
    private URL photoUrl;

    @Column(name = "name")
    private String name;

    @Column(name = "url_to_post")
    private URL urlToPost;

    @Column(name = "description")
    private String description;

    @Column(name = "url_supervisor")
    private URL supervisor;

    @Column(name = "url_organized_team")
    private URL organizedTeam;

    @Column(name = "available")
    private boolean available;
}
