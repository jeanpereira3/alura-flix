package com.jean.alura.flix.model.video;

import com.jean.alura.flix.model.categoria.Categoria;
import com.jean.alura.flix.model.video.DadosCadastroVideos;
import com.jean.alura.flix.model.video.DadosCadastroVideosCategoria;
import com.jean.alura.flix.model.video.DadosDetalhadosVideo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "videos")
@Entity(name = "Video")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String url;
    @ManyToOne
    private Categoria categoria;

    public Video(DadosCadastroVideos dados) {
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.url = dados.url();
    }

    public Video(DadosCadastroVideosCategoria dados) {
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.url = dados.url();
        this.categoria = dados.categoria();
    }

    public void atualizar(DadosDetalhadosVideo dados) {
        if (dados.titulo() != null){
            this.titulo = dados.titulo();
        }
        if (dados.descricao() != null){
            this.descricao = dados.descricao();
        }
        if (dados.url() != dados.url()){
            this.url = dados.url();
        }
    }
}
