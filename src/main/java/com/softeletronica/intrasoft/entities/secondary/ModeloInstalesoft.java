package com.softeletronica.intrasoft.entities.secondary;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_modelos_instalesoft")
public class ModeloInstalesoft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "updated_at")
    private Instant updatedAt;
    private Boolean active;
    @ManyToOne
    @JoinColumn(name = "montadora_id")
    private MontadoraInstalesoft montadoras;

    @OneToMany(mappedBy = "modeloInstalesoft")
    private List<AplicacaoInstaleSoft> instaleSoft = new ArrayList<>();

    public ModeloInstalesoft() {
    }
    public ModeloInstalesoft(Long id, String name, Instant createdAt, Instant updatedAt, Boolean active,
                             MontadoraInstalesoft montadoras) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
        this.montadoras = montadoras;
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

    public MontadoraInstalesoft getMontadoras() {
        return montadoras;
    }

    public void setMontadoras(MontadoraInstalesoft montadoras) {
        this.montadoras = montadoras;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModeloInstalesoft that = (ModeloInstalesoft) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
