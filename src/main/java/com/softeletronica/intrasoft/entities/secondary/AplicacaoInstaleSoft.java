package com.softeletronica.intrasoft.entities.secondary;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_aplicacao_instalesoft")
public class AplicacaoInstaleSoft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private ModeloInstalesoft modeloInstalesoft;
    @Column(name = "ano_de")
    private Integer anoDe;
    @Column(name = "ano_ate")
    private Integer anoAte;
    @ManyToOne
    @JoinColumn(name = "category_product_instale_soft_id")
    private CategoryProductInstaleSoft categoryProductInstaleSoft;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product products;

    private Integer quantidade;
    @Column(name = "vidro_convencional")
    private Integer vidroConvencional;
    @Column(name = "vidro_inteligente")
    private Integer vidroInteligente;
    private Boolean portas2;
    private Boolean portas4;
    @Column(columnDefinition = "TEXT")
    private String observacao;
    @Column(name = "url_esquema")
    private String urlEsquema;
    @Column(name = "url_video")
    private String urlVideo;
    @ManyToOne
    @JoinColumn(name = "product_id2")
    private ProductAuxiliar products2;
    private Integer quantidade2;
    @Column(name = "vidro_convencional2")
    private Integer vidroConvencional2;
    @Column(name = "vidro_inteligente2")
    private Integer vidroInteligente2;
    @Column(columnDefinition = "TEXT")
    private String observacao2;
    @Column(name="url_esquema2")
    private String urlEsquema2;
    @Column(name = "url_video2")
    private String urlVideo2;
    private Boolean combo;
    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "updated_at")
    private Instant updatedAt;
    private Boolean active;

    public AplicacaoInstaleSoft() {

    }

    public AplicacaoInstaleSoft(Long id, ModeloInstalesoft modeloInstalesoft, Integer anoDe, Integer anoAte,
                                CategoryProductInstaleSoft categoryProductInstaleSoft, Product products,
                                Integer quantidade, Integer vidroConvencional, Integer vidroInteligente, Boolean portas2,
                                Boolean portas4, String observacao, String urlEsquema, String urlVideo,
                                ProductAuxiliar products2, Integer quantidade2, Integer vidroConvencional2,
                                Integer vidroInteligente2, String observacao2, String urlEsquema2,
                                String urlVideo2, Boolean combo, Instant createdAt,
                                Instant updatedAt, Boolean active) {
        this.id = id;
        this.modeloInstalesoft = modeloInstalesoft;
        this.anoDe = anoDe;
        this.anoAte = anoAte;
        this.categoryProductInstaleSoft = categoryProductInstaleSoft;
        this.products = products;
        this.quantidade = quantidade;
        this.vidroConvencional = vidroConvencional;
        this.vidroInteligente = vidroInteligente;
        this.portas2 = portas2;
        this.portas4 = portas4;
        this.observacao = observacao;
        this.urlEsquema = urlEsquema;
        this.urlVideo = urlVideo;
        this.products2 = products2;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ModeloInstalesoft getModeloInstalesoft() {
        return modeloInstalesoft;
    }

    public void setModeloInstalesoft(ModeloInstalesoft modeloInstalesoft) {
        this.modeloInstalesoft = modeloInstalesoft;
    }

    public Integer getAnoDe() {
        return anoDe;
    }

    public void setAnoDe(Integer anoDe) {
        this.anoDe = anoDe;
    }

    public Integer getAnoAte() {
        return anoAte;
    }

    public void setAnoAte(Integer anoAte) {
        this.anoAte = anoAte;
    }

    public CategoryProductInstaleSoft getCategoryProductInstaleSoft() {
        return categoryProductInstaleSoft;
    }

    public void setCategoryProductInstaleSoft(CategoryProductInstaleSoft categoryProductInstaleSoft) {
        this.categoryProductInstaleSoft = categoryProductInstaleSoft;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getVidroConvencional() {
        return vidroConvencional;
    }

    public void setVidroConvencional(Integer vidroConvencional) {
        this.vidroConvencional = vidroConvencional;
    }

    public Integer getVidroInteligente() {
        return vidroInteligente;
    }

    public void setVidroInteligente(Integer vidroInteligente) {
        this.vidroInteligente = vidroInteligente;
    }

    public Boolean getPortas2() {
        return portas2;
    }

    public void setPortas2(Boolean portas2) {
        this.portas2 = portas2;
    }

    public Boolean getPortas4() {
        return portas4;
    }

    public void setPortas4(Boolean portas4) {
        this.portas4 = portas4;
    }
    public String getUrlEsquema() {
        return urlEsquema;
    }

    public void setUrlEsquema(String urlEsquema) {
        this.urlEsquema = urlEsquema;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public ProductAuxiliar getProducts2() {
        return products2;
    }

    public void setProducts2(ProductAuxiliar products2) {
        this.products2 = products2;
    }

    public Integer getQuantidade2() {
        return quantidade2;
    }

    public void setQuantidade2(Integer quantidade2) {
        this.quantidade2 = quantidade2;
    }

    public Integer getVidroConvencional2() {
        return vidroConvencional2;
    }

    public void setVidroConvencional2(Integer vidroConvencional2) {
        this.vidroConvencional2 = vidroConvencional2;
    }

    public Integer getVidroInteligente2() {
        return vidroInteligente2;
    }

    public void setVidroInteligente2(Integer vidroInteligente2) {
        this.vidroInteligente2 = vidroInteligente2;
    }

    public String getUrlEsquema2() {
        return urlEsquema2;
    }

    public void setUrlEsquema2(String urlEsquema2) {
        this.urlEsquema2 = urlEsquema2;
    }

    public String getUrlVideo2() {
        return urlVideo2;
    }

    public void setUrlVideo2(String urlVideo2) {
        this.urlVideo2 = urlVideo2;
    }


    public Boolean getCombo() {
        return combo;
    }

    public void setCombo(Boolean combo) {
        this.combo = combo;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getObservacao2() {
        return observacao2;
    }

    public void setObservacao2(String observacao2) {
        this.observacao2 = observacao2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AplicacaoInstaleSoft that = (AplicacaoInstaleSoft) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
