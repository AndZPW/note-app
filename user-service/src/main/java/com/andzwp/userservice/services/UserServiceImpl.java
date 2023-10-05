package com.andzwp.userservice.services;

import com.andzwp.userservice.dto.User;
import com.andzwp.userservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service("default-service")
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User fetchUserById(long id) {
        return null;
    }

    @Override
    public User fetchUserByEmail(String email) {
        return null;
    }
}
