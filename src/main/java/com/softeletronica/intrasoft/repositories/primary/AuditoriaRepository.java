package com.softeletronica.intrasoft.repositories.primary;

import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.secondary.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {

@Query(nativeQuery = true, value = "SELECT id, created, objeto, usuario " +
        "FROM public.tb_auditoria " +
        "WHERE CAST(created AS DATE) " +
        "BETWEEN :inicio AND :fim " +
        "ORDER BY created DESC")
Page<Auditoria>findByDate(LocalDate inicio, LocalDate fim, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT id, created, objeto, usuario " +
            "FROM public.tb_auditoria " +
            "WHERE SUBSTRING(objeto FROM 3) ILIKE CONCAT('%', :objeto, '%')")
    Page<Auditoria> filterByObjeto(String objeto, Pageable pageable);
}
