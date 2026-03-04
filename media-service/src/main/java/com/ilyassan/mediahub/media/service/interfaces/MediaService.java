package com.ilyassan.mediahub.media.service.interfaces;

import com.ilyassan.mediahub.media.dto.MediaDTO;
import com.ilyassan.mediahub.media.dto.MediaRequestDTO;
import com.ilyassan.mediahub.media.dto.MediaUpdateDTO;
import com.ilyassan.mediahub.media.dto.responce.PaginationDTO;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Pageable;

public interface MediaService {
    MediaDTO create(@NonNull MediaRequestDTO dto);
    MediaDTO update(@NonNull Long id, @NonNull MediaUpdateDTO dto);
    PaginationDTO getAll(String genre, String category, @NonNull Pageable pageable);
    MediaDTO get(@NonNull Long id);
    void delete(@NonNull Long id);

}
