package com.softeletronica.intrasoft.dto.secondary;



import com.softeletronica.intrasoft.entities.secondary.AplicacaoInstaleSoft;

import java.time.Instant;

public class AplicacaoInstaleSoftDTO {
    private Long id;
    private Long modeloInstalesoftId;
    private String nameMontadoraInstaleSoft;
    private String nameModeloInstaleSoft;
    private Integer ano;
    private Integer anoDe;
    private Integer anoAte;
    private Long categoryComercialId;
    private String categoryComercialName;
    private Long categoryInstaleSoftId;
    private String categoryInstaleSoftName;
    private Long productId;
    private String productName;
    private String codigo;
    private String descricaoInstaleSoft;
    private String descricaoComercial;
    private Integer quantidade;
    private Integer vidroConvencional;
    private Integer vidroInteligente;
    private Boolean portas2;
    private Boolean porta4;
    private String urlManual;
    private String observacao;
    private String urlEsquema;
    private String urlVideo;
    private String imgUrl1;
    private String imgUrl2;
    private String imgUrl3;
    private String imgUrl4;
    private String imgUrl5;

    //Segundo Produto Combo
    private Long productId2;
    private String productName2;
    private String codigo2;
    private String descricaoInstaleSoft2;
    private String descricaoComercial2;
    private Integer quantidade2;
    private Integer vidroConvencional2;
    private Integer vidroInteligente2;
    private String urlManual2;
    private String observacao2;
    private String urlEsquema2;
    private String urlVideo2;
    private String imgUrl1_2;
    private String imgUrl2_2;
    private String imgUrl3_2;
    private String imgUrl4_2;
    private String imgUrl5_2;

    private Boolean combo;
    private Instant createdAt;
    private Instant updatedAt;
    private Boolean active;

    public AplicacaoInstaleSoftDTO() {

    }

    public AplicacaoInstaleSoftDTO(Long id, Long modeloInstalesoftId, String nameMontadoraInstaleSoft,
                                   String nameModeloInstaleSoft, Integer ano, Integer anoDe, Integer anoAte, Long categoryComercialId,
                                   String categoryComercialName, Long categoryInstaleSoftId,
                                   String categoryInstaleSoftName, Long productId, String productName,
                                   String codigo, String descricaoInstaleSoft, String descricaoComercial,
                                   Integer quantidade, Integer vidroConvencional, Integer vidroInteligente,
                                   Boolean portas2, Boolean porta4, String urlManual, String observacao,
                                   String urlEsquema, String urlVideo,
                                   String imgUrl1, String imgUrl2, String imgUrl3, String imgUrl4, String imgUrl5,
                                   Long productId2, String productName2, String codigo2, String descricaoInstaleSoft2,
                                   String descricaoComercial2, Integer quantidade2, Integer vidroConvencional2,
                                   Integer vidroInteligente2, String urlManual2, String observacao2,
                                   String urlEsquema2, String urlVideo2, String imgUrl1_2, String imgUrl2_2,
                                   String imgUrl3_2, String imgUrl4_2, String imgUrl5_2, Boolean combo,
                                   Instant createdAt, Instant updatedAt, Boolean active) {
        this.id = id;
        this.modeloInstalesoftId = modeloInstalesoftId;
        this.nameMontadoraInstaleSoft = nameMontadoraInstaleSoft;
        this.nameModeloInstaleSoft = nameModeloInstaleSoft;
        this.ano = ano;
        this.anoDe = anoDe;
        this.anoAte = anoAte;
        this.categoryComercialId = categoryComercialId;
        this.categoryComercialName = categoryComercialName;
        this.categoryInstaleSoftId = categoryInstaleSoftId;
        this.categoryInstaleSoftName = categoryInstaleSoftName;
        this.productId = productId;
        this.productName = productName;
        this.codigo = codigo;
        this.descricaoInstaleSoft = descricaoInstaleSoft;
        this.descricaoComercial = descricaoComercial;
        this.quantidade = quantidade;
        this.vidroConvencional = vidroConvencional;
        this.vidroInteligente = vidroInteligente;
        this.portas2 = portas2;
        this.porta4 = porta4;
        this.urlManual = urlManual;
        this.observacao = observacao;
        this.urlEsquema = urlEsquema;
        this.urlVideo = urlVideo;
        this.imgUrl1 = imgUrl1;
        this.imgUrl2 = imgUrl2;
        this.imgUrl3 = imgUrl3;
        this.imgUrl4 = imgUrl4;
        this.imgUrl5 = imgUrl5;
        this.productId2 = productId2;
        this.productName2 = productName2;
        this.codigo2 = codigo2;
        this.descricaoInstaleSoft2 = descricaoInstaleSoft2;
        this.descricaoComercial2 = descricaoComercial2;
        this.quantidade2 = quantidade2;
        this.vidroConvencional2 = vidroConvencional2;
        this.vidroInteligente2 = vidroInteligente2;
        this.urlManual2 = urlManual2;
        this.observacao2 = observacao2;
        this.urlEsquema2 = urlEsquema2;
        this.urlVideo2 = urlVideo2;
        this.imgUrl1_2 = imgUrl1_2;
        this.imgUrl2_2 = imgUrl2_2;
        this.imgUrl3_2 = imgUrl3_2;
        this.imgUrl4_2 = imgUrl4_2;
        this.imgUrl5_2 = imgUrl5_2;
        this.combo = combo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
    }

