package com.softeletronica.intrasoft.entities.secondary;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_representantes_soft_site")
public class RepresentanteSoft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String representante;
    private String estadosRepresentantes;
    private String whatsapp;
    private String phone1;
    private String phone2;
    private String phone3;
    private Instant createAt;
    private Instant updateAt;
    private String contato;
    private String email;
    private Boolean active;

    public RepresentanteSoft() {

    }

    public RepresentanteSoft(Long id, String representante, String estadosRepresentantes, String whatsapp,
                              String phone1, String phone2, String phone3, Instant createAt, Instant updateAt,
                              String contato, String email, Boolean active) {
        this.id = id;
        this.representante = representante;
        this.estadosRepresentantes = estadosRepresentantes;
        this.whatsapp = whatsapp;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.contato = contato;
        this.email = email;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getEstadosRepresentantes() {
        return estadosRepresentantes;
    }

    public void setEstadosRepresentantes(String estadosRepresentantes) {
        this.estadosRepresentantes = estadosRepresentantes;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
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

    public Instant getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Instant createAt) {
        this.createAt = createAt;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Instant updateAt) {
        this.updateAt = updateAt;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        RepresentanteSoft that = (RepresentanteSoft) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
