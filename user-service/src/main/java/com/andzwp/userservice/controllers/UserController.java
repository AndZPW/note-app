package com.andzwp.userservice.controllers;


import com.andzwp.userservice.dto.UserDTO;
import com.andzwp.userservice.dto.UserRequest;
import com.andzwp.userservice.exceptions.NoSuchEntityException;
import com.andzwp.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {


//    @Value("$test")
//    private String test;

    @Qualifier("default-service")
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public UserDTO fetchUserById(@PathVariable("id") long id) throws NoSuchEntityException {
        System.out.println("inside id");
        return userService.fetchUserById(id);
    }

    @GetMapping(params = {"email"})
    public ResponseEntity<?> fetchUserById(@RequestParam(value = "email", defaultValue = "") String email) throws NoSuchEntityException {
        return ResponseEntity.ok(
                switch (email) {
                    case "" -> userService.fetchAll();
                    default -> (userService.fetchUserByEmail(email));

                });
        //return ResponseEntity.ok(CollectionModel.of());
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserRequest userRequest) {
        return userService.save(userRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id) throws NoSuchEntityException {
        userService.deleteUserById(id);
    }
}
