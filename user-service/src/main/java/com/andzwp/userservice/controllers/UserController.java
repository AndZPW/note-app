package com.andzwp.userservice.controllers;


import com.andzwp.userservice.dto.ErrorResponse;
import com.andzwp.userservice.dto.User;
import com.andzwp.userservice.dto.UserRequest;
import com.andzwp.userservice.exceptions.NoSuchUserException;
import com.andzwp.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {


    @Qualifier("default-service")
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(params = {"id"})
    public User fetchUserById(@Param("id") long id) throws NoSuchUserException {
        return userService.fetchUserById(id);
    }

    @GetMapping(params = {"email"})
    public User fetchUserById(@Param("email") String email) throws NoSuchUserException {
        return userService.fetchUserByEmail(email);
    }

    @PostMapping
    public User createUser(@RequestBody UserRequest userRequest){
        return userService.save(userRequest);
    }

}
