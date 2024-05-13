package com.dailyPe.UserManager.model.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateData {
    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank()
    @Pattern(regexp = "^(?:0|\\+91)?[6-9]\\d{9}$", message = "Invalid mobile number")
    private String mobNum;

    @NotBlank(message = "PAN number is required")
    @Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "Invalid PAN number")
    private String panNum;

    @NotNull(message = "Manager ID is required")
    private Long managerId;
}
