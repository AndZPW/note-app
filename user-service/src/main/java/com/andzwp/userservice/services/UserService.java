package com.andzwp.userservice.services;

import com.andzwp.userservice.dto.UserDTO;
import com.andzwp.userservice.dto.UserRequest;
import com.andzwp.userservice.exceptions.NoSuchEntityException;

import java.util.List;

public interface UserService {

    UserDTO save(UserRequest userRequest );

    UserDTO fetchUserById(long id) throws NoSuchEntityException;

    UserDTO fetchUserByEmail(String email) throws NoSuchEntityException;

    List<UserDTO> fetchAll();

    void deleteUserById(long id) throws NoSuchEntityException;


}
