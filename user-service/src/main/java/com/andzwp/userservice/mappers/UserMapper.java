package com.andzwp.userservice.mappers;

import com.andzwp.userservice.dao.RoleEntity;
import com.andzwp.userservice.dao.UserEntity;
import com.andzwp.userservice.dto.Role;
import com.andzwp.userservice.dto.User;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {



    public User convertUserEntityToUser(@NonNull UserEntity userEntity) {

        var roleEntity = userEntity.getRole();

        var role = new Role(roleEntity.getId(), roleEntity.getName());

        return User.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .role(role)
                .build();
    }

    public UserEntity convertUserToUserEntity(@NonNull User user) {

        var role = user.role();

        var roleEntity = new RoleEntity(role.id(), role.name());

        return UserEntity.builder()

                .email(user.email())
                .password(user.password())
                .role(roleEntity)
                .build();
    }
}
