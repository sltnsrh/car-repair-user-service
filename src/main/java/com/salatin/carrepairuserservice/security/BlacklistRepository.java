package com.salatin.carrepairuserservice.security;

public interface BlacklistRepository {
    void add(String token, String username);

    boolean isLoggedOut(String token);
}
