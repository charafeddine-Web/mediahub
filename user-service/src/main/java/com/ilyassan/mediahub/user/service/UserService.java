package com.ilyassan.mediahub.user.service;

import com.ilyassan.mediahub.user.client.SubscriptionClient;
import com.ilyassan.mediahub.user.dto.SubscriptionDto;
import com.ilyassan.mediahub.user.dto.UserDto;
import com.ilyassan.mediahub.user.dto.UserRequest;
import com.ilyassan.mediahub.user.entity.User;
import com.ilyassan.mediahub.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

// @Service: marks this class as a Spring-managed service (business logic layer)
// @RequiredArgsConstructor: Lombok generates a constructor for all final fields (constructor injection)
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final SubscriptionClient subscriptionClient; // OpenFeign client
    private final WebClient webClient;                   // Reactive HTTP client

    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return toDto(user);
    }

    public UserDto createUser(UserRequest request) {
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .role(request.getRole())
                .build();
        return toDto(userRepository.save(user));
    }

    // --- OpenFeign call ---
    // Calls subscription-service via Feign (service name, no hardcoded URL)
    public SubscriptionDto getUserSubscription(Long userId) {
        return subscriptionClient.getSubscriptionByUserId(userId);
    }

    // --- WebClient call ---
    // Calls media-service reactively and blocks to return a synchronous result.
    // In a real scenario you can return Flux<> directly for full reactive flow.
    public List<?> getAvailableMedia() {
        return webClient
                .get()
                .uri("http://media-service/media")
                .retrieve()
                .bodyToFlux(Object.class)
                .collectList()
                .block();
    }

    // Maps a User entity to a UserDto (keeps DB model separate from API response)
    private UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
