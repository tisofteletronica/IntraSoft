package com.softeletronica.intrasoft.entities.secondary;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_unidade_soft")
public class UnidadeSoft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String address;
    private String number;
    private String complement;
    private String cep;
    private String city;
    private String neighborhood;
    private String uf;
    private String country;
    private String phone1;
    private String phone2;
    private String phone3;
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
    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "update_at")
    private Instant updateAt;
    private Boolean active;

    public UnidadeSoft() {

    }

    public UnidadeSoft(Long id, String description, String address, String number, String complement, String cep,
                       String city, String neighborhood, String uf, String country, String phone1, String phone2,
                       String phone3, String imgUrl1, String imgUrl2, String imgUrl3, String imgUrl4, String imgUrl5,
                       String imgUrl6, String imgUrl7, String imgUrl8, String imgUrl9, String imgUrl10, Instant createdAt,
                       Instant updateAt, Boolean active) {
        this.id = id;
        this.description = description;
        this.address = address;
        this.number = number;
        this.complement = complement;
        this.cep = cep;
        this.city = city;
        this.neighborhood = neighborhood;
        this.uf = uf;
        this.country = country;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
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
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Instant updateAt) {
        this.updateAt = updateAt;
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
        UnidadeSoft that = (UnidadeSoft) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
