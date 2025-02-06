package com.shiv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shiv.model.User;
import com.shiv.service.UserService;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Signup Endpoint
    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        return userService.signup(user);
    }

    // Login Endpoint
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        return userService.login(email, password);
    }

    // Get All Registered Users
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Update User Information
    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // Delete User
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
