package com.thoughtworks.services;

import com.thoughtworks.entities.User;
import com.thoughtworks.repositories.UserRepository;
import com.thoughtworks.repositories.UserRepositoryI;
import org.springframework.util.DigestUtils;

public class UserService implements UserServiceI {
    private UserRepositoryI userRepository = new UserRepository();

    public User getUserByNameAndPassword(String userName, String password) {
        String passwordMd5 = DigestUtils.md5DigestAsHex(password.getBytes());
        return userRepository.getUserByNameAndPassword(userName, passwordMd5);
    }

    public void userRegister(String userName, String password) {
        String passwordMd5 = DigestUtils.md5DigestAsHex(password.getBytes());
        userRepository.userRegister(new User(userName, passwordMd5));
    }
}
