package org.springbootuserdemo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springbootuserdemo.repository.FakeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springbootuserdemo.model.User;

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

    @Test
    void testGetExistingUser() {
        System.out.println("\n=== Testing Get Existing User ===");
        
        // Add a test user
        userService.addUser("Test", "User");
        User addedUser = fakeRepo.getFirstUser();
        assertNotNull(addedUser, "User should be added");
        
        // Retrieve the user
        User foundUser = userService.getUser(addedUser.getId());
        
        // Verify
        assertNotNull(foundUser, "User should be found");
        assertEquals(addedUser.getId(), foundUser.getId(), "IDs should match");
        assertEquals("Test", foundUser.getName(), "Names should match");
        assertEquals("User", foundUser.getSurname(), "Surnames should match");
        
        System.out.println("Retrieved user: " + foundUser);
        System.out.println("=== Test Passed: User retrieved successfully ===");
    }

    @Test
    void testGetNonExistentUser() {
        System.out.println("\n=== Testing Get Non-Existent User ===");
        
        // Try to get a user that doesn't exist
        User foundUser = userService.getUser("non-existent-id");
        
        // Verify
        assertNull(foundUser, "Should return null for non-existent user");
        
        System.out.println("=== Test Passed: Correctly returned null for non-existent user ===");
    }

    @Test
    void testGetUserWithEmptyDatabase() {
        System.out.println("\n=== Testing Get User With Empty Database ===");
        
        // Verify database is empty
        assertEquals(0, fakeRepo.getUserCount(), "Database should be empty");
        
        // Try to get any user
        User foundUser = userService.getUser("any-id");
        
        // Verify
        assertNull(foundUser, "Should return null when database is empty");
        
        System.out.println("=== Test Passed: Correctly handled empty database case ===");
    }

    @Test
    void testGetUserWithNullId() {
        System.out.println("\n=== Testing Get User With Null ID ===");
        
        // Add a test user
        userService.addUser("Null", "Test");
        
        // Try to get with null ID
        User foundUser = userService.getUser(null);
        
        // Verify
        assertNull(foundUser, "Should return null for null ID");
        
        System.out.println("=== Test Passed: Correctly handled null ID case ===");
    }
}