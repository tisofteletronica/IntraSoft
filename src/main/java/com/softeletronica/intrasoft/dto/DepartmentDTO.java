package com.softeletronica.intrasoft.dto;

import com.softeletronica.intrasoft.entities.Department;

public class DepartmentDTO {
    private Long id;
    private String name;
    private String imgUrl;
    private Boolean active;

    public DepartmentDTO(){}

    public DepartmentDTO(Long id, String name, String imgUrl, Boolean active) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
        this.active = active;
    }

    public DepartmentDTO(Department entity) {
        id = entity.getId();
        name = entity.getName();
        imgUrl = entity.getImgUrl();
        active = entity.getActive();
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
}
