package com.andzwp.userservice.services;

import com.andzwp.userservice.dto.User;
import com.andzwp.userservice.exceptions.UserIsAlreadyCreatedException;

public interface UserService {

    User save(User user );

    User fetchUserById(long id);

    User fetchUserByEmail(String email);


}
