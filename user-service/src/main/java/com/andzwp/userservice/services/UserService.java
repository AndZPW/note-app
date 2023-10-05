package com.andzwp.userservice.services;

import com.andzwp.userservice.dto.User;
import com.andzwp.userservice.exceptions.NoSuchUserException;
import com.andzwp.userservice.exceptions.UserIsAlreadyCreatedException;

public interface UserService {

    User save(User user );

    User fetchUserById(long id) throws NoSuchUserException;

    User fetchUserByEmail(String email);


}
