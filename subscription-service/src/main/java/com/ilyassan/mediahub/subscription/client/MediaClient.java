package com.ilyassan.mediahub.subscription.client;

import com.ilyassan.mediahub.subscription.dto.MediaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Feign client that calls media-service by logical name (resolved through Eureka)
@FeignClient(name = "media-service")
public interface MediaClient {

    @GetMapping("/media/{id}")
    MediaDto getMediaById(@PathVariable Long id);
}
