package com.thoughtworks.repositories;

import com.thoughtworks.entities.User;

public interface UserRepositoryI {
    User getUserByNameAndPassword(String name, String password);

    User userRegister(User user);
}
