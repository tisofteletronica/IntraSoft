package com.softeletronica.intrasoft.entities.secondary;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_montadoras_instalesoft")
public class MontadoraInstalesoft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "url_img")
    private String urlImg;
    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "update_at")
    private Instant updateAt;
    private Boolean active;
    @OneToMany(mappedBy = "montadoras")
    private List<ModeloInstalesoft> modelos = new ArrayList<>();
    @OneToMany(mappedBy = "productmontadoras")
    private List<ProductCommercialMontadora> productCommercialMontadora = new ArrayList<>();

    public MontadoraInstalesoft(){

    }

    public MontadoraInstalesoft(Long id, String name, String urlImg, Instant createdAt, Instant updateAt, Boolean active) {
        this.id = id;
        this.name = name;
        this.urlImg = urlImg;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Instant updateAt) {
        this.updateAt = updateAt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<ModeloInstalesoft> getModelos() {
        return modelos;
    }

    public List<ProductCommercialMontadora> getProductCommercialMontadora() {
        return productCommercialMontadora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MontadoraInstalesoft that = (MontadoraInstalesoft) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
