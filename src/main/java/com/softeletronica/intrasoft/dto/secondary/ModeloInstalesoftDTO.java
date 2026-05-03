package com.softeletronica.intrasoft.dto.secondary;


import com.softeletronica.intrasoft.entities.secondary.ModeloInstalesoft;

import java.time.Instant;

public class ModeloInstalesoftDTO {
    private Long id;
    private String name;
    private Long montadoraId;
    private String montadoraName;
    private Instant createdAt;
    private Instant updatedAt;
    private Boolean active;

    public ModeloInstalesoftDTO() {
    }

    public ModeloInstalesoftDTO(Long id, String name, Long montadoraId, String montadoraName, Instant createdAt,
                                Instant updatedAt, Boolean active) {
        this.id = id;
        this.name = name;
        this.montadoraId = montadoraId;
        this.montadoraName = montadoraName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
    }

    public ModeloInstalesoftDTO(ModeloInstalesoft entities) {
        id = entities.getId();
        name = entities.getName();
        montadoraId = (entities.getMontadoras() != null) ? entities.getMontadoras().getId() : null;
        montadoraName = (entities.getMontadoras() != null) ? entities.getMontadoras().getName() : null;
        createdAt = entities.getCreatedAt();
        updatedAt = entities.getUpdatedAt();
        active = entities.getActive();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getMontadoraId() {
        return montadoraId;
    }

    public String getMontadoraName() {
        return montadoraName;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Boolean getActive() {
        return active;
    }
}
