package com.jean.alura.flix.controller;

import com.jean.alura.flix.model.Categoria;
import com.jean.alura.flix.model.DadosCadastroCategorias;
import com.jean.alura.flix.model.DadosDetalhadosCategoria;
import com.jean.alura.flix.model.DadosDetalhadosVideo;
import com.jean.alura.flix.repository.CategoriaRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(
            @RequestBody @Valid DadosCadastroCategorias dados,
            UriComponentsBuilder uriComponentsBuilder
    ){
        Categoria categoria = new Categoria(dados);
        categoriaRepository.save(categoria);
        URI uri = uriComponentsBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhadosCategoria(categoria));
    }
}
