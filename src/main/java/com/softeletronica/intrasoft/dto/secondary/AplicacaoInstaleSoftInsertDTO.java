package com.softeletronica.intrasoft.dto.secondary;



import com.softeletronica.intrasoft.entities.secondary.AplicacaoInstaleSoft;

import java.time.Instant;

public class AplicacaoInstaleSoftInsertDTO {
    private Long id;
    private Long modeloInstalesoftId;

    private Integer anoDe;
    private Integer anoAte;

    private Long categoryInstaleSoftId;
    private Long productId;

    private String descricaoInstaleSoft;
    private Integer quantidade;
    private Integer vidroConvencional;
    private Integer vidroInteligente;
    private Boolean portas2;
    private Boolean porta4;
    private String observacao;
    private String urlEsquema;
    private String urlVideo;

    //Segundo Produto Combo
    private Long productId2;
    private String descricaoInstaleSoft2;
    private Integer quantidade2;
    private Integer vidroConvencional2;
    private Integer vidroInteligente2;
    private String observacao2;
    private String urlEsquema2;
    private String urlVideo2;

    private Boolean combo;
    private Instant createdAt;
    private Instant updatedAt;
    private Boolean active;

    public AplicacaoInstaleSoftInsertDTO() {

    }

    public AplicacaoInstaleSoftInsertDTO(Long id, Long modeloInstalesoftId, Integer anoDe, Integer anoAte,
                                         Long categoryInstaleSoftId, Long productId, String descricaoInstaleSoft, Integer quantidade,
                                         Integer vidroConvencional, Integer vidroInteligente, Boolean portas2,
                                         Boolean porta4,  String observacao, String urlEsquema,
                                         String urlVideo, Long productId2, String descricaoInstaleSoft2, Integer quantidade2,
                                         Integer vidroConvencional2, Integer vidroInteligente2,
                                         String observacao2, String urlEsquema2, String urlVideo2,
                                         Boolean combo, Instant createdAt, Instant updatedAt, Boolean active) {
        this.id = id;
        this.modeloInstalesoftId = modeloInstalesoftId;
        this.anoDe = anoDe;
        this.anoAte = anoAte;
        this.categoryInstaleSoftId = categoryInstaleSoftId;
        this.productId = productId;
        this.descricaoInstaleSoft = descricaoInstaleSoft;
        this.quantidade = quantidade;
        this.vidroConvencional = vidroConvencional;
        this.vidroInteligente = vidroInteligente;
        this.portas2 = portas2;
        this.porta4 = porta4;
        this.observacao = observacao;
        this.urlEsquema = urlEsquema;
        this.urlVideo = urlVideo;
        this.productId2 = productId2;
        this.descricaoInstaleSoft2 = descricaoInstaleSoft2;
        this.quantidade2 = quantidade2;
        this.vidroConvencional2 = vidroConvencional2;
        this.vidroInteligente2 = vidroInteligente2;
        this.observacao2 = observacao2;
        this.urlEsquema2 = urlEsquema2;
        this.urlVideo2 = urlVideo2;
        this.combo = combo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
    }

    public AplicacaoInstaleSoftInsertDTO(AplicacaoInstaleSoft entities) {
        id = entities.getId();
        modeloInstalesoftId = (entities.getModeloInstalesoft() != null) ? entities.getModeloInstalesoft().getId() : null;
        anoDe = entities.getAnoDe();
        anoAte = entities.getAnoAte();
        categoryInstaleSoftId = (entities.getCategoryProductInstaleSoft() != null) ? entities.getCategoryProductInstaleSoft().getId() : null;
        productId = (entities.getProducts() != null) ? entities.getProducts().getId() : null;
        quantidade = entities.getQuantidade();
        vidroConvencional = entities.getVidroConvencional();
        vidroInteligente = entities.getVidroInteligente();
        portas2 = entities.getPortas2();
        porta4 = entities.getPortas4();
        observacao = entities.getObservacao();
        urlEsquema = entities.getUrlEsquema();
        urlVideo = entities.getUrlVideo();
        productId2 = (entities.getProducts2() != null) ? entities.getProducts2().getProductauxiliar().getId(): null;
        quantidade2 = entities.getQuantidade2();
        vidroConvencional2 = entities.getVidroConvencional2();
        vidroInteligente2 = entities.getVidroInteligente2();
        observacao2 = entities.getObservacao2();
        urlEsquema2 = entities.getUrlEsquema2();
        urlVideo2 = entities.getUrlVideo2();
        combo = entities.getCombo();
        createdAt = entities.getCreatedAt();
        updatedAt = entities.getUpdatedAt();
        active = entities.getActive();
    }

    public Long getId() {
        return id;
    }

    public Long getModeloInstalesoftId() {
        return modeloInstalesoftId;
    }

    public Integer getAnoDe() {
        return anoDe;
    }

    public Integer getAnoAte() {
        return anoAte;
    }

    public Long getCategoryInstaleSoftId() {
        return categoryInstaleSoftId;
    }

    public Long getProductId() {
        return productId;
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
    public String getObservacao() {
        return observacao;
    }

    public String getUrlEsquema() {
        return urlEsquema;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public Long getProductId2() {
        return productId2;
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
    public String getObservacao2() {
        return observacao2;
    }

    public String getUrlEsquema2() {
        return urlEsquema2;
    }

    public String getUrlVideo2() {
        return urlVideo2;
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
}
