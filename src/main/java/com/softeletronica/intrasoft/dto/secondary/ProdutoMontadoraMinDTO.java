package com.softeletronica.intrasoft.dto.secondary;


import com.softeletronica.intrasoft.projections.ProdutoMontadoraProjection;

public class ProdutoMontadoraMinDTO {
    private Long id;
    private String montadora;

    public ProdutoMontadoraMinDTO() {

    }

    public ProdutoMontadoraMinDTO(Long id, String montadora) {
        this.id = id;
        this.montadora = montadora;
    }

    public ProdutoMontadoraMinDTO(ProdutoMontadoraProjection projection) {
        id = projection.getId();
        montadora = projection.getMontadora();

    }

    public Long getId() {
        return id;
    }

    public String getMontadora() {
        return montadora;
    }
}
