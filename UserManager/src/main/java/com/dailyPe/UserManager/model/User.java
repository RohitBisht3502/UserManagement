package com.dailyPe.UserManager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;


    @NotBlank(message = "Full name is required")
    private String userName;

    @NotBlank()
    @Column(unique = true) // Ensure uniqueness at the database level
    @Pattern(regexp = "^(?:0|\\+91)?[6-9]\\d{9}$", message = "Invalid mobile number")
    private String contactNumber;

    @NotBlank(message = "PAN number is required")
    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Invalid PAN number")
    @Column(unique = true) // Ensure uniqueness at the database level
    private String userPanNumber;

    @Column(updatable = false) // Prevents the field from being updated
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    @ManyToOne()
    @JoinColumn(name = "fk_manager_id")
    private Manager manager;




}
