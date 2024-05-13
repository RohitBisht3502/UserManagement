package com.dailyPe.UserManager.service;

import com.dailyPe.UserManager.model.Manager;
import com.dailyPe.UserManager.repository.IManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    @Autowired
    IManagerRepo managerRepo;

    public String createManager(Manager newManager) {
        try {
            managerRepo.save(newManager);
            return "Manager added:";
        } catch (Exception ex) {

            throw new RuntimeException("Failed to create manager: " + ex.getMessage());
        }
    }

    public List<Manager> getAllManager() {
       return managerRepo.findAll();
    }
}