    public AplicacaoInstaleSoftDTO(AplicacaoInstaleSoft entities) {
        id = entities.getId();
        modeloInstalesoftId = (entities.getModeloInstalesoft() != null) ? entities.getModeloInstalesoft().getId() : null;
        nameMontadoraInstaleSoft = (entities.getModeloInstalesoft() != null) ? entities.getModeloInstalesoft().getMontadoras().getName() : null;
        nameModeloInstaleSoft = (entities.getModeloInstalesoft() != null) ? entities.getModeloInstalesoft().getName() : null;
        anoDe = entities.getAnoDe();
        anoAte = entities.getAnoAte();
        categoryComercialId = (entities.getProducts() != null) ? entities.getProducts().getCategoryProductCommercial().getId() : null;
        categoryComercialName = (entities.getProducts() != null) ? entities.getProducts().getCategoryProductCommercial().getName() : null;
        categoryInstaleSoftId = (entities.getCategoryProductInstaleSoft() != null) ? entities.getCategoryProductInstaleSoft().getId() : null;
        categoryInstaleSoftName = (entities.getCategoryProductInstaleSoft() != null) ? entities.getCategoryProductInstaleSoft().getName() : null;

        productId = (entities.getProducts() != null) ? entities.getProducts().getId() : null;
        productName = (entities.getProducts() != null) ? entities.getProducts().getName() : null;
        codigo = (entities.getProducts() != null) ? entities.getProducts().getCode() : null;
        descricaoInstaleSoft = (entities.getProducts() != null) ? entities.getProducts().getDescriptionInstalesoft() : null;
        descricaoComercial = (entities.getProducts() != null) ? entities.getProducts().getDescriptionCommercial() : null;
        quantidade = entities.getQuantidade();
        vidroConvencional = entities.getVidroConvencional();
        vidroInteligente = entities.getVidroInteligente();
        portas2 = entities.getPortas2();
        porta4 = entities.getPortas4();
        urlManual = (entities.getProducts() != null) ? entities.getProducts().getUrlManual() : null;
        observacao = entities.getObservacao();
        urlEsquema = entities.getUrlEsquema();
        urlVideo = entities.getUrlVideo();
        imgUrl1 = (entities.getProducts() != null) ? entities.getProducts().getImgUrl1() : null;
        imgUrl2 = (entities.getProducts() != null) ? entities.getProducts().getImgUrl2() : null;
        imgUrl3 = (entities.getProducts() != null) ? entities.getProducts().getImgUrl3() : null;
        imgUrl4 = (entities.getProducts() != null) ? entities.getProducts().getImgUrl4() : null;
        imgUrl5 = (entities.getProducts() != null) ? entities.getProducts().getImgUrl5() : null;

        productId2 = (entities.getProducts2() != null) ? entities.getProducts2().getProductauxiliar().getId() : null;
        productName2 = (entities.getProducts2() != null) ? entities.getProducts2().getProductauxiliar().getName() : null;
        codigo2 = (entities.getProducts2() != null) ? entities.getProducts2().getProductauxiliar().getCode() : null;
        quantidade2 = entities.getQuantidade2();
        descricaoInstaleSoft2 = (entities.getProducts2() != null) ? entities.getProducts2(). getProductauxiliar().getDescriptionInstalesoft(): null;
        descricaoComercial2 = (entities.getProducts2() != null) ? entities.getProducts2().getProductauxiliar().getDescriptionCommercial() : null;
        vidroConvencional2 = entities.getVidroConvencional2();
        vidroInteligente2 = entities.getVidroInteligente2();
        urlManual2 = (entities.getProducts2() != null) ? entities.getProducts2().getProductauxiliar().getUrlManual() : null;
        observacao2 = entities.getObservacao2();
        urlEsquema2 = entities.getUrlEsquema2();
        urlVideo2 = entities.getUrlVideo2();
        imgUrl1_2 = (entities.getProducts2() != null) ? entities.getProducts2().getProductauxiliar().getImgUrl1() : null;
        imgUrl2_2 = (entities.getProducts2() != null) ? entities.getProducts2().getProductauxiliar().getImgUrl2() : null;
        imgUrl3_2 = (entities.getProducts2() != null) ? entities.getProducts2().getProductauxiliar().getImgUrl3() : null;
        imgUrl4_2 = (entities.getProducts2() != null) ? entities.getProducts2().getProductauxiliar().getImgUrl4() : null;
        imgUrl5_2 = (entities.getProducts2() != null) ? entities.getProducts2().getProductauxiliar().getImgUrl5() : null;

        combo = entities.getCombo();
        createdAt = entities.getCreatedAt();
        updatedAt = entities.getUpdatedAt();
        active = entities.getActive();
    }

