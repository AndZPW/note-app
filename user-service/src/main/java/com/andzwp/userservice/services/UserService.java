package com.andzwp.userservice.services;

import com.andzwp.userservice.dto.UserDTO;
import com.andzwp.userservice.dto.UserRequest;
import com.andzwp.userservice.exceptions.NoSuchUserException;

public interface UserService {

    UserDTO save(UserRequest userRequest );

    UserDTO fetchUserById(long id) throws NoSuchUserException;

    UserDTO fetchUserByEmail(String email) throws NoSuchUserException;


}
