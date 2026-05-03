package com.softeletronica.intrasoft.dto.secondary;


import com.softeletronica.intrasoft.entities.secondary.Sgi;

public class SgiDTO {
    private Long id;

    private String frase1;

    private String frase2;

    private String frase3;

    public SgiDTO(Long id, String frase1, String frase2, String frase3) {
        this.id = id;
        this.frase1 = frase1;
        this.frase2 = frase2;
        this.frase3 = frase3;
    }

    public SgiDTO(Sgi entities) {
        id = entities.getId();
        frase1 = entities.getFrase1();
        frase2 = entities.getFrase2();
        frase3 = entities.getFrase3();

    }

    public Long getId() {
        return id;
    }

    public String getFrase1() {
        return frase1;
    }

    public String getFrase2() {
        return frase2;
    }

    public String getFrase3() {
        return frase3;
    }
}
