package com.softeletronica.intrasoft.dto.secondary;

import com.softeletronica.intrasoft.entities.secondary.ContatoSoft;
import jakarta.validation.constraints.Email;

import java.time.Instant;

public class ContatoSoftDTO {
    private Long id;
    private String setor;
    private String whatsapp;
    private String phone1;
    private String phone2;
    private String phone3;
    private Instant createAt;
    private Instant updateAt;
    @Email(message = "Favor entrar um email válido")
    private String email;
    private Boolean active;

    public ContatoSoftDTO(){

    }

    public ContatoSoftDTO(Long id, String setor, String whatsapp, String phone1, String phone2, String phone3,
                          Instant createAt, Instant updateAt, String email, Boolean active) {
        this.id = id;
        this.setor = setor;
        this.whatsapp = whatsapp;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.email = email;
        this.active = active;
    }
    public ContatoSoftDTO(ContatoSoft entities) {
        id = entities.getId();
        setor = entities.getSetor();
        whatsapp = entities.getWhatsapp();
        phone1 = entities.getPhone1();
        phone2 = entities.getPhone2();
        phone3 = entities.getPhone3();
        createAt = entities.getCreateAt();
        updateAt = entities.getUpdateAt();
        email = entities.getEmail();
        active = entities.getActive();
    }

    public Long getId() {
        return id;
    }

    public String getSetor() {
        return setor;
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

    public String getEmail() {
        return email;
    }

    public Boolean getActive() {
        return active;
    }
}
