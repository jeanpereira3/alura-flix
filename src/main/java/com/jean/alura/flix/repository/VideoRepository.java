package com.jean.alura.flix.repository;

import com.jean.alura.flix.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface VideoRepository extends JpaRepository<Video, Long> {
}
