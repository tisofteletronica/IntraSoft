package com.softeletronica.intrasoft.projections;

public interface ProdutosPorModelosProjection {
    Long getModeloId();
    String getModelName();
    Integer getAnoDe();
    Integer getAnoAte();
    Long getMontadoraId();
    String getMontadoraName();
    String getMontadoraImage();
    Long getCategoryProductInstaleSoftId();
    String getCategoryProductInstaleSoftName();
    Long getProductId();


}
