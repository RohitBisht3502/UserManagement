package com.dailyPe.UserManager.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateRequest {
    // Mapping UUID of user ID to update data so we can know which user ID is being updated
    private Map<UUID, UpdateData> userData;
}
