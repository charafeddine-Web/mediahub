package com.ilyassan.mediahub.media.repository;

import com.ilyassan.mediahub.media.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media, Long> {
}
