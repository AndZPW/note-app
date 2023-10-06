package com.andzwp.userservice.services;

import com.andzwp.userservice.dto.User;
import com.andzwp.userservice.exceptions.NoSuchUserException;
import com.andzwp.userservice.mappers.UserMapper;
import com.andzwp.userservice.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service("default-service")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        var userEntity = UserMapper.convertUserToUserEntity(user);
        return UserMapper.convertUserEntityToUser(
                userRepository.save(userEntity)
        );

    }

    @Override
    public User fetchUserById(long id) throws NoSuchUserException {
        var userEntity = userRepository.findById(id);
        return UserMapper.convertUserEntityToUser(
                userEntity.orElseThrow(NoSuchUserException::new)
        );
    }

    @Override
    public User fetchUserByEmail(String email) throws NoSuchUserException {
        var userEntity = userRepository.findUserByEmail(email);
        return UserMapper.convertUserEntityToUser(
                userEntity.orElseThrow(NoSuchUserException::new)
        );
    }
}
