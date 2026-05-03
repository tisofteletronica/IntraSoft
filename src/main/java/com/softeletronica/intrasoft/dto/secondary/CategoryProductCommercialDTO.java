package com.softeletronica.intrasoft.dto.secondary;


import com.softeletronica.intrasoft.entities.secondary.CategoryProductCommercial;

import java.time.Instant;

public class CategoryProductCommercialDTO {
    private Long id;
    private String name;
    private String imgUrl;
    private Boolean active;
    private Instant createdAt;
    private Instant updateAt;

    public CategoryProductCommercialDTO() {

    }

    public CategoryProductCommercialDTO(Long id, String name, String imgUrl, Boolean active, Instant createdAt, Instant updateAt) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
        this.active = active;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public CategoryProductCommercialDTO(CategoryProductCommercial entities) {
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
