package com.softeletronica.intrasoft.repositories.secondary;

import com.apisoft.entities.ClienteSoft;
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
}
