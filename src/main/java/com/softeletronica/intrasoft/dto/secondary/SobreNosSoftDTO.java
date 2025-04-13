package com.softeletronica.intrasoft.dto.secondary;


import com.softeletronica.intrasoft.entities.secondary.SobreNosSoft;

public class SobreNosSoftDTO {
    private Long id;
    private String historico;
    private String politica;
    private String politicaAmbiental;

    public SobreNosSoftDTO() {

    }

    public SobreNosSoftDTO(Long id, String historico, String politica, String politicaAmbiental) {
        this.id = id;
        this.historico = historico;
        this.politica = politica;
        this.politicaAmbiental = politicaAmbiental;
    }

    public SobreNosSoftDTO(SobreNosSoft entities) {
        id = entities.getId();
        historico = entities.getHistorico();
        politica = entities.getPolitica();
        politicaAmbiental = entities.getPoliticaAmbiental();
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

    public String getPoliticaAmbiental() {
        return politicaAmbiental;
    }
}
