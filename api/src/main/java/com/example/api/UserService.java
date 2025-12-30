package com.example.api;

import java.util.Optional;

public interface UserService {
    Optional<User> getUser(Long id);
    void updateUser(User user);
    User create(String name);
}
    