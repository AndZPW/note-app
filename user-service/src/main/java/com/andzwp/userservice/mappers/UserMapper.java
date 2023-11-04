package com.andzwp.userservice.mappers;

import com.andzwp.userservice.dao.User;
import com.andzwp.userservice.dto.UserDTO;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public UserDTO convertUserToUserDTO(@NonNull User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User convertUserDTOToUser(@NonNull UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
