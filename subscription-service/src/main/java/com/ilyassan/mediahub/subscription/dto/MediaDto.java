package com.ilyassan.mediahub.subscription.dto;

import lombok.Data;

// Mirrors the MediaDto returned by media-service.
// Used by the Feign client to deserialize the response JSON.
@Data
public class MediaDto {
    private Long id;
    private String title;
    private String type;
    private String genre;
    private String category;
}
