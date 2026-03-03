package com.ilyassan.mediahub.subscription.dto;

import com.ilyassan.mediahub.subscription.enums.Plan;
import com.ilyassan.mediahub.subscription.enums.SubscriptionStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class SubscriptionDto {
    private Long id;
    private Long userId;
    private Plan plan;
    private SubscriptionStatus status;
    private LocalDate startDate;
    private LocalDate endDate;
}
