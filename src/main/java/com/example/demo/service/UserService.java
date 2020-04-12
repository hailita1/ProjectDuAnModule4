package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
    Iterable<User> findAll();

    User findById(Long id);

    void save(User User);

    void remove(Long id);
}
