package com.softeletronica.intrasoft.dto.secondary;


import com.softeletronica.intrasoft.entities.secondary.ConectividadeSoft;

public class ConectividadeSoftDTO {
    private Long id;
    private String descricao;
    private String sistemasConexaoBle;
    private String aplicacoes;
    private String anatel;
    private String urlImg1;
    private String urlImg2;
    private String urlImg3;
    public ConectividadeSoftDTO(){

    }

    public ConectividadeSoftDTO(Long id, String descricao, String sistemasConexaoBle, String aplicacoes, String anatel, String urlImg1, String urlImg2, String urlImg3) {
        this.id = id;
        this.descricao = descricao;
        this.sistemasConexaoBle = sistemasConexaoBle;
        this.aplicacoes = aplicacoes;
        this.anatel = anatel;
        this.urlImg1 = urlImg1;
        this.urlImg2 = urlImg2;
        this.urlImg3 = urlImg3;
    }

    public ConectividadeSoftDTO(ConectividadeSoft entities) {
        id = entities.getId();
        descricao = entities.getDescricao();
        sistemasConexaoBle = entities.getSistemasConexaoBle();
        aplicacoes = entities.getAplicacoes();
        anatel = entities.getAnatel();
        urlImg1 = entities.getUrlImg1();
        urlImg2 = entities.getUrlImg2();
        urlImg3 = entities.getUrlImg3();
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getSistemasConexaoBle() {
        return sistemasConexaoBle;
    }

    public String getAplicacoes() {
        return aplicacoes;
    }

    public String getAnatel() {
        return anatel;
    }

    public String getUrlImg1() {
        return urlImg1;
    }

    public String getUrlImg2() {
        return urlImg2;
    }

    public String getUrlImg3() {
        return urlImg3;
    }
}