    public AplicacaoInstaleSoftDTO(AplicacaoInstaleSoft entity, Integer ano) {
        this(entity);
        this.ano = ano;
    }
    public Long getId() {
        return id;
    }

    public Long getModeloInstalesoftId() {
        return modeloInstalesoftId;
    }

    public String getNameMontadoraInstaleSoft() {
        return nameMontadoraInstaleSoft;
    }

    public String getNameModeloInstaleSoft() {
        return nameModeloInstaleSoft;
    }

    public Integer getAno() {
        return ano;
    }
    public Integer getAnoDe() {
        return anoDe;
    }

    public Integer getAnoAte() {
        return anoAte;
    }

    public Long getCategoryComercialId() {
        return categoryComercialId;
    }

    public String getCategoryComercialName() {
        return categoryComercialName;
    }

    public Long getCategoryInstaleSoftId() {
        return categoryInstaleSoftId;
    }

    public String getCategoryInstaleSoftName() {
        return categoryInstaleSoftName;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricaoInstaleSoft() {
        return descricaoInstaleSoft;
    }

    public String getDescricaoComercial() {
        return descricaoComercial;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Integer getVidroConvencional() {
        return vidroConvencional;
    }

    public Integer getVidroInteligente() {
        return vidroInteligente;
    }

    public Boolean getPortas2() {
        return portas2;
    }

    public Boolean getPorta4() {
        return porta4;
    }

    public String getUrlManual() {
        return urlManual;
    }

    public String getUrlEsquema() {
        return urlEsquema;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public String getImgUrl1() {
        return imgUrl1;
    }

    public String getImgUrl2() {
        return imgUrl2;
    }

    public String getImgUrl3() {
        return imgUrl3;
    }

    public String getImgUrl4() {
        return imgUrl4;
    }

    public String getImgUrl5() {
        return imgUrl5;
    }

    public Long getProductId2() {
        return productId2;
    }

    public String getProductName2() {
        return productName2;
    }

    public String getCodigo2() {
        return codigo2;
    }

    public String getDescricaoInstaleSoft2() {
        return descricaoInstaleSoft2;
    }

    public String getDescricaoComercial2() {
        return descricaoComercial2;
    }

    public Integer getQuantidade2() {
        return quantidade2;
    }

    public Integer getVidroConvencional2() {
        return vidroConvencional2;
    }

    public Integer getVidroInteligente2() {
        return vidroInteligente2;
    }

    public String getUrlManual2() {
        return urlManual2;
    }

    public String getUrlEsquema2() {
        return urlEsquema2;
    }

    public String getUrlVideo2() {
        return urlVideo2;
    }

    public String getImgUrl1_2() {
        return imgUrl1_2;
    }

    public String getImgUrl2_2() {
        return imgUrl2_2;
    }

    public String getImgUrl3_2() {
        return imgUrl3_2;
    }

    public String getImgUrl4_2() {
        return imgUrl4_2;
    }

    public String getImgUrl5_2() {
        return imgUrl5_2;
    }


    public Boolean getCombo() {
        return combo;
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

    public String getObservacao() {
        return observacao;
    }

    public String getObservacao2() {
        return observacao2;
    }


}
