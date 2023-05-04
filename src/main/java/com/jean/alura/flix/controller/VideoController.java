package com.jean.alura.flix.controller;

import com.jean.alura.flix.model.DadosCadastroVideos;
import com.jean.alura.flix.model.DadosDetalhadosVideo;
import com.jean.alura.flix.model.DadosExibicaoVideo;
import com.jean.alura.flix.model.Video;
import com.jean.alura.flix.repository.VideoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(
            @RequestBody @Valid DadosCadastroVideos dados , UriComponentsBuilder uriComponentsBuilder
    ){
        Video video = new Video(dados);
        videoRepository.save(video);

        URI uri = uriComponentsBuilder.path("/videos/{id}").buildAndExpand(video.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhadosVideo(video));
    }

    @GetMapping
    public ResponseEntity<Page<DadosExibicaoVideo>> buscar(Pageable pageable){
        Page<DadosExibicaoVideo> page = videoRepository.findAll(pageable).map(DadosExibicaoVideo::new);
        return ResponseEntity.ok(page);
    }
}
