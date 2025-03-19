package com.softeletronica.intrasoft.entities.secondary;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_sobre_nos_soft")
public class SobreNosSoft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String historico;
    private String politica;


    public SobreNosSoft() {

    }

    public SobreNosSoft(Long id, String historico, String politica) {
        this.id = id;
        this.historico = historico;
        this.politica = politica;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getPolitica() {
        return politica;
    }

    public void setPolitica(String politica) {
        this.politica = politica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SobreNosSoft that = (SobreNosSoft) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
