package com.softeletronica.intrasoft.dto.secondary;


import com.softeletronica.intrasoft.entities.secondary.IsoSoft;

public class IsoSoftDTO {
    private Long id;
    private String name;
    private String imgUrl;
    private String imgUrl2;
    private Boolean active;

    public IsoSoftDTO(Long id, String name, String imgUrl, String imgUrl2, Boolean active) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
        this.imgUrl2 = imgUrl2;
        this.active = active;
    }

    public IsoSoftDTO(IsoSoft entities) {
        id = entities.getId();
        name = entities.getName();
        imgUrl = entities.getImgUrl();
        imgUrl2 = entities.getImgUrl2();
        active = entities.getActive();
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

    public String getImgUrl2() {
        return imgUrl2;
    }

    public Boolean getActive() {
        return active;
    }
}
