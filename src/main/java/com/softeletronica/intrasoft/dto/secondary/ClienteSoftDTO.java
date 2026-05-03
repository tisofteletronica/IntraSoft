package com.softeletronica.intrasoft.dto.secondary;

import com.softeletronica.intrasoft.entities.secondary.ClienteSoft;

import java.time.Instant;

public class ClienteSoftDTO {
    private Long id;
    private String tipo;
    private Integer cnpjCPF;
    private String razaoSocial;
    private String email;
    private String telefone1;
    private String telefone2;
    private String cep;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String latitude;
    private String longitude;
    private String site;
    private Instant createAt;
    private Instant updateAt;
    private String active;

    public ClienteSoftDTO(){

    }

    public ClienteSoftDTO(Long id, String tipo, Integer cnpjCPF, String razaoSocial, String email, String telefone1,
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

    public ClienteSoftDTO(ClienteSoft entity) {
      id = entity.getId();
      tipo = entity.getTipo();
      cnpjCPF = entity.getCnpjCPF();
      razaoSocial = entity.getRazaoSocial();
      email = entity.getEmail();
      telefone1 = entity.getTelefone1();
      telefone2 = entity.getTelefone2();
      cep = entity.getCep();
      endereco = entity.getEndereco();
      numero = entity.getNumero();
      complemento = entity.getComplemento();
      bairro = entity.getBairro();
      cidade = entity.getCidade();
      uf = entity.getUf();
      latitude = entity.getLatitude();
      longitude = entity.getLongitude();
      site = entity.getSite();
      createAt = entity.getCreateAt();
      updateAt = entity.getUpdateAt();
      active = entity.getActive();
    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getCnpjCPF() {
        return cnpjCPF;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public String getCep() {
        return cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getSite() {
        return site;
    }

    public Instant getCreateAt() {
        return createAt;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public String getActive() {
        return active;
    }
}
