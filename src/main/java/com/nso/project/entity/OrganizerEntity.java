package com.nso.project.entity;

import com.nso.project.dto.OrganizerPost;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URL;

@Getter
@Setter
@Entity
@Table(name = "organizer")
@AllArgsConstructor
@NoArgsConstructor
public class OrganizerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "url_to_card")
    private URL urToCard;

    @Enumerated(EnumType.STRING)
    @Column(name = "post")
    private OrganizerPost post;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String contactPhone;
}