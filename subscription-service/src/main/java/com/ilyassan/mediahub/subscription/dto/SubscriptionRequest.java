package com.ilyassan.mediahub.subscription.dto;

import com.ilyassan.mediahub.subscription.enums.Plan;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SubscriptionRequest {

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Plan is required")
    private Plan plan;

    private LocalDate startDate;
    private LocalDate endDate;
}
