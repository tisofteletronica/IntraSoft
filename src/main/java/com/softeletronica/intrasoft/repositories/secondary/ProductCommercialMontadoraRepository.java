package com.softeletronica.intrasoft.repositories.secondary;


import com.softeletronica.intrasoft.entities.secondary.Product;
import com.softeletronica.intrasoft.entities.secondary.ProductCommercialMontadora;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductCommercialMontadoraRepository extends JpaRepository<ProductCommercialMontadora, Long> {
@Query(nativeQuery = true, value = "SELECT " +
        "id, montadora_id, product_id " +
        "FROM public.tb_product_commercial_montadora " +
        "WHERE product_id = :productId")
Page<ProductCommercialMontadora> filterProduct(Long productId, Pageable pageable);
}
