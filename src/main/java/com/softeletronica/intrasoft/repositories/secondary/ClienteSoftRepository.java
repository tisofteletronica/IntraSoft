package com.softeletronica.intrasoft.repositories.secondary;


import com.softeletronica.intrasoft.entities.secondary.ClienteSoft;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteSoftRepository extends JpaRepository<ClienteSoft, Long> {

    @Query(nativeQuery = true, value = "SELECT " +
            "id, " +
            "razao_social, " +
            "cnpjcpf, " +
            "cidade, " +
            "uf, " +
            "cep, " +
            "endereco, " +
            "numero, " +
            "complemento, " +
            "bairro, " +
            "latitude, " +
            "longitude, " +
            "telefone1, " +
            "telefone2, " +
            "email, " +
            "site, " +
            "tipo, " +
            "active, " +
            "create_at, " +
            "update_at " +
            "FROM " +
            "public.tb_cliente_soft " +
            "WHERE  " +
            "(uf IS NULL OR uf LIKE UPPER (:uf || '%')) " +
            "AND " +
            "(cidade IS NULL OR cidade LIKE UPPER (:cidade || '%'))")
    List<ClienteSoft> filterUForCity(String uf, String cidade);

    @Query(nativeQuery = true, value = "SELECT " +
            "id, " +
            "razao_social, " +
            "cnpjcpf, " +
            "cidade, " +
            "uf, " +
            "cep, " +
            "endereco, " +
            "numero, " +
            "complemento, " +
            "bairro, " +
            "latitude, " +
            "longitude, " +
            "telefone1, " +
            "telefone2, " +
            "email, " +
            "site, " +
            "tipo, " +
            "active, " +
            "create_at, " +
            "update_at " +
            "FROM " +
            "public.tb_cliente_soft " +
            "WHERE  " +
            "(uf IS NULL OR uf LIKE UPPER (:uf || '%')) " +
            "AND " +
            "(cidade IS NULL OR cidade LIKE UPPER (:cidade || '%')) " +
             "ORDER BY razao_social")
    Page<ClienteSoft> filterUForCityPageable(String uf, String cidade, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT " +
            "id, " +
            "razao_social, " +
            "cnpjcpf, " +
            "cidade, " +
            "uf, " +
            "cep, " +
            "endereco, " +
            "numero, " +
            "complemento, " +
            "bairro, " +
            "latitude, " +
            "longitude, " +
            "telefone1, " +
            "telefone2, " +
            "email, " +
            "site, " +
            "tipo, " +
            "active, " +
            "create_at, " +
            "update_at " +
            "FROM " +
            "public.tb_cliente_soft " +
            "WHERE  " +
            "(razao_social IS NULL OR razao_social LIKE UPPER (:razaoSocial || '%')) " +
            "ORDER BY razao_social")
    Page<ClienteSoft> filterNamePageable(String razaoSocial, Pageable pageable);
}
