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
    @Column(name = "users_id")
    private long id;

    private String email;

    private String password;


    @JoinColumn( name = "role_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private RoleEntity role;
}
