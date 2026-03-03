package com.ilyassan.mediahub.subscription.controller;

import com.ilyassan.mediahub.subscription.dto.MediaDto;
import com.ilyassan.mediahub.subscription.dto.SubscriptionDto;
import com.ilyassan.mediahub.subscription.dto.SubscriptionRequest;
import com.ilyassan.mediahub.subscription.service.SubscriptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    // POST /subscriptions
    @PostMapping
    public ResponseEntity<SubscriptionDto> createSubscription(@Valid @RequestBody SubscriptionRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionService.createSubscription(request));
    }

    // GET /subscriptions/user/{userId}
    // Called by user-service via OpenFeign to check subscription status
    @GetMapping("/user/{userId}")
    public ResponseEntity<SubscriptionDto> getSubscriptionByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(subscriptionService.getSubscriptionByUserId(userId));
    }

    // GET /subscriptions/media/{mediaId}
    // Example of inter-service call: calls media-service via Feign
    @GetMapping("/media/{mediaId}")
    public ResponseEntity<MediaDto> getMediaDetails(@PathVariable Long mediaId) {
        return ResponseEntity.ok(subscriptionService.getMediaDetails(mediaId));
    }
}
