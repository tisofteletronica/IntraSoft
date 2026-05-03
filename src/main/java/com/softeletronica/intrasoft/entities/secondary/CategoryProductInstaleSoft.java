package com.softeletronica.intrasoft.entities.secondary;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_category_product_instale_soft")
public class CategoryProductInstaleSoft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5, message = "Deve ter minímo 5 caracteres")
    @NotBlank(message = "Campo Requerido")
    private String name;
    @Column(name = "img_url")
    private String imgUrl;
    private Boolean active;
    @OneToMany(mappedBy = "categoryProductInstaleSoft")
    private List<AplicacaoInstaleSoft> instaleSoft = new ArrayList<>();
    @PastOrPresent(message = "A data e hora do cadastro não corresponde a data e hora de agora")
    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "update_at")
    @PastOrPresent(message = "A data e hora do cadastro não corresponde a data e hora de agora")
    private Instant updateAt;
    public CategoryProductInstaleSoft() {
    }
    public CategoryProductInstaleSoft(Long id, String name, String imgUrl, Boolean active, Instant createdAt, Instant updateAt) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
        this.active = active;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryProductInstaleSoft that = (CategoryProductInstaleSoft) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
