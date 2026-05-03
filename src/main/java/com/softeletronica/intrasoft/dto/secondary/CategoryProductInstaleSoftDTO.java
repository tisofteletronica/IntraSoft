package com.softeletronica.intrasoft.dto.secondary;

import com.softeletronica.intrasoft.entities.secondary.CategoryProductInstaleSoft;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.Instant;

public class CategoryProductInstaleSoftDTO {
    private Long id;
    @Size(min = 5, message = "Deve ter minímo 5 caracteres")
    @NotBlank(message = "Campo Requerido")
    private String name;
    private String imgUrl;
    private Boolean active;
    @PastOrPresent(message = "A data e hora do cadastro não corresponde a data e hora de agora")
    private Instant createdAt;
    @PastOrPresent(message = "A data e hora do cadastro não corresponde a data e hora de agora")
    private Instant updateAt;

    public CategoryProductInstaleSoftDTO() {

    }

    public CategoryProductInstaleSoftDTO(Long id, String name, String imgUrl, Boolean active, Instant createdAt, Instant updateAt) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
        this.active = active;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public CategoryProductInstaleSoftDTO(CategoryProductInstaleSoft entities) {
        id = entities.getId();
        name = entities.getName();
        imgUrl = entities.getImgUrl();
        active = entities.getActive();
        createdAt = entities.getCreatedAt();
        updateAt = entities.getUpdateAt();
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Boolean getActive() {
        return active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }
}
