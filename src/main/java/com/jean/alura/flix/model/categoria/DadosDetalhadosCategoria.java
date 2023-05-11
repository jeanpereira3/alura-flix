package com.jean.alura.flix.model.categoria;

import com.jean.alura.flix.model.categoria.Categoria;

public record DadosDetalhadosCategoria(
        Long id,
        String titulo,
        String cor
) {
    public DadosDetalhadosCategoria(Categoria categoria) {
        this(categoria.getId(), categoria.getTitulo(), categoria.getCor());
    }
}
