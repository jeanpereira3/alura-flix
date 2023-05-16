package com.jean.alura.flix.model.video;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroVideos(
        @NotBlank
        String titulo,
        @NotBlank
        String descricao,
        @NotBlank
        String url,
        Long categoriaId,
        Boolean free

) {
}
