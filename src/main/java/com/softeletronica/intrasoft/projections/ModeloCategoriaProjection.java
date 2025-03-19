package com.softeletronica.intrasoft.projections;

public interface ModeloCategoriaProjection {
    Long getCategoriaId();
    String getName();

    Long getModeloId();
    String getModelo();
    Integer getAno();
    String getImgUrl();

}
