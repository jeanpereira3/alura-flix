package com.jean.alura.flix.model;

public record DadosDetalhadosVideo(
        Long id,
        String titulo,
        String descricao,
        String url
) {
    public DadosDetalhadosVideo(Video video) {
        this(video.getId(), video.getTitulo(), video.getDescricao(), video.getUrl());
    }
}
