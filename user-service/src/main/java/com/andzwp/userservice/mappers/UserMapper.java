package com.andzwp.userservice.mappers;

import com.andzwp.userservice.dao.RoleEntity;
import com.andzwp.userservice.dao.UserEntity;
import com.andzwp.userservice.dto.Role;
import com.andzwp.userservice.dto.User;
import lombok.NonNull;


public class UserMapper {

    private UserMapper() {
        throw new RuntimeException();
    }

    public static User mapDAOToDTO(@NonNull UserEntity userEntity) {

        var roleEntity = userEntity.getRole();

        var role = new Role(roleEntity.getId(), roleEntity.getName());

        return User.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .role(role)
                .build();
    }

    public static UserEntity mapDTOToDAO(@NonNull User user) {

        var role = user.role();

        var roleEntity = new RoleEntity(role.id(), role.name());

        return UserEntity.builder()
                .id(user.id())
                .email(user.email())
                .password(user.password())
                .role(roleEntity)
                .build();
    }
}
