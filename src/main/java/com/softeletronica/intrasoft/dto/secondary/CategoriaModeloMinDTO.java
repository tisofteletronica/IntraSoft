package com.softeletronica.intrasoft.dto.secondary;


import com.softeletronica.intrasoft.projections.ModeloCategoriaProjection;

public class CategoriaModeloMinDTO {
    private Long categoriaId;
    private String name;

    private Long modeloId;
    private String modelo;
    private Integer ano;
    private String imgUrl;

    public CategoriaModeloMinDTO() {

    }

    public CategoriaModeloMinDTO(Long categoriaId, String name, Long modeloId, String modelo, Integer ano, String imgUrl) {
        this.categoriaId = categoriaId;
        this.name = name;
        this.modeloId = modeloId;
        this.modelo = modelo;
        this.ano = ano;
        this.imgUrl = imgUrl;
    }

    public CategoriaModeloMinDTO(ModeloCategoriaProjection projection) {
        categoriaId = projection.getCategoriaId();
        name = projection.getName();
        modeloId = projection.getModeloId();
        modelo = projection.getModelo();
        ano = projection.getAno();
        imgUrl = projection.getImgUrl();
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public String getName() {
        return name;
    }

    public Long getModeloId() {
        return modeloId;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
