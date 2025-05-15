package org.springbootuserdemo.model;

import java.util.UUID;

public class User {

    private String id;      // Unique identifier for the user
    private String name;    // User's first name
    private String surname; // User's last name

    // Constructor to create a new User with generated ID
    public User(String name, String surname) {
        this.id = UUID.randomUUID().toString(); // Auto-generate unique ID
        this.name = name;
        this.surname = surname;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    // For printing user information
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
    
}
