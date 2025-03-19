package com.softeletronica.intrasoft.dto.secondary;


import com.softeletronica.intrasoft.entities.secondary.SobreNosSoft;

public class SobreNosSoftDTO {
    private Long id;
    private String historico;
    private String politica;

    public SobreNosSoftDTO() {

    }

    public SobreNosSoftDTO(Long id, String historico, String politica) {
        this.id = id;
        this.historico = historico;
        this.politica = politica;
    }

    public SobreNosSoftDTO(SobreNosSoft entities) {
        id = entities.getId();
        historico = entities.getHistorico();
        politica = entities.getPolitica();
    }

    public Long getId() {
        return id;
    }

    public String getHistorico() {
        return historico;
    }

    public String getPolitica() {
        return politica;
    }
}
