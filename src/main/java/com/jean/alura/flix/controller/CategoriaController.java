package com.jean.alura.flix.controller;

import com.jean.alura.flix.model.*;
import com.jean.alura.flix.repository.CategoriaRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<Page<DadosExibicaoCategoria>> listar(Pageable pageable){
        Page<DadosExibicaoCategoria> page = categoriaRepository.findAll(pageable).map(DadosExibicaoCategoria::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharCategoria(@PathVariable Long id){
        Categoria categoria = categoriaRepository.getReferenceById(id);
        return ResponseEntity.ok().body(new DadosDetalhamentoCategoria(categoria));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody DadosDetalhadosCategoria dados){
        Categoria categoria = categoriaRepository.getReferenceById(dados.id());
        categoria.atualizar(dados);
        return ResponseEntity.ok().body(new DadosDetalhadosCategoria(categoria));
    }
}
