package com.softeletronica.intrasoft.repositories;

import com.softeletronica.intrasoft.entities.UnidadesSoft;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UnidadesSoftRepository extends JpaRepository<UnidadesSoft, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM "
    + "tb_unidadessoft "
    + "order by id desc")
    Page<UnidadesSoft>findAllOrderId(Pageable pageable);


}
