package com.softeletronica.intrasoft.repositories.secondary;


import com.softeletronica.intrasoft.entities.secondary.ProductAuxiliar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductAuxiliarRepository extends JpaRepository<ProductAuxiliar, Long> {



    @Query(nativeQuery = true, value = "SELECT a.id, a.product_id " +
            "FROM public.tb_product_auxiliar a " +
            "JOIN public.tb_products p ON a.product_id = p.id " +
            "WHERE p.code = :code")
    Page<ProductAuxiliar>sortCode(String code, Pageable pageable);
}
