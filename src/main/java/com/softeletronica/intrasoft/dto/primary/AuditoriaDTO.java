package com.softeletronica.intrasoft.dto.primary;

import com.softeletronica.intrasoft.entities.primary.Auditoria;

import java.time.Instant;

public class AuditoriaDTO {
    private Long id;
    private Instant created;
    private String objeto;
    private String usuario;

    public AuditoriaDTO(){

    }
    public AuditoriaDTO(Long id, Instant created, String objeto, String usuario) {
        this.id = id;
        this.created = created;
        this.objeto = objeto;
        this.usuario = usuario;
    }

    public AuditoriaDTO(Auditoria entities) {
        id = entities.getId();
        created = getCreated();
        objeto = getObjeto();
        usuario = getUsuario();
    }

    public Long getId() {
        return id;
    }

    public Instant getCreated() {
        return created;
    }

    public String getObjeto() {
        return objeto;
    }

    public String getUsuario() {
        return usuario;
    }
}
