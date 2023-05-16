package com.jean.alura.flix.model.video;

import com.jean.alura.flix.model.categoria.Categoria;
import com.jean.alura.flix.model.video.DadosCadastroVideos;

public record DadosCadastroVideosCategoria(
        String titulo,
        String descricao,
        String url,
        Categoria categoria,
        Boolean free
        ) {
    public DadosCadastroVideosCategoria(DadosCadastroVideos dados, Categoria categoria){
        this(dados.titulo(), dados.descricao(), dados.url(), categoria, dados.free());
    }
}
