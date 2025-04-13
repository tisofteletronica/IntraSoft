package com.softeletronica.intrasoft.repositories.secondary;

import com.softeletronica.intrasoft.entities.secondary.MontadoraInstalesoft;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MontadoraInstalesoftRepository extends JpaRepository<MontadoraInstalesoft, Long> {

    @Query(nativeQuery = true, value = "SELECT active, created_at, id, update_at, name, url_img" +
            " FROM tb_montadoras_instalesoft " +
            "ORDER BY name")
    List<MontadoraInstalesoft> byName();

    @Query(nativeQuery = true, value = "SELECT active, created_at, id, update_at, name, url_img" +
            " FROM tb_montadoras_instalesoft " +
            "ORDER BY name")
    Page<MontadoraInstalesoft> byNamePage(Pageable pageable);
}
