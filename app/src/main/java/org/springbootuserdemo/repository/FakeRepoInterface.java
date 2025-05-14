package org.springbootuserdemo.repository;

import org.springbootuserdemo.model.User;

public interface FakeRepoInterface {
    // Method to add a new user
     void insertUser(User user); 

     // Method to find/get user
     User findUserById(String id); 
    
}
