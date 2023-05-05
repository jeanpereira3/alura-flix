package com.jean.alura.flix.model;

public record DadosDetalhadosCategoria(
        Long id,
        String titulo,
        String cor
) {
    public DadosDetalhadosCategoria(Categoria categoria) {
        this(categoria.getId(), categoria.getTitulo(), categoria.getCor());
    }
}
