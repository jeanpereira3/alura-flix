package com.jean.alura.flix.model;

import org.springframework.data.domain.Page;

public record DadosExibicaoVideo(
        String titulo,
        String descricao,
        String url
) {
    public DadosExibicaoVideo(Video video){
        this(video.getTitulo(), video.getDescricao(), video.getUrl());
    }
}
