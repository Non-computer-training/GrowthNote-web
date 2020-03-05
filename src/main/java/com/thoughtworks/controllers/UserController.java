package com.thoughtworks.controllers;


import com.thoughtworks.entities.User;
import com.thoughtworks.services.UserService;
import com.thoughtworks.services.UserServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/api/users")
public class UserController {
    private UserServiceI userService = new UserService();

    @GetMapping("")
    public ResponseEntity<User> getUserByNameAndPassword(@PathParam("name") String name, @PathParam("password") String password) {
        User user = userService.getUserByNameAndPassword(name, password);
        return ResponseEntity.ok(user);
    }

    @PostMapping("")
    public ResponseEntity<User> userRegister(@RequestBody User user) {
        User userResult = userService.userRegister(user.getName(), user.getPassword());
        return ResponseEntity.ok(userResult);
    }
}
