package com.softeletronica.intrasoft.dto.secondary;

import com.softeletronica.intrasoft.entities.secondary.UnidadeSoft;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.Instant;

public class UnidadeSoftDTO {
    private Long id;
    @Size(min = 5, message = "A descrição deve conter pelo menos 5 caracteres")
    @NotBlank(message = "A descrição não deve estar em branco")
    private String description;
    private String address;
    private String number;
    private String complement;
    private String cep;
    private String city;
    private String neighborhood;
    @Size(max=2, message = "O Estado deve conter 2 caracteres")
    private String uf;
    private String country;
    private String phone1;
    private String phone2;
    private String phone3;
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
    private Instant createdAt;
    private Instant updateAt;
    private Boolean active;

    public UnidadeSoftDTO() {

    }

    public UnidadeSoftDTO(Long id, String description, String address, String number, String complement, String cep,
                          String city, String uf, String country, String neighborhood, String phone1, String phone2, String phone3,
                          String imgUrl1, String imgUrl2, String imgUrl3, String imgUrl4, String imgUrl5,
                          String imgUrl6, String imgUrl7, String imgUrl8, String imgUrl9, String imgUrl10,
                          Instant createdAt, Instant updateAt, Boolean active) {
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

    public UnidadeSoftDTO(UnidadeSoft entities) {
        id = entities.getId();
        description = entities.getDescription();
        address = entities.getAddress();
        number = entities.getNumber();
        complement = entities.getComplement();
        cep = entities.getCep();
        city = entities.getCity();
        neighborhood = entities.getNeighborhood();
        uf = entities.getUf();
        country = entities.getCountry();
        phone1 = entities.getPhone1();
        phone2 = entities.getPhone2();
        phone3 = entities.getPhone3();
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
        createdAt = entities.getCreatedAt();
        updateAt = entities.getUpdateAt();
        active = entities.getActive();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    public String getCep() {
        return cep;
    }

    public String getCity() {
        return city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getUf() {
        return uf;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone1() {
        return phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getPhone3() {
        return phone3;
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public Boolean getActive() {
        return active;
    }
}
