package com.example.impl;

import com.example.api.User;
import com.example.api.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class UserServiceImpl implements UserService {
    private final Map<Long, Optional<User>> users = new HashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    @Override
    public Optional<User> getUser(Long id) {
        return users.get(id);
    }

    @Override
    public void updateUser(User user) {
        if (user.getId() == null) {
            user.setId(Long.valueOf(UUID.randomUUID().toString()));
        }
        users.put(user.getId(), Optional.of(user));
    }

    @Override
    public User create(String name) {
        long id = seq.getAndIncrement();
        User u = new User(id, name);
        users.put(id, Optional.of(u));
        return u;
    }
}

