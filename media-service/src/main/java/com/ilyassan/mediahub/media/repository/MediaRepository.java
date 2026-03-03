package com.ilyassan.mediahub.media.repository;

import com.ilyassan.mediahub.media.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MediaRepository extends JpaRepository<Media, Long> {

    // Spring Data generates: SELECT * FROM media WHERE category = ?
    List<Media> findByCategory(String category);

    // Spring Data generates: SELECT * FROM media WHERE genre = ?
    List<Media> findByGenre(String genre);
}
