package com.thoughtworks.services;

import com.thoughtworks.entities.User;
import com.thoughtworks.repositories.UserRepository;
import com.thoughtworks.repositories.UserRepositoryI;
import org.springframework.util.DigestUtils;

import java.util.UUID;

public class UserService implements UserServiceI {
    private UserRepositoryI userRepository = new UserRepository();

    public User getUserByNameAndPassword(String name, String password) {
        String passwordMd5 = DigestUtils.md5DigestAsHex(password.getBytes());
        return userRepository.getUserByNameAndPassword(name, passwordMd5);
    }

    public User userRegister(String name, String password) {
        String passwordMd5 = DigestUtils.md5DigestAsHex(password.getBytes());
        return userRepository.userRegister(new User(UUID.randomUUID().toString(), name, passwordMd5));
    }
}
