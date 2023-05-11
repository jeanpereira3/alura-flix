package com.jean.alura.flix.repository;

import com.jean.alura.flix.model.categoria.Categoria;
import com.jean.alura.flix.model.video.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
