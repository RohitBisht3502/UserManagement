package com.dailyPe.UserManager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managerId;

    @NotBlank(message = "Full name is required")
    private String managerName;

    @NotBlank()
    @Column(unique = true) // Ensure uniqueness at the database level
    @Pattern(regexp = "^(?:0|\\+91)?[6-9]\\d{9}$", message = "Invalid mobile number")
    private String managerContactNumber;

    @Email(message = "Please provide a valid email address")
    private String managerEmail;



}
