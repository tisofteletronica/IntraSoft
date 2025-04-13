package com.softeletronica.intrasoft.entities.secondary;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_conectividade_soft")
public class ConectividadeSoft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    @Column(columnDefinition = "TEXT", name = "sistemas_conexao_ble")
    private String sistemasConexaoBle;
    @Column(columnDefinition = "TEXT")
    private String aplicacoes;
    @Column(columnDefinition = "TEXT")
    private String anatel;
    @Column(name = "url_img1")
    private String urlImg1;
    @Column(name= "url_img2")
    private String urlImg2;
    @Column(name = "url_img3")
    private String urlImg3;


public ConectividadeSoft(){

}

    public ConectividadeSoft(Long id, String descricao, String sistemasConexaoBle, String aplicacoes, String anatel, String urlImg1, String urlImg2, String urlImg3) {
        this.id = id;
        this.descricao = descricao;
        this.sistemasConexaoBle = sistemasConexaoBle;
        this.aplicacoes = aplicacoes;
        this.anatel = anatel;
        this.urlImg1 = urlImg1;
        this.urlImg2 = urlImg2;
        this.urlImg3 = urlImg3;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSistemasConexaoBle() {
        return sistemasConexaoBle;
    }

    public void setSistemasConexaoBle(String sistemasConexaoBle) {
        this.sistemasConexaoBle = sistemasConexaoBle;
    }

    public String getAplicacoes() {
        return aplicacoes;
    }

    public void setAplicacoes(String aplicacoes) {
        this.aplicacoes = aplicacoes;
    }

    public String getAnatel() {
        return anatel;
    }

    public void setAnatel(String anatel) {
        this.anatel = anatel;
    }

    public String getUrlImg1() {
        return urlImg1;
    }

    public void setUrlImg1(String urlImg1) {
        this.urlImg1 = urlImg1;
    }

    public String getUrlImg2() {
        return urlImg2;
    }

    public void setUrlImg2(String urlImg2) {
        this.urlImg2 = urlImg2;
    }

    public String getUrlImg3() {
        return urlImg3;
    }

    public void setUrlImg3(String urlImg3) {
        this.urlImg3 = urlImg3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConectividadeSoft that = (ConectividadeSoft) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
