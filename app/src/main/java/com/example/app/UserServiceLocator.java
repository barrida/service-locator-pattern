package com.example.app;

import com.example.api.UserService;

import java.util.ServiceLoader;

public class UserServiceLocator {
    private static final ServiceLoader<UserService> loader = ServiceLoader.load(UserService.class);

    public static UserService getUserService() {
        return loader.findFirst()
        .orElseThrow(() -> new IllegalStateException("No UserService implementation found"));
    }
}
