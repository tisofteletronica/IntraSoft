package com.softeletronica.intrasoft.dto.secondary;

import com.softeletronica.intrasoft.entities.secondary.RepresentanteSoft;

import java.time.Instant;

public class RepresentanteSoftDTO {
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


    public RepresentanteSoftDTO() {

    }

    public RepresentanteSoftDTO(Long id, String representante, String estadosRepresentantes, String whatsapp, String phone1,
                                String phone2, String phone3, Instant createAt, Instant updateAt, String contato, String email, Boolean active) {
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

    public RepresentanteSoftDTO(RepresentanteSoft entities) {
        id = entities.getId();
        representante = entities.getRepresentante();
        estadosRepresentantes = entities.getEstadosRepresentantes();
        whatsapp = entities.getWhatsapp();
        phone1 = entities.getPhone1();
        phone2 = entities.getPhone2();
        phone3 = entities.getPhone3();
        createAt = entities.getCreateAt();
        updateAt = entities.getUpdateAt();
        contato = entities.getContato();
        email = entities.getEmail();
        active = entities.getActive();
    }

    public Long getId() {
        return id;
    }

    public String getRepresentante() {
        return representante;
    }

    public String getEstadosRepresentantes() {
        return estadosRepresentantes;
    }

    public String getWhatsapp() {
        return whatsapp;
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

    public Instant getCreateAt() {
        return createAt;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public String getContato() {
        return contato;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getActive() {
        return active;
    }
}
