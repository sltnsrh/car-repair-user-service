package com.salatin.carrepairuserservice.service;

import com.salatin.carrepairuserservice.model.User;

public interface UserService {
    User save(User user);

    User findByEmail(String email);
}
