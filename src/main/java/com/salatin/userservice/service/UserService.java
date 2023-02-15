package com.salatin.userservice.service;

import com.salatin.userservice.model.User;

public interface UserService {
    User save(User user);

    User findByEmail(String email);
}
