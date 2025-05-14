package org.springbootuserdemo.service;

import org.springbootuserdemo.model.User;

public interface UserService {
    // Method to add a new user
    void addUser(String name, String surname); 
    
    //Returns the User with the given ID or null if not found
    User getUser(String id); 
}