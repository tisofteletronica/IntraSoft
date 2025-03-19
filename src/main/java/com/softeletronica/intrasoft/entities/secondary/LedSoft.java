package com.softeletronica.intrasoft.entities.secondary;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_led_soft")
public class LedSoft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    @Column(columnDefinition = "TEXT")
    private String producao;
    @Column(columnDefinition = "TEXT")
    private String projetos;
    @Column(columnDefinition = "TEXT")
    private String aplicacoes;
    @Column(columnDefinition = "TEXT")
    private String conclusao;
    private String urlImg;
    private String urlImg_2;
    private String urlImg_3;
    private String urlImg_4;
    private String urlImg_5;
    private String urlImg_6;
    private String imgSiteLed_1;
    private String imgSiteLed_2;
    private String imgSiteLed_3;
    private String imgSiteLed_4;
    private String imgSiteLed_5;



public LedSoft(){

}

    public LedSoft(Long id, String descricao, String producao, String projetos, String aplicacoes, String conclusao,
                   String urlImg,String urlImg_2,String urlImg_3,String urlImg_4,String urlImg_5, String urlImg_6,
                   String imgSiteLed_1, String imgSiteLed_2, String imgSiteLed_3, String imgSiteLed_4, String imgSiteLed_5) {
        this.id = id;
        this.descricao = descricao;
        this.producao = producao;
        this.projetos = projetos;
        this.aplicacoes = aplicacoes;
        this.conclusao = conclusao;
        this.urlImg = urlImg;
        this.urlImg_2 = urlImg_2;
        this.urlImg_3 = urlImg_3;
        this.urlImg_4 = urlImg_4;
        this.urlImg_5 = urlImg_5;
        this.urlImg_6 = urlImg_6;
        this.imgSiteLed_1 = imgSiteLed_1;
        this.imgSiteLed_2 = imgSiteLed_2;
        this.imgSiteLed_3 = imgSiteLed_3;
        this.imgSiteLed_4 = imgSiteLed_4;
        this.imgSiteLed_5 = imgSiteLed_5;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getProducao() {
        return producao;
    }

    public void setProducao(String producao) {
        this.producao = producao;
    }

    public String getProjetos() {
        return projetos;
    }

    public void setProjetos(String projetos) {
        this.projetos = projetos;
    }

    public String getAplicacoes() {
        return aplicacoes;
    }

    public void setAplicacoes(String aplicacoes) {
        this.aplicacoes = aplicacoes;
    }

    public String getConclusao() {
        return conclusao;
    }

    public void setConclusao(String conclusao) {
        this.conclusao = conclusao;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getUrlImg_2() {
        return urlImg_2;
    }

    public void setUrlImg_2(String urlImg_2) {
        this.urlImg_2 = urlImg_2;
    }

    public String getUrlImg_3() {
        return urlImg_3;
    }

    public void setUrlImg_3(String urlImg_3) {
        this.urlImg_3 = urlImg_3;
    }

    public String getUrlImg_4() {
        return urlImg_4;
    }

    public void setUrlImg_4(String urlImg_4) {
        this.urlImg_4 = urlImg_4;
    }

    public String getUrlImg_5() {
        return urlImg_5;
    }

    public void setUrlImg_5(String urlImg_5) {
        this.urlImg_5 = urlImg_5;
    }

    public String getUrlImg_6() {
        return urlImg_6;
    }

    public void setUrlImg_6(String urlImg_6) {
        this.urlImg_6 = urlImg_6;
    }

    public String getImgSiteLed_1() {
        return imgSiteLed_1;
    }

    public void setImgSiteLed_1(String imgSiteLed_1) {
        this.imgSiteLed_1 = imgSiteLed_1;
    }

    public String getImgSiteLed_2() {
        return imgSiteLed_2;
    }

    public void setImgSiteLed_2(String imgSiteLed_2) {
        this.imgSiteLed_2 = imgSiteLed_2;
    }

    public String getImgSiteLed_3() {
        return imgSiteLed_3;
    }

    public void setImgSiteLed_3(String imgSiteLed_3) {
        this.imgSiteLed_3 = imgSiteLed_3;
    }

    public String getImgSiteLed_4() {
        return imgSiteLed_4;
    }

    public void setImgSiteLed_4(String imgSiteLed_4) {
        this.imgSiteLed_4 = imgSiteLed_4;
    }

    public String getImgSiteLed_5() {
        return imgSiteLed_5;
    }

    public void setImgSiteLed_5(String imgSiteLed_5) {
        this.imgSiteLed_5 = imgSiteLed_5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LedSoft that = (LedSoft) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
