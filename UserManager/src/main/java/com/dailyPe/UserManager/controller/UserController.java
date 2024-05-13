package com.dailyPe.UserManager.controller;

import com.dailyPe.UserManager.model.Manager;
import com.dailyPe.UserManager.model.User;
import com.dailyPe.UserManager.model.request.UpdateRequest;
import com.dailyPe.UserManager.service.ManagerService;
import com.dailyPe.UserManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    ManagerService managerService;


    // Create a new user
    @PostMapping("/user/create")
    public String createUser(@RequestBody User newUser){
        return userService.createUser(newUser);
    }

    // Create a new manager
    @PostMapping("/manager/create")
    public String createManager(@RequestBody Manager newManager){
        return managerService.createManager(newManager);
    }

    // Get all managers
    @GetMapping("/managers/all")
    public List<Manager> getAllManager(){
        return managerService.getAllManager();
    }

    // Get all users
    @GetMapping("/users/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    // Get all users by manager ID
    @GetMapping("/users/by-manager/{managerId}")
    public List<User> getAllUsersByManagerId(@PathVariable Long managerId){
        return userService.getAllUsersByManagerId(managerId);
    }

    // Get user by contact number
    @GetMapping("/users/by-phone/{phoneNumber}")
    public User getUserByContactNumber(@PathVariable String phoneNumber){
        return userService.getUserByContactNumber(phoneNumber);
    }


    // Bulk update users
    @PutMapping("/users/update/bulk")
    public String updateUsers(@RequestBody UpdateRequest updateRequest){
        return userService.updateUsers(updateRequest);
    }

    // Delete user by ID
    @DeleteMapping("/user/delete/{userId}")
    public String deleteUserById(@PathVariable UUID userId){
        return userService.deleteUserById(userId);
    }

    // Delete user by contact number
    @DeleteMapping("/user/delete/by-phone/{phoneNumber}")
    public String deleteUserByContactNumber(@PathVariable String phoneNumber){
        return userService.deleteUserByContactNumber(phoneNumber);
    }

}
