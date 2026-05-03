package com.softeletronica.intrasoft.dto.secondary;


import com.softeletronica.intrasoft.entities.secondary.MontagemSoftAtuacao;

import java.time.Instant;

public class MontagemSoftAtuacaoDTO {
    private Long id;
    private String descricao;
    private String img_url;
    private Instant createAt;
    private Instant updateAt;
    private String active;

    public MontagemSoftAtuacaoDTO(){

    }

    public MontagemSoftAtuacaoDTO(Long id, String descricao, String img_url, Instant createAt, Instant updateAt,
                                  String active) {
        this.id = id;
        this.descricao = descricao;
        this.img_url = img_url;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.active = active;
    }

    public MontagemSoftAtuacaoDTO(MontagemSoftAtuacao entities) {
        id = entities.getId();
        descricao = entities.getDescricao();
        img_url = entities.getImg_url();
        createAt = entities.getCreateAt();
        updateAt = entities.getUpdateAt();
        active = entities.getActive();
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getImg_url() {
        return img_url;
    }

    public Instant getCreateAt() {
        return createAt;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public String getActive() {
        return active;
    }
}
