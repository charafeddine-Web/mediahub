package com.ilyassan.mediahub.media.controller;

import com.ilyassan.mediahub.media.dto.MediaDto;
import com.ilyassan.mediahub.media.dto.MediaRequest;
import com.ilyassan.mediahub.media.service.MediaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/media")
@RequiredArgsConstructor
public class MediaController {

    private final MediaService mediaService;

    // GET /media
    // GET /media?category=Trending
    // GET /media?genre=Action
    @GetMapping
    public ResponseEntity<List<MediaDto>> getAllMedia(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String genre) {

        if (category != null) return ResponseEntity.ok(mediaService.getByCategory(category));
        if (genre != null)    return ResponseEntity.ok(mediaService.getByGenre(genre));
        return ResponseEntity.ok(mediaService.getAllMedia());
    }

    // GET /media/{id}
    @GetMapping("/{id}")
    public ResponseEntity<MediaDto> getMediaById(@PathVariable Long id) {
        return ResponseEntity.ok(mediaService.getMediaById(id));
    }

    // POST /media
    @PostMapping
    public ResponseEntity<MediaDto> createMedia(@Valid @RequestBody MediaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mediaService.createMedia(request));
    }
}
