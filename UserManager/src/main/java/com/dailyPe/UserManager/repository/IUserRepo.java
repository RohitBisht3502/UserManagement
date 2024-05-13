package com.dailyPe.UserManager.repository;

import com.dailyPe.UserManager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IUserRepo extends JpaRepository<User, UUID> {
    // Retrieve all users by their specific manager Id
    @Query("SELECT u FROM User u WHERE u.manager.id = :managerId")
    List<User> findAllByManagerId(Long managerId);

    // Retrieve a user by their contact number
    User findByContactNumber(String phoneNumber);
}
