package com.andzwp.userservice.services;

import com.andzwp.userservice.dto.RoleDTO;
import com.andzwp.userservice.dto.UserDTO;
import com.andzwp.userservice.dto.UserRequest;
import com.andzwp.userservice.exceptions.NoSuchEntityException;
import com.andzwp.userservice.mappers.UserMapper;
import com.andzwp.userservice.repositories.UserRepository;
import com.andzwp.userservice.utils.PasswordUtil;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public UserDTO save(@NonNull UserRequest userRequest) {

        var user = new UserDTO(
                0,
                userRequest.email(),
                userRequest.password(),
                new RoleDTO(1, "ROLE_USER")

        );

        var userEntity = userMapper.convertUserDTOToUser(user);
        var password = userEntity.getPassword();

        userEntity.setPassword(passwordUtil.hashPassword(password));

        return userMapper.convertUserToUserDTO(
                userRepository.save(userEntity)
        );

    }

    @Override
    public UserDTO fetchUserById(long id) throws NoSuchEntityException {
        var userEntity = userRepository.findById(id);
        return userMapper.convertUserToUserDTO(
                userEntity.orElseThrow(NoSuchEntityException::new)
        );
    }

    @Override
    public UserDTO fetchUserByEmail(String email) throws NoSuchEntityException {
        var userEntity = userRepository.findUserByEmail(email);
        return userMapper.convertUserToUserDTO(
                userEntity.orElseThrow(NoSuchEntityException::new)
        );
    }

    @Override
    public List<UserDTO> fetchAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::convertUserToUserDTO)
                .toList();
    }

    @Override
    public void deleteUserById(long id) throws NoSuchEntityException {
        if (userRepository.findById(id).isEmpty()) throw new NoSuchEntityException();
        else userRepository.deleteById(id);
    }
}
