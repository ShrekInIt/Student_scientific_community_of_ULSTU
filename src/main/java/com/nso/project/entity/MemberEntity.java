package com.nso.project.entity;

import com.nso.project.dto.card.MemberPost;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URL;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "member")
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "url_to_photo")
    private URL photoUrl;

    @Column(name = "name")
    private String nameAuthor;

    @Column(name = "surname")
    private String surNameAuthor;

    @Column(name = "patronymic")
    private String patronymicAuthor;

    @Enumerated(EnumType.STRING)
    @Column(name = "post")
    private MemberPost post;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String contactPhone;

    @Column(name = "about_me")
    private String aboutMe;

    @Column(name = "url_events")
    private List<URL> events;

    @Column(name = "available")
    private boolean available;
}
