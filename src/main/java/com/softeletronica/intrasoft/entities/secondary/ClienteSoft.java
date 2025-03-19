package com.softeletronica.intrasoft.entities.secondary;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_cliente_soft")
public class ClienteSoft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private Integer cnpjCPF;
    @Column(columnDefinition = "TEXT")
    private String razaoSocial;
    private String email;
    private String telefone1;
    private String telefone2;
    private String cep;
    @Column(columnDefinition = "TEXT")
    private String endereco;
    private String numero;
    @Column(columnDefinition = "TEXT")
    private String complemento;
    @Column(columnDefinition = "TEXT")
    private String bairro;
    @Column(columnDefinition = "TEXT")
    private String cidade;
    private String uf;
    private String latitude;
    private String longitude;
    private String site;
    private Instant createAt;
    private Instant updateAt;
    private String active;

    public ClienteSoft(){

    }

    public ClienteSoft(Long id, String tipo, Integer cnpjCPF, String razaoSocial, String email, String telefone1,
                       String telefone2, String cep, String endereco, String numero, String complemento, String bairro,
                       String cidade, String uf, String latitude, String longitude, String site, Instant createAt,
                       Instant updateAt, String active) {
        this.id = id;
        this.tipo = tipo;
        this.cnpjCPF = cnpjCPF;
        this.razaoSocial = razaoSocial;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.latitude = latitude;
        this.longitude = longitude;
        this.site = site;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCnpjCPF() {
        return cnpjCPF;
    }

    public void setCnpjCPF(Integer cnpjCPF) {
        this.cnpjCPF = cnpjCPF;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Instant getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Instant createAt) {
        this.createAt = createAt;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Instant updateAt) {
        this.updateAt = updateAt;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
