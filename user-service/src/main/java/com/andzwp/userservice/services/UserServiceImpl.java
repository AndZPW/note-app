package com.andzwp.userservice.services;

import com.andzwp.userservice.dto.Role;
import com.andzwp.userservice.dto.User;
import com.andzwp.userservice.dto.UserRequest;
import com.andzwp.userservice.exceptions.NoSuchUserException;
import com.andzwp.userservice.mappers.UserMapper;
import com.andzwp.userservice.repositories.UserRepository;
import com.andzwp.userservice.utils.PasswordUtil;
import org.springframework.stereotype.Service;

@Service("default-service")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRequest userRequest) {

        var user = new User(
                0,
                userRequest.email(),
                userRequest.password(),
                new Role(1, "User")

        );

        var userEntity = UserMapper.convertUserToUserEntity(user);
        var password = userEntity.getPassword();

        userEntity.setPassword(PasswordUtil.hashPassword(password));

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
