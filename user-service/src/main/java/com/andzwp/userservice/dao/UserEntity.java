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

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id",nullable = false)
    private long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;



    @JoinColumn( name = "role_id",nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private RoleEntity role;
}
