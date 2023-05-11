package com.jean.alura.flix.controller;

import com.jean.alura.flix.model.video.CadastrarVideoCategria;
import com.jean.alura.flix.model.video.DadosCadastroVideos;
import com.jean.alura.flix.model.video.DadosDetalhadosVideo;
import com.jean.alura.flix.model.video.DadosExibicaoVideo;
import com.jean.alura.flix.model.video.Video;
import com.jean.alura.flix.repository.VideoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("videos")
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private CadastrarVideoCategria cadastrarVideoCategria;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(
            @RequestBody @Valid DadosCadastroVideos dados , UriComponentsBuilder uriComponentsBuilder
    ){
        Video video = cadastrarVideoCategria.cadastar(dados);

        URI uri = uriComponentsBuilder.path("/videos/{id}").buildAndExpand(video.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhadosVideo(video));
    }

    @GetMapping
    public ResponseEntity<Page<DadosExibicaoVideo>> buscar(
            Pageable pageable,
            @RequestParam(value = "titulo", required = false) String titulo

    ){
        Page<DadosExibicaoVideo> page;

        if (titulo == null){
            page = videoRepository.findAll(pageable).map(DadosExibicaoVideo::new);
        } else {
            page = videoRepository.findByTituloContainingIgnoreCase(titulo, pageable).map(DadosExibicaoVideo::new);
        }

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id){
        Video video = videoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhadosVideo(video));
    }

    @GetMapping("/{id}/categorias")
    public ResponseEntity<Page<DadosExibicaoVideo>> videosPorCategoria(
            @PathVariable Long id, Pageable pageable
    ){
        Page<DadosExibicaoVideo> page = videoRepository.findByCategoriaId(pageable, id).map(DadosExibicaoVideo::new);
        return ResponseEntity.ok().body(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody DadosDetalhadosVideo dados){
        Video video = videoRepository.getReferenceById(dados.id());
        video.atualizar(dados);
        return ResponseEntity.ok(new DadosDetalhadosVideo(video));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        videoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
