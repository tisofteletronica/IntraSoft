package com.softeletronica.intrasoft.dto.secondary;


import com.softeletronica.intrasoft.projections.ProdutosPorModelosProjection;

public class ProdutosPorModeloMinDTO {
    private Long modeloId;
    private String modelName;
    private Integer anoDe;
    private Integer anoAte;
    private Long montadoraId;
    private String montadoraName;
    private String montadoraImage;
    private Long categoryProductInstaleSoftId;
    private String categoryProductInstaleSoftName;
    private Long productId;

    public ProdutosPorModeloMinDTO() {

    }

    public ProdutosPorModeloMinDTO(Long modeloId, String modelName, Integer anoDe, Integer anoAte,
                                   Long montadoraId, String montadoraName, String montadoraImage,
                                   Long categoryProductInstaleSoftId, String categoryProductInstaleSoftName, Long productId) {
        this.modeloId = modeloId;
        this.modelName = modelName;
        this.anoDe = anoDe;
        this.anoAte = anoAte;
        this.montadoraId = montadoraId;
        this.montadoraName = montadoraName;
        this.montadoraImage = montadoraImage;
        this.categoryProductInstaleSoftId = categoryProductInstaleSoftId;
        this.categoryProductInstaleSoftName = categoryProductInstaleSoftName;
        this.productId = productId;
    }

    public ProdutosPorModeloMinDTO(ProdutosPorModelosProjection projection) {
        modeloId = projection.getModeloId();
        modelName = projection.getModelName();
        anoDe = projection.getAnoDe();
        anoAte = projection.getAnoAte();
        montadoraId = projection.getMontadoraId();
        montadoraName = projection.getMontadoraName();
        montadoraImage = projection.getMontadoraImage();
        categoryProductInstaleSoftId = projection.getCategoryProductInstaleSoftId();
        categoryProductInstaleSoftName = projection.getCategoryProductInstaleSoftName();
        productId = projection.getProductId();
    }

    public Long getModeloId() {
        return modeloId;
    }

    public String getModelName() {
        return modelName;
    }

    public Integer getAnoDe() {
        return anoDe;
    }

    public Integer getAnoAte() {
        return anoAte;
    }

    public Long getMontadoraId() {
        return montadoraId;
    }

    public String getMontadoraName() {
        return montadoraName;
    }

    public String getMontadoraImage() {
        return montadoraImage;
    }

    public Long getCategoryProductInstaleSoftId() {
        return categoryProductInstaleSoftId;
    }

    public String getCategoryProductInstaleSoftName() {
        return categoryProductInstaleSoftName;
    }

    public Long getProductId() {
        return productId;
    }
}
