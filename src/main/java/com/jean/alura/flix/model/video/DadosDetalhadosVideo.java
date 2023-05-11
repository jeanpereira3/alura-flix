package com.jean.alura.flix.model.video;

import com.jean.alura.flix.model.categoria.DadosDetalhadosCategoria;
import com.jean.alura.flix.model.categoria.DadosExibicaoCategoria;

public record DadosDetalhadosVideo(
        Long id,
        String titulo,
        String descricao,
        String url,
        DadosDetalhadosCategoria categoria
) {
    public DadosDetalhadosVideo(Video video) {
        this(video.getId(),
                video.getTitulo(),
                video.getDescricao(),
                video.getUrl(),
                new DadosDetalhadosCategoria(video.getCategoria())
        );
    }
}
