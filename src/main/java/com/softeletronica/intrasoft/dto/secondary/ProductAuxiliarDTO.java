package com.softeletronica.intrasoft.dto.secondary;

import com.softeletronica.intrasoft.entities.secondary.Product;
import com.softeletronica.intrasoft.entities.secondary.ProductAuxiliar;
import jakarta.validation.constraints.NotBlank;

import java.time.Instant;

public class ProductAuxiliarDTO {
    private Long id;
    private Long productId;
    private String code;
    private String name;
    private String descriptionCommercial;
    private String descriptionInstalesoft;
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

    public ProductAuxiliarDTO() {

    }

    public ProductAuxiliarDTO(Long id, Long productId, String code, String name, String descriptionCommercial, String descriptionInstalesoft,
                              String imgUrl1, String imgUrl2, String imgUrl3, String imgUrl4, String imgUrl5, String urlLogoImg,
                              String urlManual, Instant createdAt, Instant updatedAt, Boolean active, Long categoryCommercialId,
                              String nameCategoryCommercial) {
        this.id = id;
        this.productId = productId;
        this.code = code;
        this.name = name;
        this.descriptionCommercial = descriptionCommercial;
        this.descriptionInstalesoft = descriptionInstalesoft;
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
    }

    public ProductAuxiliarDTO(ProductAuxiliar entity) {
        this.id = entity.getId();
        this.productId = entity.getProductauxiliar().getId();
        this.code = entity.getProductauxiliar().getCode();
        this.name = entity.getProductauxiliar().getName();
        this.descriptionCommercial = entity.getProductauxiliar().getDescriptionCommercial();
        this.descriptionInstalesoft = entity.getProductauxiliar().getDescriptionInstalesoft();
        this.imgUrl1 = entity.getProductauxiliar().getImgUrl1();
        this.imgUrl2 = entity.getProductauxiliar().getImgUrl2();
        this.imgUrl3 = entity.getProductauxiliar().getImgUrl3();
        this.imgUrl4 = entity.getProductauxiliar().getImgUrl4();
        this.imgUrl5 = entity.getProductauxiliar().getImgUrl5();
        this.urlLogoImg = entity.getProductauxiliar().getUrlLogoImg();
        this.urlManual = entity.getProductauxiliar().getUrlManual();
        this.createdAt = entity.getProductauxiliar().getCreatedAt();
        this.updatedAt = entity.getProductauxiliar().getUpdatedAt();
        this.active = entity.getProductauxiliar().getActive();
        this.categoryCommercialId = (entity.getProductauxiliar().getCategoryProductCommercial() != null) ?
                entity.getProductauxiliar().getCategoryProductCommercial().getId() : null;
        this.nameCategoryCommercial = (entity.getProductauxiliar().getCategoryProductCommercial() != null) ?
                entity.getProductauxiliar().getCategoryProductCommercial().getName() : null;
    }


    public ProductAuxiliarDTO(Product entities) {
        id = entities.getId();
        code = entities.getCode();
        name = entities.getName();
        descriptionCommercial = entities.getDescriptionCommercial();
        descriptionInstalesoft = entities.getDescriptionInstalesoft();
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
        nameCategoryCommercial = (entities.getCategoryProductCommercial() != null) ? entities.getCategoryProductCommercial().getName() : null;
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
}
