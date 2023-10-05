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
    private long id;

    private String email;

    private String password;

    @JoinColumn(table = "roles")
    @ManyToOne(fetch = FetchType.LAZY)
    private RoleEntity role;
}
