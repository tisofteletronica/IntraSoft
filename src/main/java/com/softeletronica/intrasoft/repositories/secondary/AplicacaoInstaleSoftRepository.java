package com.softeletronica.intrasoft.repositories.secondary;


import com.softeletronica.intrasoft.entities.secondary.AplicacaoInstaleSoft;
import com.softeletronica.intrasoft.projections.AnoModeloProjection;
import com.softeletronica.intrasoft.projections.ModeloCategoriaProjection;
import com.softeletronica.intrasoft.projections.ProdutoPorAplicacaoProjection;
import com.softeletronica.intrasoft.projections.ProdutosPorModelosProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AplicacaoInstaleSoftRepository extends JpaRepository<AplicacaoInstaleSoft, Long> {

    @Query(nativeQuery = true, value = "SELECT " +
            "anos.modelo_id AS id, " +
            "modelos.name AS name, " +
            "montadoras.name AS montadora, " +
            "anos.ano " +
            "FROM (" +
            "SELECT " +
            "modelo_id, " +
            "generate_series(ano_minimo, ano_maximo) AS ano " +
            "FROM ( " +
            "SELECT " +
            "modelo_id, " +
            "MIN(ano_de) AS ano_minimo, " +
            "MAX(ano_ate) AS ano_maximo " +
            "FROM " +
            "public.tb_aplicacao_instalesoft " +
            "WHERE " +
            "modelo_id = :id " +
            "GROUP BY " +
            "modelo_id " +
            ") AS subquery " +
            ") AS anos " +
            "JOIN public.tb_modelos_instalesoft AS modelos " +
            " ON anos.modelo_id = modelos.id " +
            "JOIN public.tb_montadoras_instalesoft AS montadoras " +
            "ON modelos.montadora_id = montadoras.id " +
            "ORDER BY " +
            "anos.modelo_id, anos.ano")
    List<AnoModeloProjection> anomodelo(Long id);

    @Query(nativeQuery = true, value = "SELECT DISTINCT ON (cat.id) " +
            "app.id AS id, " +
            "cat.id AS categoriaId," +
            "cat.name AS name, " +
            "mod.id AS modeloId, " +
            "mod.name AS modelo, " +
            ":ano AS ano, " +
            "cat.img_url AS imgUrl " +
            "FROM " +
            "public.tb_aplicacao_instalesoft app " +
            "JOIN " +
            "public.tb_modelos_instalesoft mod ON app.modelo_id = mod.id " +
            "JOIN " +
            "public.tb_category_product_instale_soft cat ON app.category_product_instale_soft_id = cat.id " +
            "WHERE " +
            "app.active = TRUE " +
            "AND mod.active = TRUE " +
            "AND cat.active = TRUE " +
            "AND app.modelo_id = :modeloId " +
            "AND app.ano_de <= :ano " +
            "AND app.ano_ate >= :ano " +
            "ORDER BY " +
            "cat.id")
    Page<ModeloCategoriaProjection> modelocategoria(Long modeloId, Integer ano, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT " +
            "active, " +
            ":ano as ano, " +
            "ano_ate, " +
            "ano_de, " +
            "combo, " +
            "portas2, " +
            "portas4, " +
            "quantidade, " +
            "quantidade2, " +
            "vidro_convencional, " +
            "vidro_convencional2, " +
            "vidro_inteligente, " +
            "vidro_inteligente2, " +
            "category_product_instale_soft_id, " +
            "created_at, " +
            "id, " +
            "modelo_id, " +
            "product_id, " +
            "product_id2, " +
            "updated_at, " +
            "observacao, " +
            "observacao2, " +
            "url_esquema, " +
            "url_esquema2, " +
            "url_video, " +
            "url_video2 " +
            "FROM " +
            "public.tb_aplicacao_instalesoft " +
            "WHERE " +
            ":ano BETWEEN ano_de AND ano_ate " +
            "AND category_product_instale_soft_id = :categoriaId " +
            "AND modelo_id = :modeloId " +
            "ORDER BY vidro_convencional ASC")
    Page<AplicacaoInstaleSoft> modeloProduto(Integer ano, Long categoriaId, Long modeloId, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT " +
            "active, " +
            ":ano as ano, " +
            "ano_ate, " +
            "ano_de, " +
            "combo, " +
            "portas2, " +
            "portas4, " +
            "quantidade, " +
            "quantidade2, " +
            "vidro_convencional, " +
            "vidro_convencional2, " +
            "vidro_inteligente, " +
            "vidro_inteligente2, " +
            "category_product_instale_soft_id, " +
            "created_at, " +
            "id, " +
            "modelo_id, " +
            "product_id, " +
            "product_id2, " +
            "updated_at, " +
            "observacao, " +
            "observacao2, " +
            "url_esquema, " +
            "url_esquema2, " +
            "url_video, " +
            "url_video2 " +
            "FROM " +
            "public.tb_aplicacao_instalesoft " +
            "WHERE " +
            ":ano BETWEEN ano_de AND ano_ate " +
            "AND category_product_instale_soft_id = :categoriaId " +
            "AND modelo_id = :modeloId " +
            "AND vidro_convencional = :vidroConvencional " +
            "ORDER BY vidro_convencional ASC")
    Page<AplicacaoInstaleSoft> modeloProdutoVc(Integer ano, Long categoriaId, Long modeloId, Integer vidroConvencional, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT " +
            "active, " +
            ":ano as ano, " +
            "ano_ate, " +
            "ano_de, " +
            "combo, " +
            "portas2, " +
            "portas4, " +
            "quantidade, " +
            "quantidade2, " +
            "vidro_convencional, " +
            "vidro_convencional2, " +
            "vidro_inteligente, " +
            "vidro_inteligente2, " +
            "category_product_instale_soft_id, " +
            "created_at, " +
            "id, " +
            "modelo_id, " +
            "product_id, " +
            "product_id2, " +
            "updated_at, " +
            "observacao, " +
            "observacao2, " +
            "url_esquema, " +
            "url_esquema2, " +
            "url_video, " +
            "url_video2 " +
            "FROM " +
            "public.tb_aplicacao_instalesoft " +
            "WHERE " +
            ":ano BETWEEN ano_de AND ano_ate " +
            "AND category_product_instale_soft_id = :categoriaId " +
            "AND modelo_id = :modeloId " +
            "AND vidro_convencional = :vidroConvencional " +
            "AND vidro_inteligente = :vidroInteligente " +
            "ORDER BY vidro_convencional ASC")
    Page<AplicacaoInstaleSoft> modeloProdutoVI(Integer ano, Long categoriaId, Long modeloId, Integer vidroConvencional,
                                               Integer vidroInteligente, Pageable pageable);


    @Query(nativeQuery = true, value = "SELECT DISTINCT ON (p.id) " +
            "p.id AS productId, " +
            "p.name AS productName, " +
            "p.code AS productCode, " +
            "p.img_url1 AS productImage, " +
            "p.url_logo_img AS productLogo, " +
            "p.description_instalesoft AS productDescriptionInstaleSoft, " +
            "p.description_commercial AS productDescriptionCommercial, " +
            "p.url_manual AS productManual, " +
            "ai.category_product_instale_soft_id AS categoryInstaleSoftId, " +
            "ci.name AS categoryInstaleSoftName, " +
            "ci.img_url AS categoryInstaleSoftImage, " +
            "p.categorycommercial_id AS categoryCommercialId, " +
            "cc.name AS categoryCommercialName, " +
            "cc.img_url AS categoryCommercialImage " +
            "FROM " +
            "public.tb_aplicacao_instalesoft ai " +
            "JOIN " +
            "public.tb_products p ON ai.product_id = p.id " +
            "JOIN " +
            "public.tb_category_product_instale_soft ci ON ai.category_product_instale_soft_id = ci.id " +
            "JOIN " +
            "public.tb_category_product_commercial cc ON p.categorycommercial_id = cc.id " +
            "WHERE " +
            "ai.category_product_instale_soft_id = :categoryInstaleSoftId " +
            "ORDER BY " +
            "p.id, p.name;")
    Page<ProdutoPorAplicacaoProjection> produtoPorAplicacao(Long categoryInstaleSoftId, Pageable pageable);

    @Query(nativeQuery = true, value = "WITH aggregated_years AS ( " +
            "SELECT " +
            "ai.modelo_id, " +
            "MIN(ai.ano_de) AS ano_min," +
            "MAX(ai.ano_ate) AS ano_max, " +
            "ai.category_product_instale_soft_id," +
            "cps.name AS category_product_instale_soft_name, " +
            "ai.product_id " +
            "FROM " +
            "public.tb_aplicacao_instalesoft ai " +
            "JOIN " +
            "public.tb_category_product_instale_soft cps ON ai.category_product_instale_soft_id = cps.id " +
            "WHERE " +
            "ai.product_id = :productId AND " +
            "ai.category_product_instale_soft_id = :categoryInstaleSoftId " +
            "GROUP BY " +
            "ai.modelo_id, " +
            "ai.category_product_instale_soft_id, " +
            "cps.name, " +
            "ai.product_id " +
            "), " +
            "filtered_years AS ( " +
            "SELECT " +
            "ag.modelo_id, " +
            "ag.ano_min, " +
            "ag.ano_max, " +
            "ag.category_product_instale_soft_id, " +
            "ag.category_product_instale_soft_name, " +
            "ag.product_id, " +
            "COUNT(*) OVER (PARTITION BY ag.modelo_id, ag.ano_max, ag.category_product_instale_soft_id) AS year_count " +
            "FROM " +
            "aggregated_years ag " +
            ") " +
            "SELECT " +
            "fy.modelo_id AS modeloId, " +
            "m.name AS modelName, " +
            "fy.ano_min AS anoDe, " +
            "fy.ano_max AS anoAte, " +
            "m.montadora_id AS montadoraId, " +
            "mo.name AS montadoraName, " +
            "fy.category_product_instale_soft_id As categoryProductInstaleSoftId, " +
            "fy.category_product_instale_soft_name AS categoryProductInstaleSoftName, " +
            "fy.product_id AS productId, " +
            "mo.url_img AS montadoraImage  " +
            "FROM " +
            "filtered_years fy " +
            "JOIN " +
            "public.tb_modelos_instalesoft m ON fy.modelo_id = m.id " +
            "JOIN " +
            "public.tb_montadoras_instalesoft mo ON m.montadora_id = mo.id " +
            "WHERE " +
            "(fy.year_count = 1) OR " +
            "(fy.year_count > 1 AND fy.ano_min < fy.ano_max) " +
            "ORDER BY " +
            "mo.name, m.name")
    Page<ProdutosPorModelosProjection> produtoPorModelo(Long productId, Long categoryInstaleSoftId, Pageable pageable);
    @Query(nativeQuery = true, value = "WITH aggregated_years AS ( " +
            "SELECT " +
            "ai.modelo_id, " +
            "MIN(ai.ano_de) AS ano_min, " +
            "MAX(ai.ano_ate) AS ano_max, " +
            "ai.category_product_instale_soft_id, " +
            "cps.name AS category_product_instale_soft_name, " +
            "ai.product_id " +
            "FROM " +
            "public.tb_aplicacao_instalesoft ai " +
            "JOIN " +
            "public.tb_category_product_instale_soft cps " +
            "ON ai.category_product_instale_soft_id = cps.id " +
            "WHERE " +
            "ai.product_id = :productId AND " +
            "ai.category_product_instale_soft_id = :categoryInstaleSoftId " +
            "GROUP BY " +
            "ai.modelo_id, " +
            "ai.category_product_instale_soft_id, " +
            "cps.name, " +
            "ai.product_id " +
            "), " +
            "filtered_years AS ( " +
            "SELECT " +
            "ag.modelo_id, " +
            "ag.ano_min, " +
            "ag.ano_max, " +
            "ag.category_product_instale_soft_id, " +
            "ag.category_product_instale_soft_name, " +
            "ag.product_id, " +
            "COUNT(*) OVER (PARTITION BY ag.modelo_id, ag.ano_max, ag.category_product_instale_soft_id) AS year_count " +
            "FROM " +
            "aggregated_years ag " +
            ") " +
            "SELECT " +
            "fy.modelo_id AS modeloId, " +
            "m.name AS modelName, " +
            "fy.ano_min AS anoDe, " +
            "fy.ano_max AS anoAte, " +
            "m.montadora_id AS montadoraId, " +
            "mo.name AS montadoraName, " +
            "fy.category_product_instale_soft_id AS categoryProductInstaleSoftId, " +
            "fy.category_product_instale_soft_name AS categoryProductInstaleSoftName, " +
            "fy.product_id AS productId, " +
            "mo.url_img AS montadoraImage " +
            "FROM " +
            "filtered_years fy " +
            "JOIN " +
            "public.tb_modelos_instalesoft m " +
            "ON fy.modelo_id = m.id " +
            "JOIN " +
            "public.tb_montadoras_instalesoft mo " +
            "ON m.montadora_id = mo.id " +
            "WHERE " +
            "( " +
            "(fy.year_count = 1) OR " +
            "(fy.year_count > 1 AND fy.ano_min < fy.ano_max) " +
            ") " +
            "AND UPPER(mo.name) LIKE UPPER(:montadoraName || '%') " +
            "ORDER BY " +
            "mo.name, " +
            "m.name"
    )
    Page<ProdutosPorModelosProjection> produtoPorModeloFiltroMontadora(Long productId, Long categoryInstaleSoftId,
                                                                             String montadoraName, Pageable pageable);

    @Query(nativeQuery = true, value = "WITH aggregated_years AS ( " +
            "SELECT " +
            "ai.modelo_id, " +
            "MIN(ai.ano_de) AS ano_min, " +
            "MAX(ai.ano_ate) AS ano_max, " +
            "ai.category_product_instale_soft_id, " +
            "cps.name AS category_product_instale_soft_name, " +
            "ai.product_id " +
            "FROM " +
            "public.tb_aplicacao_instalesoft ai " +
            "JOIN " +
            "public.tb_category_product_instale_soft cps " +
            "ON ai.category_product_instale_soft_id = cps.id " +
            "WHERE " +
            "ai.product_id = :productId AND " +
            "ai.category_product_instale_soft_id = :categoryInstaleSoftId " +
            "GROUP BY " +
            "ai.modelo_id, " +
            "ai.category_product_instale_soft_id, " +
            "cps.name, " +
            "ai.product_id " +
            "), " +
            "filtered_years AS ( " +
            "SELECT " +
            "ag.modelo_id, " +
            "ag.ano_min, " +
            "ag.ano_max, " +
            "ag.category_product_instale_soft_id, " +
            "ag.category_product_instale_soft_name, " +
            "ag.product_id, " +
            "COUNT(*) OVER (PARTITION BY ag.modelo_id, ag.ano_max, ag.category_product_instale_soft_id) AS year_count " +
            "FROM " +
            "aggregated_years ag " +
            ") " +
            "SELECT " +
            "fy.modelo_id AS modeloId, " +
            "m.name AS modelName, " +
            "fy.ano_min AS anoDe, " +
            "fy.ano_max AS anoAte, " +
            "m.montadora_id AS montadoraId, " +
            "mo.name AS montadoraName, " +
            "fy.category_product_instale_soft_id AS categoryProductInstaleSoftId, " +
            "fy.category_product_instale_soft_name AS categoryProductInstaleSoftName, " +
            "fy.product_id AS productId, " +
            "mo.url_img AS montadoraImage " +
            "FROM " +
            "filtered_years fy " +
            "JOIN " +
            "public.tb_modelos_instalesoft m " +
            "ON fy.modelo_id = m.id " +
            "JOIN " +
            "public.tb_montadoras_instalesoft mo " +
            "ON m.montadora_id = mo.id " +
            "WHERE " +
            "( " +
            "(fy.year_count = 1) OR " +
            "(fy.year_count > 1 AND fy.ano_min < fy.ano_max) " +
            ") " +
            "AND UPPER(m.name) LIKE UPPER(:modeloName || '%') " +
            "ORDER BY " +
            "mo.name, " +
            "m.name"
    )
    Page<ProdutosPorModelosProjection> produtoPorModeloFiltroModeloName(Long productId, Long categoryInstaleSoftId,
                                                                       String modeloName, Pageable pageable);
}


