package com.andzwp.userservice.controllers;


import com.andzwp.userservice.dto.UserDTO;
import com.andzwp.userservice.dto.UserRequest;
import com.andzwp.userservice.exceptions.NoSuchUserException;
import com.andzwp.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

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
//    @GetMapping("test")
//    public String fetchU()  {
//        return test;
//    }
    @GetMapping("/{id}")
    public UserDTO fetchUserById(@PathVariable("id") long id) throws NoSuchUserException {
        System.out.println("inside id");
        return userService.fetchUserById(id);
    }

    @GetMapping("/{email}")
    public UserDTO fetchUserById(@PathVariable("email") String email) throws NoSuchUserException {
        System.out.println("inside email");
        return userService.fetchUserByEmail(email);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserRequest userRequest){
        return userService.save(userRequest);
    }

}
