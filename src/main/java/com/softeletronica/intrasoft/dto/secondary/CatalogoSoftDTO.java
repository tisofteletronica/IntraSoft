package com.softeletronica.intrasoft.dto.secondary;

import com.softeletronica.intrasoft.entities.secondary.CatalogoSoft;

import java.time.Instant;

public class CatalogoSoftDTO {
    private Long id;
    private String descricao;
    private String local;
    private Instant createAt;
    private Instant updateAt;
    private Boolean active;

    public CatalogoSoftDTO(){

    }

    public CatalogoSoftDTO(Long id, String descricao, String local, Instant createAt, Instant updateAt, Boolean active) {
        this.id = id;
        this.descricao = descricao;
        this.local = local;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.active = active;
    }

    public CatalogoSoftDTO(CatalogoSoft entities) {
        id = entities.getId();
        descricao = entities.getDescricao();
        local = entities.getLocal();
        createAt = entities.getCreateAt();
        updateAt = entities.getUpdateAt();
        active = entities.getActive();
    }

    public Long getId() {
        return id;
    }

    public String getLocal() {
        return local;
    }

    public String getDescricao() {
        return descricao;
    }

    public Instant getCreateAt() {
        return createAt;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public Boolean getActive() {
        return active;
    }
}
