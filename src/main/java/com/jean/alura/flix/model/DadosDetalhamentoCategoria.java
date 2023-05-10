package com.jean.alura.flix.model;

public record DadosDetalhamentoCategoria(
        Long id,
        String titulo,
        String cor
) {
    public DadosDetalhamentoCategoria(Categoria categoria){
        this(categoria.getId(), categoria.getTitulo(), categoria.getCor());
    }
}
