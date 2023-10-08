package com.andzwp.userservice.services;

import com.andzwp.userservice.dto.User;
import com.andzwp.userservice.dto.UserRequest;
import com.andzwp.userservice.exceptions.NoSuchUserException;

public interface UserService {

    User save(UserRequest userRequest );

    User fetchUserById(long id) throws NoSuchUserException;

    User fetchUserByEmail(String email) throws NoSuchUserException;


}
