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
@Table(name = "supervisor")
@AllArgsConstructor
@NoArgsConstructor
public class SupervisorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "contact_phone", nullable = false)
    private String contactPhone;

    @Column(name = "url_to_card")
    private URL urlToCard;
}
