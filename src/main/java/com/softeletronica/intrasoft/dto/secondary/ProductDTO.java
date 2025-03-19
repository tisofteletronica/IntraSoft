package com.softeletronica.intrasoft.dto.secondary;

import com.softeletronica.intrasoft.entities.secondary.Product;
import jakarta.validation.constraints.NotBlank;

import java.time.Instant;

public class ProductDTO {
    private Long id;

    private String code;
    private String name;
    private String descriptionCommercialResume;
    private String descriptionCommercial;
    private String descriptionCharacteristicsCommercial;
    private String applicationCommercial;
    private String epilogueCommercial;
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
    private String zip;
    private Long categoryCommercialId;
    private String nameCategoryCommercial;

    public ProductDTO() {

    }

    public ProductDTO(Long id, String code, String name, String descriptionCommercialResume, String descriptionCommercial,
                      String descriptionCharacteristicsCommercial, String applicationCommercial, String epilogueCommercial,
                      String descriptionInstalesoft, Double weight, Double lenght, Double width,Double height, String capaImagem,
                      String imgUrl1, String imgUrl2, String imgUrl3, String imgUrl4, String imgUrl5, String urlLogoImg,
                      String urlManual, Instant createdAt, Instant updatedAt, Boolean active, String zip,  Long categoryCommercialId,
                      String nameCategoryCommercial) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.descriptionCommercialResume = descriptionCommercialResume;
        this.descriptionCommercial = descriptionCommercial;
        this.descriptionCharacteristicsCommercial = descriptionCharacteristicsCommercial;
        this.applicationCommercial = applicationCommercial;
        this.epilogueCommercial = epilogueCommercial;
        this.descriptionInstalesoft = descriptionInstalesoft;
        this.weight = weight;
        this.length = lenght;
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
        this.zip = zip;
        this.categoryCommercialId = categoryCommercialId;
        this.nameCategoryCommercial = nameCategoryCommercial;
    }

    public ProductDTO(Product entities) {
        id = entities.getId();
        code = entities.getCode();
        name = entities.getName();
        descriptionCommercialResume = entities.getDescriptionCommercialResume();
        descriptionCommercial = entities.getDescriptionCommercial();
        descriptionCharacteristicsCommercial = entities.getDescriptionCharacteristicsCommercial();
        applicationCommercial = entities.getApplicationCommercial();
        epilogueCommercial = entities.getEpilogueCommercial();
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
        zip = entities.getZip();
        categoryCommercialId = (entities.getCategoryProductCommercial() != null) ?
                entities.getCategoryProductCommercial().getId() : null;
        nameCategoryCommercial = (entities.getCategoryProductCommercial() != null) ? entities.getCategoryProductCommercial().getName() : null;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescriptionCommercialResume() {
        return descriptionCommercialResume;
    }

    public String getDescriptionCommercial() {
        return descriptionCommercial;
    }

    public String getDescriptionCharacteristicsCommercial() {
        return descriptionCharacteristicsCommercial;
    }

    public String getApplicationCommercial() {
        return applicationCommercial;
    }

    public String getEpilogueCommercial() {
        return epilogueCommercial;
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

    public String getZip() {
        return zip;
    }

    public Long getCategoryCommercialId() {
        return categoryCommercialId;
    }

    public String getNameCategoryCommercial() {
        return nameCategoryCommercial;
    }
}
