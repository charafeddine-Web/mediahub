package com.ilyassan.mediahub.user.dto;

import lombok.Data;

// This DTO mirrors the response body returned by subscription-service.
// It lives here in user-service so Feign knows how to deserialize the JSON response.
@Data
public class SubscriptionDto {
    private Long id;
    private Long userId;
    private String plan;
    private String status;
    private String startDate;
    private String endDate;
}
