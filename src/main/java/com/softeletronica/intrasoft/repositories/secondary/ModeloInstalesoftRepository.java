package com.softeletronica.intrasoft.repositories.secondary;


import com.softeletronica.intrasoft.entities.secondary.ModeloInstalesoft;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModeloInstalesoftRepository extends JpaRepository<ModeloInstalesoft, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM public.tb_modelos_instalesoft ORDER BY name")
    Page<ModeloInstalesoft> findAllName(Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * FROM public.tb_modelos_instalesoft " +
            "WHERE montadora_id = :montadoraId " +
            "ORDER BY name")
    Page<ModeloInstalesoft> findByIdMontadora(Long montadoraId, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * FROM public.tb_modelos_instalesoft " +
            "WHERE name LIKE UPPER (:name || '%') " +
            "ORDER BY name")
    Page<ModeloInstalesoft> filterByName(String name, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT " +
            "mo.id AS id, " +
            "mo.name AS name, " +
            "mo.montadora_id AS montadora_id, " +
            "mi.name AS montadora_nome, " +
            "mo.created_at, " +
            "mo.updated_at, " +
            "mo.active AS active " +
            "FROM " +
            "public.tb_modelos_instalesoft AS mo " +
            "INNER JOIN " +
            "public.tb_montadoras_instalesoft AS mi ON mo.montadora_id = mi.id " +
            "WHERE " +
            "mi.name LIKE UPPER(:montadora || '%') " +
            "ORDER BY mo.name")
    Page<ModeloInstalesoft> findByNameMontadora(String montadora, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * FROM public.tb_modelos_instalesoft " +
            "WHERE montadora_id = :montadoraId " +
            "ORDER BY name")
    List<ModeloInstalesoft> ListByIdMontadora(Long montadoraId);

}
