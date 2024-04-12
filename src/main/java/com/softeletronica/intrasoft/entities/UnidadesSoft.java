package com.softeletronica.intrasoft.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_unidadesoft")
public class UnidadesSoft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String city;
    private String uf;
    private String neighborhood;
    private String cep;
    private String phone1;
    private String phone2;

    public UnidadesSoft() {

    }

    public UnidadesSoft(Long id, String name, String address, String city, String uf, String neighborhood, String cep, String phone1,
                        String phone2) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnidadesSoft that = (UnidadesSoft) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
