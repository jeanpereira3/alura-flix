package com.jean.alura.flix.repository;

import com.jean.alura.flix.model.video.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface VideoRepository extends JpaRepository<Video, Long> {
    Page<Video> findByCategoriaId(Pageable pageable, Long id);

    Page<Video> findByTituloContainingIgnoreCase(String titulo, Pageable pageable);
}
