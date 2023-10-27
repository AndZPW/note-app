package com.andzwp.userservice.services;

import com.andzwp.userservice.dto.Role;
import com.andzwp.userservice.dto.User;
import com.andzwp.userservice.dto.UserRequest;
import com.andzwp.userservice.exceptions.NoSuchUserException;
import com.andzwp.userservice.mappers.UserMapper;
import com.andzwp.userservice.repositories.UserRepository;
import com.andzwp.userservice.utils.PasswordUtil;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service("default-service")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordUtil passwordUtil;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, PasswordUtil passwordUtil, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordUtil = passwordUtil;
        this.userMapper = userMapper;
    }

    @Override
    public User save(@NonNull UserRequest userRequest) {

        var user = new User(
                0,
                userRequest.email(),
                userRequest.password(),
                new Role(1, "ROLE_USER")

        );

        var userEntity = userMapper.convertUserToUserEntity(user);
        var password = userEntity.getPassword();

        userEntity.setPassword(passwordUtil.hashPassword(password));

        return userMapper.convertUserEntityToUser(
                userRepository.save(userEntity)
        );

    }

    @Override
    public User fetchUserById(long id) throws NoSuchUserException {
        var userEntity = userRepository.findById(id);
        return userMapper.convertUserEntityToUser(
                userEntity.orElseThrow(NoSuchUserException::new)
        );
    }

    @Override
    public User fetchUserByEmail(String email) throws NoSuchUserException {
        var userEntity = userRepository.findUserByEmail(email);
        return userMapper.convertUserEntityToUser(
                userEntity.orElseThrow(NoSuchUserException::new)
        );
    }
}
