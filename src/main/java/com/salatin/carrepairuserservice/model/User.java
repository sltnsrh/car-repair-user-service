package com.salatin.carrepairuserservice.model;

import java.util.List;

public class User {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String mobile;
    private List<Car> cars;
    private List<Order> orders;
}
