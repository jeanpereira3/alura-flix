package com.jean.alura.flix.model.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosAutenticar(
        @NotBlank
        @Email
        String email,
        @NotBlank
        String senha
) {
}
