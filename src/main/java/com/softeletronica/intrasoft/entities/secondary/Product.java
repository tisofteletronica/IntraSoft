package com.softeletronica.intrasoft.entities.secondary;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String code;
    private String name;
    @Column(columnDefinition = "TEXT", name = "description_commercial_resume")
    private String descriptionCommercialResume;
    @Column(columnDefinition = "TEXT", name = "description_commercial")
    private String descriptionCommercial;
    @Column(columnDefinition = "TEXT", name = "description_characteristics_commercial")
    private String descriptionCharacteristicsCommercial;
    @Column(name = "application_commercial")
    private String applicationCommercial;
    @Column(columnDefinition = "TEXT", name = "epilogue_commercial")
    private String epilogueCommercial;
    @Column(columnDefinition = "TEXT", name = "description_instalesoft")
    private String descriptionInstalesoft;
    private Double weight;
    private Double length;
    private Double width;
    private Double height;
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
    @Column(name = "url_logo_img")
    private String urlLogoImg;
    @Column(name = "url_manual")
    private String urlManual;
    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "updated_at")
    private Instant updatedAt;
    private Boolean active;
    private String zip;

    @ManyToOne
    @JoinColumn(name = "categorycommercial_id")
    private CategoryProductCommercial categoryProductCommercial;

    @OneToMany(mappedBy = "products")
    private List<AplicacaoInstaleSoft> instaleSoft = new ArrayList<>();

    @OneToMany(mappedBy = "productauxiliar")
    private List<ProductAuxiliar> productAuxiliars = new ArrayList<>();
    @OneToMany(mappedBy = "productcommercial")
    private List<ProductCommercialMontadora> productCommercialMontadora = new ArrayList<>();

    public Product() {

    }

    public Product(Long id, String code, String name, String descriptionCommercialResume, String descriptionCommercial,
                   String descriptionCharacteristicsCommercial, String applicationCommercial, String epilogueCommercial,
                   String descriptionInstalesoft, Double weight, Double lenght, Double width, Double height, String capaImagem,
                   String imgUrl1, String imgUrl2, String imgUrl3, String imgUrl4, String imgUrl5, String urlLogoImg,
                   String urlManual, Instant createdAt, Instant updatedAt, Boolean active, String zip,
                   CategoryProductCommercial categoryProductCommercial) {
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
        this.categoryProductCommercial = categoryProductCommercial;
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

    public String getDescriptionCommercialResume() {
        return descriptionCommercialResume;
    }

    public void setDescriptionCommercialResume(String descriptionCommercialResume) {
        this.descriptionCommercialResume = descriptionCommercialResume;
    }

    public String getDescriptionCommercial() {
        return descriptionCommercial;
    }

    public void setDescriptionCommercial(String descriptionCommercial) {
        this.descriptionCommercial = descriptionCommercial;
    }

    public String getDescriptionCharacteristicsCommercial() {
        return descriptionCharacteristicsCommercial;
    }

    public void setDescriptionCharacteristicsCommercial(String descriptionCharacteristicsCommercial) {
        this.descriptionCharacteristicsCommercial = descriptionCharacteristicsCommercial;
    }

    public String getApplicationCommercial() {
        return applicationCommercial;
    }

    public void setApplicationCommercial(String applicationCommercial) {
        this.applicationCommercial = applicationCommercial;
    }

    public String getEpilogueCommercial() {
        return epilogueCommercial;
    }

    public void setEpilogueCommercial(String epilogueCommercial) {
        this.epilogueCommercial = epilogueCommercial;
    }

    public String getDescriptionInstalesoft() {
        return descriptionInstalesoft;
    }

    public void setDescriptionInstalesoft(String descriptionInstalesoft) {
        this.descriptionInstalesoft = descriptionInstalesoft;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public CategoryProductCommercial getCategoryProductCommercial() {
        return categoryProductCommercial;
    }

    public void setCategoryProductCommercial(CategoryProductCommercial categoryProductCommercial) {
        this.categoryProductCommercial = categoryProductCommercial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
