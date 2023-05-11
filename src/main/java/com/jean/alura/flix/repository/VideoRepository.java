package com.jean.alura.flix.repository;

import com.jean.alura.flix.model.video.Video;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VideoRepository extends JpaRepository<Video, Long> {
}
