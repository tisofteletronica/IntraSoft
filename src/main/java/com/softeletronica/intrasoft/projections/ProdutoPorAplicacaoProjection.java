package com.softeletronica.intrasoft.projections;

public interface ProdutoPorAplicacaoProjection {
    Long getProductId();
    String getProductName();
    String getProductCode();
    String getProductImage();
    String getProductLogo();
    String getProductDescriptionInstaleSoft();
    String getProductDescriptionCommercial();
    String getProductManual();
    Long getCategoryInstaleSoftId();
    String getCategoryInstaleSoftName();
    String getCategoryInstaleSoftImage();
    Long getCategoryCommercialId();
    String getCategoryCommercialName();
    String getCategoryCommercialImage();


}
