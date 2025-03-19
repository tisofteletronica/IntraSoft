package com.softeletronica.intrasoft.repositories.secondary;


import com.softeletronica.intrasoft.entities.secondary.Product;
import com.softeletronica.intrasoft.entities.secondary.ProductExtraSite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductExtraSiteRepository extends JpaRepository<ProductExtraSite, Long> {
    @Query("SELECT obj FROM ProductExtraSite obj WHERE "
            + "(UPPER(obj.name) LIKE UPPER(CONCAT(:name, '%')))")
    Page<ProductExtraSite> filterByName(String name, Pageable pageable);

}
