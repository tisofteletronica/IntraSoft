package com.softeletronica.intrasoft.dto.secondary;


import com.softeletronica.intrasoft.entities.secondary.LedSoft;

public class LedSoftDTO {
    private Long id;
    private String descricao;
    private String producao;
    private String projetos;
    private String aplicacoes;
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
    public LedSoftDTO(){

    }

    public LedSoftDTO(Long id, String descricao, String producao, String projetos, String aplicacoes, String conclusao,
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

    public LedSoftDTO(LedSoft entity) {
       id = entity.getId();
       descricao = entity.getDescricao();
       producao = entity.getProducao();
       projetos = entity.getProjetos();
       aplicacoes = entity.getAplicacoes();
       conclusao = entity.getConclusao();
       urlImg = entity.getUrlImg();
       urlImg_2 = entity.getUrlImg_2();
       urlImg_3 = entity.getUrlImg_3();
       urlImg_4 = entity.getUrlImg_4();
       urlImg_5 = entity.getUrlImg_5();
       urlImg_6 = entity.getUrlImg_6();
       imgSiteLed_1 = entity.getImgSiteLed_1();
       imgSiteLed_2 = entity.getImgSiteLed_2();
       imgSiteLed_3 = entity.getImgSiteLed_3();
       imgSiteLed_4 = entity.getImgSiteLed_4();
       imgSiteLed_5 = entity.getImgSiteLed_5();
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getProducao() {
        return producao;
    }

    public String getProjetos() {
        return projetos;
    }

    public String getAplicacoes() {
        return aplicacoes;
    }

    public String getConclusao() {
        return conclusao;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public String getUrlImg_2() {
        return urlImg_2;
    }

    public String getUrlImg_3() {
        return urlImg_3;
    }

    public String getUrlImg_4() {
        return urlImg_4;
    }

    public String getUrlImg_5() {
        return urlImg_5;
    }

    public String getUrlImg_6() {
        return urlImg_6;
    }

    public String getImgSiteLed_1() {
        return imgSiteLed_1;
    }

    public String getImgSiteLed_2() {
        return imgSiteLed_2;
    }

    public String getImgSiteLed_3() {
        return imgSiteLed_3;
    }

    public String getImgSiteLed_4() {
        return imgSiteLed_4;
    }

    public String getImgSiteLed_5() {
        return imgSiteLed_5;
    }
}
