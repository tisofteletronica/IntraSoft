package com.softeletronica.intrasoft.dto;

import com.softeletronica.intrasoft.entities.UnidadesSoft;

public class UnidadesSoftDTO {
    private Long id;
    private String name;
    private String address;
    private String city;
    private String uf;
    private String neighborhood;
    private String cep;
    private String phone1;
    private String phone2;

    public UnidadesSoftDTO() {
    }

    public UnidadesSoftDTO(Long id, String name, String address, String city, String uf, String neighborhood, String cep,
                           String phone1, String phone2) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.uf = uf;
        this.neighborhood = neighborhood;
        this.cep = cep;
        this.phone1 = phone1;
        this.phone2 = phone2;
    }

    public UnidadesSoftDTO(UnidadesSoft entity) {
        id = entity.getId();
        name = entity.getName();
        address = entity.getAddress();
        city = entity.getCity();
        uf = entity.getUf();
        neighborhood = entity.getNeighborhood();
        cep = entity.getCep();
        phone1 = entity.getPhone1();
        phone2 = entity.getPhone2();


    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getUf() {
        return uf;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCep() {
        return cep;
    }

    public String getPhone1() {
        return phone1;
    }

    public String getPhone2() {
        return phone2;
    }


}
