package com.softeletronica.intrasoft.entities.secondary;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_montagem_soft_servicos")
public class MontagemSoftServicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String servicos;
    @Column(columnDefinition = "TEXT")
    private String descricao;

    private String urlImg1;
    private String urlImg2;
    private String urlImg3;




public MontagemSoftServicos(){

}

    public MontagemSoftServicos(Long id, String servicos, String descricao, String urlImg1, String urlImg2, String urlImg3) {
        this.id = id;
        this.servicos = servicos;
        this.descricao = descricao;
        this.urlImg1 = urlImg1;
        this.urlImg2 = urlImg2;
        this.urlImg3 = urlImg3;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServicos() {
        return servicos;
    }
    public void setServicos(String servicos) {
        this.servicos = servicos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrlImg1() {
        return urlImg1;
    }

    public void setUrlImg1(String urlImg1) {
        this.urlImg1 = urlImg1;
    }

    public String getUrlImg2() {
        return urlImg2;
    }

    public void setUrlImg2(String urlImg2) {
        this.urlImg2 = urlImg2;
    }

    public String getUrlImg3() {
        return urlImg3;
    }

    public void setUrlImg3(String urlImg3) {
        this.urlImg3 = urlImg3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MontagemSoftServicos that = (MontagemSoftServicos) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
