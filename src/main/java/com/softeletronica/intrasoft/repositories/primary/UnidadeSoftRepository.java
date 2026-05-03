package com.softeletronica.intrasoft.repositories.primary;

import com.softeletronica.intrasoft.entities.primary.UnidadesSoft;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UnidadeSoftRepository extends JpaRepository<UnidadesSoft, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM "
    + "tb_unidadessoft "
    + "order by id desc")
    Page<UnidadesSoft>findAllOrderId(Pageable pageable);


}
