package com.softeletronica.intrasoft.dto.secondary;


import com.softeletronica.intrasoft.projections.ProdutoPorAplicacaoProjection;

public class ProdutoporAplicacaoMinDTO {
    private Long productId;
    private String productName;
    private String productCode;
    private String productImage;
    private String productLogo;
    private String productDescriptionInstaleSoft;
    private String productDescriptionCommercial;
    private String produtctManual;
    private Long categoryInstaleSoftId;
    private String categoryInstaleSoftName;
    private String categoryInstaleSoftImage;
    private Long categoryCommercialId;
    private String categoryCommercialName;
    private String categoryCommercialImage;

    public ProdutoporAplicacaoMinDTO() {

    }

    public ProdutoporAplicacaoMinDTO(Long productId, String productName, String productCode, String productImage,
                                     String productLogo, String productDescriptionInstaleSoft,
                                     String productDescriptionCommercial, String produtctManual,
                                     Long categoryInstaleSoftId, String categoryInstaleSoftName,
                                     String categoryInstaleSoftImage, Long categoryCommercialId,
                                     String categoryCommercialName, String categoryCommercialImage) {
        this.productId = productId;
        this.productName = productName;
        this.productCode = productCode;
        this.productImage = productImage;
        this.productLogo = productLogo;
        this.productDescriptionInstaleSoft = productDescriptionInstaleSoft;
        this.productDescriptionCommercial = productDescriptionCommercial;
        this.produtctManual = produtctManual;
        this.categoryInstaleSoftId = categoryInstaleSoftId;
        this.categoryInstaleSoftName = categoryInstaleSoftName;
        this.categoryInstaleSoftImage = categoryInstaleSoftImage;
        this.categoryCommercialId = categoryCommercialId;
        this.categoryCommercialName = categoryCommercialName;
        this.categoryCommercialImage = categoryCommercialImage;
    }

    public ProdutoporAplicacaoMinDTO(ProdutoPorAplicacaoProjection projection) {
        productId = projection.getProductId();
        productName = projection.getProductName();
        productCode = projection.getProductCode();
        productImage = projection.getProductImage();
        productLogo = projection.getProductLogo();
        productDescriptionInstaleSoft = projection.getProductDescriptionInstaleSoft();
        productDescriptionCommercial = projection.getProductDescriptionCommercial();
        produtctManual = projection.getProductManual();
        categoryInstaleSoftId = projection.getCategoryInstaleSoftId();
        categoryInstaleSoftName = projection.getCategoryInstaleSoftName();
        categoryInstaleSoftImage = projection.getCategoryInstaleSoftImage();
        categoryCommercialId = projection.getCategoryCommercialId();
        categoryCommercialName = projection.getCategoryCommercialName();
        categoryCommercialImage = projection.getCategoryCommercialImage();
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductImage() {
        return productImage;
    }

    public String getProductLogo() {
        return productLogo;
    }

    public String getProductDescriptionInstaleSoft() {
        return productDescriptionInstaleSoft;
    }

    public String getProductDescriptionCommercial() {
        return productDescriptionCommercial;
    }

    public String getProdutctManual() {
        return produtctManual;
    }

    public Long getCategoryInstaleSoftId() {
        return categoryInstaleSoftId;
    }

    public String getCategoryInstaleSoftName() {
        return categoryInstaleSoftName;
    }

    public String getCategoryInstaleSoftImage() {
        return categoryInstaleSoftImage;
    }

    public Long getCategoryCommercialId() {
        return categoryCommercialId;
    }

    public String getCategoryCommercialName() {
        return categoryCommercialName;
    }

    public String getCategoryCommercialImage() {
        return categoryCommercialImage;
    }
}
