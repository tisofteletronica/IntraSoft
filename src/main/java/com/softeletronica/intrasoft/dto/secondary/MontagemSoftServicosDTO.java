package com.softeletronica.intrasoft.dto.secondary;


import com.softeletronica.intrasoft.entities.secondary.MontagemSoftServicos;

import java.util.Objects;


public class MontagemSoftServicosDTO {
    private Long id;
    private String servicos;
    private String descricao;

    private String urlImg1;
    private String urlImg2;
    private String urlImg3;


    public MontagemSoftServicosDTO() {

    }

    public MontagemSoftServicosDTO(Long id, String servicos, String descricao, String urlImg1, String urlImg2, String urlImg3) {
        this.id = id;
        this.servicos = servicos;
        this.descricao = descricao;
        this.urlImg1 = urlImg1;
        this.urlImg2 = urlImg2;
        this.urlImg3 = urlImg3;
    }

    public MontagemSoftServicosDTO(MontagemSoftServicos entities) {
        id = entities.getId();
        servicos = entities.getServicos();
        descricao = entities.getDescricao();
        urlImg1 = entities.getUrlImg1();
        urlImg2 = entities.getUrlImg2();
        urlImg3 = entities.getUrlImg3();

    }

    public Long getId() {
        return id;
    }

    public String getServicos() {
        return servicos;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getUrlImg1() {
        return urlImg1;
    }

    public String getUrlImg2() {
        return urlImg2;
    }

    public String getUrlImg3() {
        return urlImg3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MontagemSoftServicosDTO that = (MontagemSoftServicosDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
