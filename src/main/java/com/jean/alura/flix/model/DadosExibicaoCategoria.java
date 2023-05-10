package com.jean.alura.flix.model;

public record DadosExibicaoCategoria(
        String titulo,
        String cor
) {
    public  DadosExibicaoCategoria(Categoria dados){
        this(dados.getTitulo(), dados.getCor());
    }
}
