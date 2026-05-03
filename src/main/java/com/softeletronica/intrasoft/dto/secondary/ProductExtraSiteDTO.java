package com.softeletronica.intrasoft.dto.secondary;


import com.softeletronica.intrasoft.entities.secondary.ProductExtraSite;

import java.time.Instant;

public class ProductExtraSiteDTO {
    private Long id;
    private String code;
    private String name;
    private String caracteristica;
    private String capaImagem;
    private String imgUrl1;
    private String imgUrl2;
    private String imgUrl3;
    private String imgUrl4;
    private String imgUrl5;
    private String imgUrl6;
    private String imgUrl7;
    private String imgUrl8;
    private String imgUrl9;
    private String imgUrl10;
    private String urlLogoImg;
    private String urlManual;
    private String urlManual_1;
    private Instant createdAt;
    private Instant updatedAt;
    private Boolean active;

    public ProductExtraSiteDTO(){

    }

    public ProductExtraSiteDTO(Long id, String code, String name, String caracteristica, String capaImagem, String imgUrl1, String imgUrl2,
                               String imgUrl3, String imgUrl4, String imgUrl5, String imgUrl6,  String imgUrl7, String imgUrl8,
                               String imgUrl9, String imgUrl10, String urlLogoImg, String urlManual,
                               String urlManual_1, Instant createdAt, Instant updatedAt, Boolean active) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.caracteristica = caracteristica;
        this.capaImagem = capaImagem;
        this.imgUrl1 = imgUrl1;
        this.imgUrl2 = imgUrl2;
        this.imgUrl3 = imgUrl3;
        this.imgUrl4 = imgUrl4;
        this.imgUrl5 = imgUrl5;
        this.imgUrl6 = imgUrl6;
        this.imgUrl7 = imgUrl7;
        this.imgUrl8 = imgUrl8;
        this.imgUrl9 = imgUrl9;
        this.imgUrl10 = imgUrl10;
        this.urlLogoImg = urlLogoImg;
        this.urlManual = urlManual;
        this.urlManual_1 = urlManual_1;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
    }

    public ProductExtraSiteDTO(ProductExtraSite entities) {
        id = entities.getId();
        code = entities.getCode();
        name = entities.getName();
        caracteristica = entities.getCaracteristica();
        capaImagem = entities.getCapaImagem();
        imgUrl1 = entities.getImgUrl1();
        imgUrl2 = entities.getImgUrl2();
        imgUrl3 = entities.getImgUrl3();
        imgUrl4 = entities.getImgUrl4();
        imgUrl5 = entities.getImgUrl5();
        imgUrl6 = entities.getImgUrl6();
        imgUrl7 = entities.getImgUrl7();
        imgUrl8 = entities.getImgUrl8();
        imgUrl9 = entities.getImgUrl9();
        imgUrl10 = entities.getImgUrl10();
        urlLogoImg = entities.getUrlLogoImg();
        urlManual = entities.getUrlManual();
        urlManual_1 = entities.getUrlManual_1();
        createdAt = entities.getCreatedAt();
        updatedAt = entities.getUpdatedAt();
        active = entities.getActive();
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

    public String getCaracteristica() {
        return caracteristica;
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

    public String getImgUrl6() {
        return imgUrl6;
    }

    public String getImgUrl7() {
        return imgUrl7;
    }

    public String getImgUrl8() {
        return imgUrl8;
    }

    public String getImgUrl9() {
        return imgUrl9;
    }

    public String getImgUrl10() {
        return imgUrl10;
    }

    public String getUrlLogoImg() {
        return urlLogoImg;
    }

    public String getUrlManual() {
        return urlManual;
    }

    public String getUrlManual_1() {
        return urlManual_1;
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
}
