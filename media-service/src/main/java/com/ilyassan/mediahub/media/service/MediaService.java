package com.ilyassan.mediahub.media.service;

import com.ilyassan.mediahub.media.dto.MediaDto;
import com.ilyassan.mediahub.media.dto.MediaRequest;
import com.ilyassan.mediahub.media.entity.Media;
import com.ilyassan.mediahub.media.repository.MediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MediaService {

    private final MediaRepository mediaRepository;

    public List<MediaDto> getAllMedia() {
        return mediaRepository.findAll().stream().map(this::toDto).toList();
    }

    public MediaDto getMediaById(Long id) {
        Media media = mediaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Media not found with id: " + id));
        return toDto(media);
    }

    public List<MediaDto> getByCategory(String category) {
        return mediaRepository.findByCategory(category).stream().map(this::toDto).toList();
    }

    public List<MediaDto> getByGenre(String genre) {
        return mediaRepository.findByGenre(genre).stream().map(this::toDto).toList();
    }

    public MediaDto createMedia(MediaRequest request) {
        Media media = Media.builder()
                .title(request.getTitle())
                .type(request.getType())
                .genre(request.getGenre())
                .category(request.getCategory())
                .build();
        return toDto(mediaRepository.save(media));
    }

    private MediaDto toDto(Media media) {
        return MediaDto.builder()
                .id(media.getId())
                .title(media.getTitle())
                .type(media.getType())
                .genre(media.getGenre())
                .category(media.getCategory())
                .build();
    }
}
