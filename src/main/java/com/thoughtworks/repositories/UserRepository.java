package com.thoughtworks.repositories;


import com.thoughtworks.entities.User;


public class UserRepository implements UserRepositoryI {

    public User getUserByNameAndPassword(String userName, String password) {

        return new User();
    }

    public void userRegister(User user) {

    }
}
