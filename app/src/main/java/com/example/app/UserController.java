package com.example.app;

import com.example.api.UserService;

public class UserController {
    private final UserService userService;

    public UserController() {
        this.userService = UserServiceLocator.getUserService();
    }

    public void handleUserUpdate(Long id) {
         userService.getUser(id).ifPresent(userService::updateUser);
    }
}