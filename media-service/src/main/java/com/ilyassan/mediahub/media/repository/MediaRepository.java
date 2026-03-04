package com.ilyassan.mediahub.media.repository;

import com.ilyassan.mediahub.media.entity.Media;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MediaRepository extends JpaRepository<@NonNull Media, @NonNull Long>, JpaSpecificationExecutor<@NonNull Media> {
}
