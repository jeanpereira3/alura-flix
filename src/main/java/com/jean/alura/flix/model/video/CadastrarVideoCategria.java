package com.jean.alura.flix.model.video;

import com.jean.alura.flix.model.categoria.Categoria;
import com.jean.alura.flix.repository.CategoriaRepository;
import com.jean.alura.flix.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class CadastrarVideoCategria {

    @Autowired
    private VideoRepository videoRepositor;
    @Autowired
    private CategoriaRepository categoriaRepository;


    public Video cadastar(DadosCadastroVideos dados){
        Categoria categoria = definirCategoria(dados);
        Video video = new Video(new DadosCadastroVideosCategoria(dados, categoria));
        videoRepositor.save(video);
        return video;
    }

    private Categoria definirCategoria(DadosCadastroVideos dados) {
        if (dados.categoriaId() != null){
            return categoriaRepository.getReferenceById(dados.categoriaId());
        }else {
            return categoriaRepository.getReferenceById(1l);
        }
    }
}
