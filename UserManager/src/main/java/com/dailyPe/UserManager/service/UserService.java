package com.dailyPe.UserManager.service;

import com.dailyPe.UserManager.model.Manager;
import com.dailyPe.UserManager.model.User;
import com.dailyPe.UserManager.model.request.UpdateData;
import com.dailyPe.UserManager.model.request.UpdateRequest;
import com.dailyPe.UserManager.repository.IManagerRepo;
import com.dailyPe.UserManager.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    IUserRepo userRepo;

    @Autowired
    IManagerRepo managerRepo;

    public String createUser(User newUser) {
        try {
            newUser.setCreatedAt(LocalDateTime.now());
            userRepo.save(newUser);
            return "User Added Successfully";
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            e.printStackTrace(); // or log it using a logger
            return "Failed to add user: " + e.getMessage(); // Return an error message
        }
    }

    public String deleteUserById(UUID userId) {


        if (userRepo.existsById(userId)) {
            userRepo.deleteById(userId);
            return "User deleted successfully";
        } else {
            throw new RuntimeException("User with ID " + userId + " not found");
        }

    }

    public String deleteUserByContactNumber(String phoneNumber) {
        User user = userRepo.findByContactNumber(phoneNumber);
        if (user != null) {
            userRepo.delete(user);
            return "User deleted successfully";
        } else {
            return ("User with contact number " + phoneNumber + " not found");
        }
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public String updateUsers(UpdateRequest updateRequest) {
        Map<UUID, UpdateData> userData = updateRequest.getUserData();


        // Iterate over each user's update data
        for (Map.Entry<UUID, UpdateData> entry : userData.entrySet()) {
            UUID userId = entry.getKey();
            UpdateData updateData = entry.getValue();
            Long managerId=updateData.getManagerId();
            if(managerId==null ){
                return "Manager Id is required for updating in bulk";
            }


            // Find the user by ID
            Optional<User> optionalUser = userRepo.findById(userId);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                // Validate and apply update data
                updateUserFields(user, updateData);
            } else {
                return "User with ID " + userId + " does not exist";
            }
        }

        // Return success message upon successful update
        return "Users updated successfully";
        
    }



    private void updateUserFields(User user, UpdateData updateData) {
        if (updateData.getFullName() != null) {
            user.setUserName(updateData.getFullName());
        }
        if (updateData.getMobNum() != null) {
            user.setContactNumber(updateData.getMobNum());
        }
        if (updateData.getPanNum() != null) {
            user.setUserPanNumber(updateData.getPanNum());
        }
        if (updateData.getManagerId() != null) {
            // Handle manager_id update
            Long newManagerId = updateData.getManagerId();
            Optional<Manager> newManager = managerRepo.findById(newManagerId);
            if (newManager.isPresent()) {
                updateManager(user, newManager.get());
            } else {
                // Manager with the provided ID does not exist
                throw new RuntimeException("Manager with ID " + newManagerId + " does not exist");
            }
        }
        // Set updated_at timestamp
        user.setUpdatedAt(LocalDateTime.now());
        userRepo.save(user);
    }

    private void updateManager(User user, Manager newManager) {
        Manager oldManager = user.getManager();
        if (oldManager != null) {
            managerRepo.save(oldManager);
        }
        // Set new manager
        user.setManager(newManager);
    }

    public List<User> getAllUsersByManagerId(Long managerId) {
        return userRepo.findAllByManagerId(managerId);
    }

    public User getUserByContactNumber(String phoneNumber) {
        try {
            return userRepo.findByContactNumber(phoneNumber);
        } catch (Exception ex) {
            throw new RuntimeException("User with contact number " + phoneNumber + " not found", ex);
        }
    }
}
