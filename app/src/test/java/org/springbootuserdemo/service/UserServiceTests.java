package org.springbootuserdemo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springbootuserdemo.repository.FakeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTests {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private FakeRepo fakeRepo;

    @BeforeEach
    void setUp() {
        fakeRepo.clearDatabase();
    }

    @Test
    void testAddMultipleUsers() {
        System.out.println("\n=== Testing Multiple User Addition ===");
        
        // Add first user
        userService.addUser("John", "Doe");
        assertEquals(1, fakeRepo.getUserCount(), "Should have 1 user");
        fakeRepo.printAllUsers();
        
        // Add second user
        userService.addUser("Jane", "Smith");
        assertEquals(2, fakeRepo.getUserCount(), "Should have 2 users");
        fakeRepo.printAllUsers();
        
        // Add third user
        userService.addUser("Alice", "Boss" );
        assertEquals(3, fakeRepo.getUserCount(), "Should have 3 users");
        fakeRepo.printAllUsers();
        
        System.out.println("=== Test Passed: All users added successfully ===");
    }
}