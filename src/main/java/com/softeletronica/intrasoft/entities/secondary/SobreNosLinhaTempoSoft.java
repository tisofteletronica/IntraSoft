package com.softeletronica.intrasoft.entities.secondary;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_sobre_nos_linha_tempo_soft")
public class SobreNosLinhaTempoSoft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String anos;
    @Column(columnDefinition = "TEXT")
    private String historico;

    public SobreNosLinhaTempoSoft() {

    }

    public SobreNosLinhaTempoSoft(Long id, String anos, String historico) {
        this.id = id;
        this.anos = anos;
        this.historico = historico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnos() {
        return anos;
    }

    public void setAnos(String anos) {
        this.anos = anos;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SobreNosLinhaTempoSoft that = (SobreNosLinhaTempoSoft) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
