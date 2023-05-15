package com.jean.alura.flix.controller;

import com.jean.alura.flix.model.usuario.DadosAutenticar;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticar")
public class AutenticacaoController {

    @PostMapping
    public void autenticar(@RequestBody @Valid DadosAutenticar dados){

    }
}
