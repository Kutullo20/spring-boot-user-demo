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
   
}
