package com.softeletronica.intrasoft.entities.secondary;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_sgi")
public class Sgi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String frase1;
    @Column(columnDefinition = "TEXT")
    private String frase2;
    @Column(columnDefinition = "TEXT")
    private String frase3;



    public Sgi() {

    }

    public Sgi(Long id, String frase1, String frase2, String frase3) {
        this.id = id;
        this.frase1 = frase1;
        this.frase2 = frase2;
        this.frase3 = frase3;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrase1() {
        return frase1;
    }

    public void setFrase1(String frase1) {
        this.frase1 = frase1;
    }

    public String getFrase2() {
        return frase2;
    }

    public void setFrase2(String frase2) {
        this.frase2 = frase2;
    }

    public String getFrase3() {
        return frase3;
    }

    public void setFrase3(String frase3) {
        this.frase3 = frase3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sgi that = (Sgi) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
