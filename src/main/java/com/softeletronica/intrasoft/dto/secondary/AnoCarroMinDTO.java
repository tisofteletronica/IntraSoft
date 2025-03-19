package com.softeletronica.intrasoft.dto.secondary;


import com.softeletronica.intrasoft.projections.AnoModeloProjection;

public class AnoCarroMinDTO {
    private Long id;
    private String name;
    private Integer ano;
    private String montadora;

    public AnoCarroMinDTO() {

    }

    public AnoCarroMinDTO(Long id, String name, Integer ano, String montadora) {
        this.id = id;
        this.name = name;
        this.ano = ano;
        this.montadora = montadora;
    }

    public AnoCarroMinDTO(AnoModeloProjection projection) {
        id = projection.getId();
        name = projection.getName();
        montadora = projection.getMontadora();
        ano = projection.getAno();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }
}
