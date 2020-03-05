package com.thoughtworks.repositories;


import com.thoughtworks.data.UserData;
import com.thoughtworks.entities.User;

import java.util.List;

public class UserRepository implements UserRepositoryI {
    private List<User> users = UserData.userLists;

    public User getUserByNameAndPassword(String name, String password) {
        for (User user : users) {
            if (name.equals(user.getName()) && password.equals(user.getPassword())) {
                return user;
            }
        }
        return new User();
    }

    public User userRegister(User user) {
        users.add(user);
        return user;
    }
}
