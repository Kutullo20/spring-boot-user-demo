package org.springbootuserdemo.service;

import org.springbootuserdemo.model.User;
import org.springbootuserdemo.repository.FakeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Marks this class as a Spring service component
@Service  
public class UserServiceImpl implements UserService {
    private final FakeRepo fakeRepo;

    //injects FakeRepo dependency
    @Autowired  
    public UserServiceImpl(FakeRepo fakeRepo) {
        this.fakeRepo = fakeRepo;
    }

    @Override
    public void addUser(String name, String surname) {
        // Create new user and add to repository
        User newUser = new User(name, surname);
        fakeRepo.insertUser(newUser);
    }

    // Delegates to repository to find and return user by ID (may return null)
    @Override
    public User getUser(String id) {
        return fakeRepo.findUserById(id);
    }

    // Removes a user by ID by delegating to the repository's deleteUser method
    @Override
    public void removeUser(String id) {
        fakeRepo.deleteUser(id);
    }
   
}
