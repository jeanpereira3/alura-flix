package com.jean.alura.flix.model.categoria;

import com.jean.alura.flix.model.categoria.Categoria;

public record DadosExibicaoCategoria(
        String titulo,
        String cor
) {
    public  DadosExibicaoCategoria(Categoria dados){
        this(dados.getTitulo(), dados.getCor());
    }
}
