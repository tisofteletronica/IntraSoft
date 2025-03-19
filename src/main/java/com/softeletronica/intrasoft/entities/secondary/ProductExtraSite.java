package com.softeletronica.intrasoft.entities.secondary;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_products_extra_site")
public class ProductExtraSite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String code;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String caracteristica;
    @Column(name = "capa_imagem")
    private String capaImagem;
    @Column(name = "img_url1")
    private String imgUrl1;
    @Column(name = "img_url2")
    private String imgUrl2;
    @Column(name = "img_url3")
    private String imgUrl3;
    @Column(name = "img_url4")
    private String imgUrl4;
    @Column(name = "img_url5")
    private String imgUrl5;
    @Column(name = "img_url6")
    private String imgUrl6;
    @Column(name = "img_url7")
    private String imgUrl7;
    @Column(name = "img_url8")
    private String imgUrl8;
    @Column(name = "img_url9")
    private String imgUrl9;
    @Column(name = "img_url10")
    private String imgUrl10;
    @Column(name = "url_logo_img")
    private String urlLogoImg;
    @Column(name = "url_manual")
    private String urlManual;
    @Column(name = "url_manual_1")
    private String urlManual_1;
    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "updated_at")
    private Instant updatedAt;
    private Boolean active;


    public ProductExtraSite() {

    }

    public ProductExtraSite(Long id, String code, String name, String caracteristica, String capaImagem, String imgUrl1, String imgUrl2,
                            String imgUrl3, String imgUrl4, String imgUrl5, String imgUrl6, String imgUrl7, String imgUrl8,
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getCapaImagem() {
        return capaImagem;
    }

    public void setCapaImagem(String capaImagem) {
        this.capaImagem = capaImagem;
    }

    public String getImgUrl1() {
        return imgUrl1;
    }

    public void setImgUrl1(String imgUrl1) {
        this.imgUrl1 = imgUrl1;
    }

    public String getImgUrl2() {
        return imgUrl2;
    }

    public void setImgUrl2(String imgUrl2) {
        this.imgUrl2 = imgUrl2;
    }

    public String getImgUrl3() {
        return imgUrl3;
    }

    public void setImgUrl3(String imgUrl3) {
        this.imgUrl3 = imgUrl3;
    }

    public String getImgUrl4() {
        return imgUrl4;
    }

    public void setImgUrl4(String imgUrl4) {
        this.imgUrl4 = imgUrl4;
    }

    public String getImgUrl5() {
        return imgUrl5;
    }

    public void setImgUrl5(String imgUrl5) {
        this.imgUrl5 = imgUrl5;
    }

    public String getImgUrl6() {
        return imgUrl6;
    }

    public void setImgUrl6(String imgUrl6) {
        this.imgUrl6 = imgUrl6;
    }

    public String getImgUrl7() {
        return imgUrl7;
    }

    public void setImgUrl7(String imgUrl7) {
        this.imgUrl7 = imgUrl7;
    }

    public String getImgUrl8() {
        return imgUrl8;
    }

    public void setImgUrl8(String imgUrl8) {
        this.imgUrl8 = imgUrl8;
    }

    public String getImgUrl9() {
        return imgUrl9;
    }

    public void setImgUrl9(String imgUrl9) {
        this.imgUrl9 = imgUrl9;
    }

    public String getImgUrl10() {
        return imgUrl10;
    }

    public void setImgUrl10(String imgUrl10) {
        this.imgUrl10 = imgUrl10;
    }

    public String getUrlLogoImg() {
        return urlLogoImg;
    }

    public void setUrlLogoImg(String urlLogoImg) {
        this.urlLogoImg = urlLogoImg;
    }

    public String getUrlManual() {
        return urlManual;
    }

    public void setUrlManual(String urlManual) {
        this.urlManual = urlManual;
    }

    public String getUrlManual_1() {
        return urlManual_1;
    }

    public void setUrlManual_1(String urlManual_1) {
        this.urlManual_1 = urlManual_1;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductExtraSite product = (ProductExtraSite) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
