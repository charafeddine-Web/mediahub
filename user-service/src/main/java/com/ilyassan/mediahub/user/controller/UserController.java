package com.ilyassan.mediahub.user.controller;

import com.ilyassan.mediahub.user.dto.SubscriptionDto;
import com.ilyassan.mediahub.user.dto.UserDto;
import com.ilyassan.mediahub.user.dto.UserRequest;
import com.ilyassan.mediahub.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // GET /users
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // GET /users/{id}
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // POST /users
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(request));
    }

    // GET /users/{id}/subscription
    // Example of inter-service call via OpenFeign — calls subscription-service
    @GetMapping("/{id}/subscription")
    public ResponseEntity<SubscriptionDto> getUserSubscription(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserSubscription(id));
    }

    // GET /users/media
    // Example of inter-service call via WebClient — calls media-service reactively
    @GetMapping("/media")
    public ResponseEntity<List<?>> getAvailableMedia() {
        return ResponseEntity.ok(userService.getAvailableMedia());
    }
}
