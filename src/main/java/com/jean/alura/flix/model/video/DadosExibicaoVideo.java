package com.jean.alura.flix.model.video;

import com.jean.alura.flix.model.categoria.DadosExibicaoCategoria;

public record DadosExibicaoVideo(
        String titulo,
        String descricao,
        String url,
        DadosExibicaoCategoria categoria,
        Boolean free

) {
    public DadosExibicaoVideo(Video video){
        this(
                video.getTitulo(),
                video.getDescricao(),
                video.getUrl(),
                new DadosExibicaoCategoria(video.getCategoria()),
                video.isFree()
        );
    }


}
