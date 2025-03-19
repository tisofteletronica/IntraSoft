package com.softeletronica.intrasoft.dto.secondary;


import com.softeletronica.intrasoft.entities.secondary.SobreNosLinhaTempoSoft;

public class SobreNosLinhaTempoSoftDTO {
    private Long id;
    private String anos;
    private String historico;


    public SobreNosLinhaTempoSoftDTO() {

    }

    public SobreNosLinhaTempoSoftDTO(Long id, String anos, String historico) {
        this.id = id;
        this.anos = anos;
        this.historico = historico;
    }

    public SobreNosLinhaTempoSoftDTO(SobreNosLinhaTempoSoft entities) {
        id = entities.getId();
        anos = entities.getAnos();
        historico = entities.getHistorico();

    }

    public Long getId() {
        return id;
    }

    public String getAnos() {
        return anos;
    }

    public String getHistorico() {
        return historico;
    }


}
