package com.salatin.userservice.security;

public interface BlacklistRepository {
    void add(String token, String username);

    boolean isLoggedOut(String token);
}
