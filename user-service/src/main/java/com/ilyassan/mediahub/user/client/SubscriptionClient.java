package com.ilyassan.mediahub.user.client;

import com.ilyassan.mediahub.user.dto.SubscriptionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// @FeignClient: Spring generates a full HTTP client from this interface at runtime.
// name = "subscription-service" → Feign asks Eureka "where is subscription-service?"
//   and calls that address. No hardcoded URL, no port number.
@FeignClient(name = "subscription-service")
public interface SubscriptionClient {

    // This maps to GET http://subscription-service/subscriptions/user/{userId}
    // Feign builds the request and parses the JSON response automatically.
    @GetMapping("/subscriptions/user/{userId}")
    SubscriptionDto getSubscriptionByUserId(@PathVariable Long userId);
}
