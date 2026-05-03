package com.softeletronica.intrasoft.entities.secondary;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_product_auxiliar")
public class ProductAuxiliar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productauxiliar;

    @OneToMany(mappedBy = "products2")
    private List<AplicacaoInstaleSoft> instaleSoft2 = new ArrayList<>();

    public ProductAuxiliar() {

    }

    public ProductAuxiliar(Long id, Product productauxiliar, List<AplicacaoInstaleSoft> instaleSoft2) {
        this.id = id;
        this.productauxiliar = productauxiliar;
        this.instaleSoft2 = instaleSoft2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProductauxiliar() {
        return productauxiliar;
    }

    public void setProductauxiliar(Product productauxiliar) {
        this.productauxiliar = productauxiliar;
    }

    public List<AplicacaoInstaleSoft> getInstaleSoft2() {
        return instaleSoft2;
    }

    public void setInstaleSoft2(List<AplicacaoInstaleSoft> instaleSoft2) {
        this.instaleSoft2 = instaleSoft2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductAuxiliar that = (ProductAuxiliar) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
