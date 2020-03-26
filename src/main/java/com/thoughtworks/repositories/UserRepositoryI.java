package com.thoughtworks.repositories;

import com.thoughtworks.entities.User;

public interface UserRepositoryI {
    User getUserByNameAndPassword(String userName, String password);

    void userRegister(User user);
}
