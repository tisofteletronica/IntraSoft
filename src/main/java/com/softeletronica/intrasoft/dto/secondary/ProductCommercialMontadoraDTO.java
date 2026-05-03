package com.softeletronica.intrasoft.dto.secondary;


import com.softeletronica.intrasoft.entities.secondary.MontadoraInstalesoft;
import com.softeletronica.intrasoft.entities.secondary.Product;
import com.softeletronica.intrasoft.entities.secondary.ProductCommercialMontadora;
import jakarta.validation.constraints.NotBlank;

import java.time.Instant;

public class ProductCommercialMontadoraDTO {
    private Long id;
    private Long productId;
    private String code;
    private String name;
    private String descriptionCommercial;
    private String descriptionInstalesoft;
    private Double weight;
    private Double length;
    private Double width;
    private Double height;
    private String capaImagem;
    private String imgUrl1;
    private String imgUrl2;
    private String imgUrl3;
    private String imgUrl4;
    private String imgUrl5;
    private String urlLogoImg;
    private String urlManual;
    private Instant createdAt;
    private Instant updatedAt;
    private Boolean active;
    private Long categoryCommercialId;
    private String nameCategoryCommercial;
    private Long montadoraId;
    private String nameMontadora;

    public ProductCommercialMontadoraDTO() {

    }

    public ProductCommercialMontadoraDTO(Long id, Long productId, String code, String name, String descriptionCommercial,
                                         String descriptionInstalesoft, Double weight, Double length, Double width,
                                         Double height, String capaImagem, String imgUrl1, String imgUrl2, String imgUrl3,
                                         String imgUrl4, String imgUrl5, String urlLogoImg, String urlManual,
                                         Instant createdAt, Instant updatedAt, Boolean active, Long categoryCommercialId,
                                         String nameCategoryCommercial, Long montadoraId, String nameMontadora) {
        this.id = id;
        this.productId= productId;
        this.code = code;
        this.name = name;
        this.descriptionCommercial = descriptionCommercial;
        this.descriptionInstalesoft = descriptionInstalesoft;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
        this.capaImagem = capaImagem;
        this.imgUrl1 = imgUrl1;
        this.imgUrl2 = imgUrl2;
        this.imgUrl3 = imgUrl3;
        this.imgUrl4 = imgUrl4;
        this.imgUrl5 = imgUrl5;
        this.urlLogoImg = urlLogoImg;
        this.urlManual = urlManual;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
        this.categoryCommercialId = categoryCommercialId;
        this.nameCategoryCommercial = nameCategoryCommercial;
        this.montadoraId = montadoraId;
        this.nameMontadora = nameMontadora;
    }
    public ProductCommercialMontadoraDTO(ProductCommercialMontadora entity, MontadoraInstalesoft montadora) {
        this.id = entity.getId();
        this.productId = entity.getProductcommercial().getId();
        this.code = entity.getProductcommercial().getCode();
        this.name = entity.getProductcommercial().getName();
        this.descriptionCommercial = entity.getProductcommercial().getDescriptionCommercial();
        this.descriptionInstalesoft = entity.getProductcommercial().getDescriptionInstalesoft();
        this.weight = entity.getProductcommercial().getWeight();
        this.length = entity.getProductcommercial().getLength();
        this.width = entity.getProductcommercial().getWidth();
        this.height = entity.getProductcommercial().getHeight();
        this.capaImagem = entity.getProductcommercial().getCapaImagem();
        this.imgUrl1 = entity.getProductcommercial().getImgUrl1();
        this.imgUrl2 = entity.getProductcommercial().getImgUrl2();
        this.imgUrl3 = entity.getProductcommercial().getImgUrl3();
        this.imgUrl4 = entity.getProductcommercial().getImgUrl4();
        this.imgUrl5 = entity.getProductcommercial().getImgUrl5();
        this.urlLogoImg = entity.getProductcommercial().getUrlLogoImg();
        this.urlManual = entity.getProductcommercial().getUrlManual();
        this.createdAt = entity.getProductcommercial().getCreatedAt();
        this.updatedAt = entity.getProductcommercial().getUpdatedAt();
        this.active = entity.getProductcommercial().getActive();
        this.categoryCommercialId = (entity.getProductcommercial().getCategoryProductCommercial() != null) ?
                entity.getProductcommercial().getCategoryProductCommercial().getId() : null;
        this.nameCategoryCommercial = (entity.getProductcommercial().getCategoryProductCommercial() != null) ?
                entity.getProductcommercial().getCategoryProductCommercial().getName() : null;
        montadoraId = montadora.getId();
        nameMontadora = montadora.getName();
    }


    public ProductCommercialMontadoraDTO(Product entities, ProductCommercialMontadora productMontadora) {
        id = productMontadora.getId();
        productId = entities.getId();
        code = entities.getCode();
        name = entities.getName();
        descriptionCommercial = entities.getDescriptionCommercial();
        descriptionInstalesoft = entities.getDescriptionInstalesoft();
        weight = entities.getWeight();
        length = entities.getLength();
        width = entities.getWidth();
        height = entities.getHeight();
        capaImagem = entities.getCapaImagem();
        imgUrl1 = entities.getImgUrl1();
        imgUrl2 = entities.getImgUrl2();
        imgUrl3 = entities.getImgUrl3();
        imgUrl4 = entities.getImgUrl4();
        imgUrl5 = entities.getImgUrl5();
        urlLogoImg = entities.getUrlLogoImg();
        urlManual = entities.getUrlManual();
        createdAt = entities.getCreatedAt();
        updatedAt = entities.getUpdatedAt();
        active = entities.getActive();

        categoryCommercialId = (entities.getCategoryProductCommercial() != null) ?
                entities.getCategoryProductCommercial().getId() : null;
        nameCategoryCommercial = (entities.getCategoryProductCommercial() != null) ?
                entities.getCategoryProductCommercial().getName() : null;


        this.montadoraId = (productMontadora != null && productMontadora.getProductmontadoras() != null) ?
                productMontadora.getProductmontadoras().getId() : null;
        this.nameMontadora = (productMontadora != null && productMontadora.getProductmontadoras() != null) ?
                productMontadora.getProductmontadoras().getName() : null;
    }


    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescriptionCommercial() {
        return descriptionCommercial;
    }

    public String getDescriptionInstalesoft() {
        return descriptionInstalesoft;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getLength() {
        return length;
    }

    public Double getWidth() {
        return width;
    }

    public Double getHeight() {
        return height;
    }

    public String getCapaImagem() {
        return capaImagem;
    }

    public String getImgUrl1() {
        return imgUrl1;
    }

    public String getImgUrl2() {
        return imgUrl2;
    }

    public String getImgUrl3() {
        return imgUrl3;
    }

    public String getImgUrl4() {
        return imgUrl4;
    }

    public String getImgUrl5() {
        return imgUrl5;
    }

    public String getUrlLogoImg() {
        return urlLogoImg;
    }

    public String getUrlManual() {
        return urlManual;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Boolean getActive() {
        return active;
    }

    public Long getCategoryCommercialId() {
        return categoryCommercialId;
    }

    public String getNameCategoryCommercial() {
        return nameCategoryCommercial;
    }

    public Long getMontadoraId() {
        return montadoraId;
    }

    public String getNameMontadora() {
        return nameMontadora;
    }
}
