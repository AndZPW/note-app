package com.andzwp.userservice.dao;

import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
@Builder

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)

    @Column(name = "users_id",nullable = false)
    private int id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;



    @JoinColumn( name = "role_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;
}
