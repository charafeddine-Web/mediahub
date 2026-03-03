package com.ilyassan.mediahub.media.entity;

import com.ilyassan.mediahub.media.enums.MediaType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "media")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @Enumerated(EnumType.STRING)
    private MediaType type;   // FILM, SERIES, or PODCAST

    private String genre;     // e.g. "Action", "Drama"
    private String category;  // e.g. "Trending", "New"
}
