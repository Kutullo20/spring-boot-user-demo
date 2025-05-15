package org.springbootuserdemo.repository;

import org.springbootuserdemo.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FakeRepo implements FakeRepoInterface {
    private final List<User> userDatabase = new ArrayList<>();
    
    @Override
    public void insertUser(User user) {
        userDatabase.add(user);
        System.out.println("INSERTED USER: " + user + " (ID: " + user.getId() + ")");
    }

    // Searches for user by ID using stream filter, returns null if not found
    @Override
    public User findUserById(String id) {
        System.out.println("SEARCHING FOR USER WITH ID: " + id);
        return userDatabase.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    //delete a user  from the in-memory database
    @Override
    public void deleteUser(String id) {
        User userToDelete = findUserById(id);
        if (userToDelete != null) {
            userDatabase.remove(userToDelete);
            System.out.println("DELETED USER: " + userToDelete + " (ID: " + id + ")");
        } else {
            System.out.println("USER NOT FOUND FOR DELETION WITH ID: " + id);
        }
    }
    
    // Test helper methods
    public int getUserCount() {
        return userDatabase.size();
    }
    
    public User getFirstUser() {
        return userDatabase.isEmpty() ? null : userDatabase.get(0);
    }
    
    public void clearDatabase() {
        userDatabase.clear();
        System.out.println("Database cleared - ready for new test");
    }
    
    // Method to get all added users
    public List<User> getAllUsers() {
        return new ArrayList<>(userDatabase); 
    }
    
    // Method to print added users
    public void printAllUsers() {
        if (userDatabase.isEmpty()) {
            System.out.println("No users in database");
            return;
        }
        System.out.println("CURRENTLY STORED USERS (" + getUserCount() + "):");
        userDatabase.forEach(user -> 
            System.out.println("  • " + user.getName() + " " + user.getSurname() + " (ID: " + user.getId() + ")")
                                                                                    
        );
    }
}