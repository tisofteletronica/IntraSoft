package com.softeletronica.intrasoft.repositories.secondary;


import com.softeletronica.intrasoft.entities.secondary.Product;
import com.softeletronica.intrasoft.projections.ProdutoMontadoraProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true, value = "SELECT "
            + "active, categorycommercial_id, id, code, created_at, weight, length, width, height, description_commercial_resume," +
            " description_commercial,description_characteristics_commercial, application_commercial, epilogue_commercial, description_instalesoft, "
            + "capa_imagem, img_url1, img_url2, img_url3, img_url4, img_url5, zip,  name, updated_at, url_logo_img, url_manual "
            + "FROM public.tb_products "
            + "WHERE categorycommercial_id = :categoryCommercialId "
            + "ORDER BY name ASC")
    Page<Product> filterCategoryById(Long categoryCommercialId, Pageable pageable);
    @Query("SELECT obj FROM Product obj WHERE "
            + "(UPPER(obj.name) LIKE UPPER(CONCAT(:name, '%')))")
    Page<Product> filterByName(String name, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT "
            + "active, categorycommercial_id, id, code, created_at, weight, length, width, height, description_commercial_resume,"
            + " description_commercial,description_characteristics_commercial, application_commercial, epilogue_commercial, description_instalesoft, "
            + "capa_imagem, img_url1, img_url2, img_url3, img_url4, img_url5, zip, name, updated_at, url_logo_img, url_manual "
            + "FROM public.tb_products "
            + "WHERE (:code IS NULL OR code ILIKE %:code%) "
            + "ORDER BY code ASC")
    Page<Product> SorteCode(@Param("code") String code, Pageable pageable);

    @Query("SELECT obj FROM Product obj WHERE "
            + "(UPPER(obj.code) LIKE UPPER(CONCAT(:code, '%')))")
    Page<Product> filterCode(String code, Pageable pageable);


    @Query("SELECT obj FROM Product obj WHERE "
            + "(UPPER(obj.code) LIKE UPPER(CONCAT(:code, '%')))")
    Page<Product> filterByCode(String code, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * " +
            "FROM public.tb_products " +
            "WHERE name ILIKE '%' || :product || '%' " +
            "AND categorycommercial_id = :category ORDER BY name")
    Page<Product> filterByCategoryTravaAtuador(@Param("product") String name,
                                               @Param("category") Long categoryCommercial,
                                               Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT DISTINCT m.id, m.name AS montadora " +
            "FROM public.tb_aplicacao_instalesoft a " +
            "JOIN public.tb_modelos_instalesoft mo ON mo.id = a.modelo_id " +
            "JOIN public.tb_montadoras_instalesoft m ON m.id = mo.montadora_id " +
            "WHERE a.category_product_instale_soft_id = 5 " +
            "ORDER BY montadora")
    List<ProdutoMontadoraProjection> filterProdutoTravaMontadoraList();

    @Query(nativeQuery = true, value = "SELECT DISTINCT " +
            "    m.id, " +
            "    m.name AS montadora " +
            "FROM " +
            "    public.tb_product_commercial_montadora pcm " +
            "JOIN " +
            "    public.tb_products p ON pcm.product_id = p.id " +
            "JOIN " +
            "    public.tb_montadoras_instalesoft m ON pcm.montadora_id = m.id " +
            "WHERE " +
            "    p.name ILIKE '%ATUADOR%' " +
            "    AND p.categorycommercial_id = 6 " +
            "ORDER BY " +
            "    m.name")
    List<ProdutoMontadoraProjection> filterProdutoAtuadorMontadoraList();
    @Query(nativeQuery = true, value = "SELECT DISTINCT " +
            "    m.id, " +
            "    m.name AS montadora " +
            "FROM " +
            "    public.tb_products p " +
            "JOIN " +
            "    public.tb_product_commercial_montadora pcm ON p.id = pcm.product_id " +
            "JOIN " +
            "    public.tb_montadoras_instalesoft m ON pcm.montadora_id = m.id " +
            "WHERE " +
            "    p.categorycommercial_id = 3 " +
            "ORDER BY " +
            "    m.name")
    List<ProdutoMontadoraProjection> filterProdutoUniqueMontadoraList();

    @Query(nativeQuery = true, value ="SELECT DISTINCT ON (p.id) " +
            "p.active, p.categorycommercial_id, p.id, p.code, p.created_at, " +
            "p.description_commercial_resume, p.description_commercial, p.description_characteristics_commercial, " +
            "p.application_commercial, p.epilogue_commercial, p.description_instalesoft, p.capa_imagem, p.img_url1, p.img_url2, " +
            "p.img_url3, p.img_url4, p.img_url5, p.zip, p.name, p.updated_at, p.url_logo_img, " +
            "p.url_manual, p.weight, p.length, p.width, p.height " +
            "FROM public.tb_products p " +
            "JOIN public.tb_aplicacao_instalesoft a ON p.id = a.product_id " +
            "JOIN public.tb_modelos_instalesoft mo ON mo.id = a.modelo_id " +
            "JOIN public.tb_montadoras_instalesoft m ON m.id = mo.montadora_id " +
            "WHERE p.categorycommercial_id = 6 " +
            "AND a.category_product_instale_soft_id = 5 " +
            "AND m.name ILIKE '%' || :montadora || '%' " +
            "AND ( " +
                    "p.name ILIKE '%trava%'  " +
                    "OR m.name ILIKE '%trava%') "  +
            "ORDER BY p.id, m.name, p.name")
   List<Product> filterTravaMontadora(@Param("montadora") String montadora);

    @Query(nativeQuery = true, value ="SELECT " +
            "    p.active, " +
            "    p.categorycommercial_id, " +
            "    p.id, " +
            "    p.code, " +
            "    p.created_at, " +
            "    p.description_commercial_resume, " +
            "    p.description_commercial, " +
            "    p.description_characteristics_commercial, " +
            "    p.application_commercial, " +
            "    p.epilogue_commercial," +
            "    p.description_instalesoft, " +
            "    p.capa_imagem, " +
            "    p.img_url1, " +
            "    p.img_url2, " +
            "    p.img_url3, " +
            "    p.img_url4, " +
            "    p.img_url5, " +
            "    p.zip, " +
            "    p.name, " +
            "    p.updated_at, " +
            "    p.url_logo_img, " +
            "    p.url_manual, " +
            "    p.weight, " +
            "    p.length, " +
            "    p.width, " +
            "    p.height " +
            "FROM " +
            "    public.tb_products p " +
            "JOIN " +
            "    public.tb_product_commercial_montadora pcm ON p.id = pcm.product_id " +
            "JOIN " +
            "    public.tb_montadoras_instalesoft m ON pcm.montadora_id = m.id " +
            "WHERE " +
            "    p.categorycommercial_id = 6 " +
            "    AND m.name ILIKE '%' || :montadora || '%' " +
            "    AND p.name ILIKE '%ATUADOR%' " +
            "ORDER BY " +
            "    m.name, p.name;")
    List<Product> filterAtuadorMontadora(@Param("montadora") String montadora);

    @Query(nativeQuery = true, value ="SELECT " +
            "    p.active, " +
            "    p.categorycommercial_id, " +
            "    p.id, " +
            "    p.code, " +
            "    p.created_at, " +
            "    p.description_commercial_resume, " +
            "    p.description_commercial, " +
            "    p.description_characteristics_commercial, " +
            "    p.application_commercial, " +
            "    p.epilogue_commercial," +
            "    p.description_instalesoft, " +
            "    p.capa_imagem, " +
            "    p.img_url1, " +
            "    p.img_url2, " +
            "    p.img_url3, " +
            "    p.img_url4, " +
            "    p.img_url5, " +
            "    p.zip, " +
            "    p.name, " +
            "    p.updated_at, " +
            "    p.url_logo_img, " +
            "    p.url_manual, " +
            "    p.weight, " +
            "    p.length, " +
            "    p.width, " +
            "    p.height, " +
            "    m.name AS montadora_name, " +
            "    pcm.montadora_id " +
            "FROM " +
            "    public.tb_products p " +
            "JOIN " +
            "    public.tb_product_commercial_montadora pcm ON p.id = pcm.product_id " +
            "JOIN " +
            "    public.tb_montadoras_instalesoft m ON pcm.montadora_id = m.id " +
            "WHERE " +
            "    p.categorycommercial_id = 3 " +
            "    AND m.name ILIKE %:montadora% ")
    List<Product> filterUniqueMontadora(String montadora);
}
