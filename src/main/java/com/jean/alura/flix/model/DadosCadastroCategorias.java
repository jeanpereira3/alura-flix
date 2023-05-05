package com.jean.alura.flix.model;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCategorias(
        @NotBlank
        String titulo,
        @NotBlank
        String cor
) {
}
