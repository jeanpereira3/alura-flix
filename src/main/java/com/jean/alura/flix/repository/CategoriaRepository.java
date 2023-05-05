package com.jean.alura.flix.repository;

import com.jean.alura.flix.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
