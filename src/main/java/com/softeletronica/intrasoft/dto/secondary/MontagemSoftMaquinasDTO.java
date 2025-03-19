package com.softeletronica.intrasoft.dto.secondary;

import com.softeletronica.intrasoft.entities.secondary.MontagemSoftMaquinas;

import java.util.Objects;


public class MontagemSoftMaquinasDTO {
    private Long id;
    private String tipo;
    private String maquina;
    private String descricao;


    public MontagemSoftMaquinasDTO() {

    }

    public MontagemSoftMaquinasDTO(Long id, String tipo, String maquina, String descricao) {
        this.id = id;
        this.tipo = tipo;
        this.maquina = maquina;
        this.descricao = descricao;
    }

    public MontagemSoftMaquinasDTO(MontagemSoftMaquinas entities) {
        id = entities.getId();
        tipo = entities.getTipo();
        maquina = entities.getMaquina();
        descricao = entities.getDescricao();

    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMaquina() {
        return maquina;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MontagemSoftMaquinasDTO that = (MontagemSoftMaquinasDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
