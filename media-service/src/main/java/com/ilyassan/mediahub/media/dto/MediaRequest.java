package com.ilyassan.mediahub.media.dto;

import com.ilyassan.mediahub.media.enums.MediaType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MediaRequest {

    @NotBlank(message = "Title is required")
    private String title;

    private MediaType type;
    private String genre;
    private String category;
}
