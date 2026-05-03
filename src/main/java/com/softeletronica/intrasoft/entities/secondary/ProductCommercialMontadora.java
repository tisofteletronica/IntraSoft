package com.softeletronica.intrasoft.entities.secondary;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_product_commercial_montadora")
public class ProductCommercialMontadora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productcommercial;
    @ManyToOne
    @JoinColumn(name="montadora_id")
    private MontadoraInstalesoft productmontadoras;


    public ProductCommercialMontadora() {

    }

    public ProductCommercialMontadora(Long id, Product productcommercial, MontadoraInstalesoft productmontadoras) {
        this.id = id;
        this.productcommercial = productcommercial;
        this.productmontadoras = productmontadoras;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProductcommercial() {
        return productcommercial;
    }

    public MontadoraInstalesoft getProductmontadoras() {
        return productmontadoras;
    }

    public void setProductcommercial(Product productcommercial) {
        this.productcommercial = productcommercial;
    }

    public void setProductmontadoras(MontadoraInstalesoft productmontadoras) {
        this.productmontadoras = productmontadoras;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCommercialMontadora that = (ProductCommercialMontadora) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
