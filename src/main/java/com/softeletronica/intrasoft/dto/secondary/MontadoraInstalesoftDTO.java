package com.softeletronica.intrasoft.dto.secondary;


import com.softeletronica.intrasoft.entities.secondary.MontadoraInstalesoft;

import java.time.Instant;

public class MontadoraInstalesoftDTO {
    private Long id;
    private String name;
    private String urlImg;
    private Instant createdAt;
    private Instant updateAt;
    private Boolean active;

    public MontadoraInstalesoftDTO(){}

    public MontadoraInstalesoftDTO(Long id, String name, String urlImg, Instant createdAt, Instant updateAt, Boolean active) {
        this.id = id;
        this.name = name;
        this.urlImg = urlImg;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.active = active;
    }

    public MontadoraInstalesoftDTO(MontadoraInstalesoft entities) {
        id = entities.getId();
        name = entities.getName();
        urlImg = entities.getUrlImg();
        createdAt = entities.getCreatedAt();
        updateAt = entities.getUpdateAt();
        active = entities.getActive();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrlImg() {
        return urlImg;
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
