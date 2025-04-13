package com.softeletronica.intrasoft.controllers;

import com.softeletronica.intrasoft.dto.secondary.*;
import com.softeletronica.intrasoft.services.AplicacaoInstaleSoftService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/app-instalesoft")
public class AplicacaoInstaleSoftController {
    @Autowired
    private AplicacaoInstaleSoftService service;

    @GetMapping
    public ResponseEntity<Page<AplicacaoInstaleSoftDTO>> findAll(Pageable pageable) {
        Page<AplicacaoInstaleSoftDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AplicacaoInstaleSoftDTO> findById(@PathVariable Long id) {
        AplicacaoInstaleSoftDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/modeloano")
    public ResponseEntity<List<AnoCarroMinDTO>> filterAno(
            @RequestParam(value = "modeloId", defaultValue = "0") Long id

    ) {
        List<AnoCarroMinDTO> list = service.filtrarAnos(id);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/modelocategoria")
    public ResponseEntity<Page<CategoriaModeloMinDTO>> filterCategoria(
            @RequestParam(value = "modeloId", defaultValue = "0") Long modeloId,
            @RequestParam(value = "ano", defaultValue = "0") Integer ano,
            Pageable pageable
    ) {
        Page<CategoriaModeloMinDTO> list = service.filtrarCategoria(modeloId, ano, pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/modelocategoriasemano")
    public ResponseEntity<Page<CategoriaModeloMinDTO>> filterCategoriaSemAno(
            @RequestParam(value = "modeloId", defaultValue = "0") Long modeloId,

            Pageable pageable
    ) {
        Page<CategoriaModeloMinDTO> list = service.filtrarCategoriaSemAno(modeloId, pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/modeloprodutos")
    public ResponseEntity<Page<AplicacaoInstaleSoftDTO>> modeloProduto(
            @RequestParam(value = "ano", defaultValue = "0") Integer ano,
            @RequestParam(value = "categoriaId", defaultValue = "0") Long categoriaId,
            @RequestParam(value = "modeloId", defaultValue = "0") Long modeloId,
            Pageable pageable
    ) {
        Page<AplicacaoInstaleSoftDTO> list = service.modeloProduto(ano, categoriaId, modeloId, pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/modeloname")
    public ResponseEntity<Page<AplicacaoInstaleSoftDTO>> modeloProdutoName(
            @RequestParam(value = "categoriaId", defaultValue = "0") Long categoriaId,
            @RequestParam(value = "modeloName", defaultValue = "0")  String modeloName,
            Pageable pageable
    ) {
        Page<AplicacaoInstaleSoftDTO> list = service.modeloProdutoNome(categoriaId, modeloName,  pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/modeloprodutosvc")
    public ResponseEntity<Page<AplicacaoInstaleSoftDTO>> modeloProdutoVc(
            @RequestParam(value = "ano", defaultValue = "0") Integer ano,
            @RequestParam(value = "categoriaId", defaultValue = "0") Long categoriaId,
            @RequestParam(value = "modeloId", defaultValue = "0") Long modeloId,
            @RequestParam(value = "vidroConvencional", defaultValue = "0") Integer vidroConvencional,
            Pageable pageable
    ) {
        Page<AplicacaoInstaleSoftDTO> list = service.modeloProdutoVc(ano, categoriaId, modeloId, vidroConvencional, pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/modeloprodutosvi")
    public ResponseEntity<Page<AplicacaoInstaleSoftDTO>> modeloProdutoVi(
            @RequestParam(value = "ano", defaultValue = "0") Integer ano,
            @RequestParam(value = "categoriaId", defaultValue = "0") Long categoriaId,
            @RequestParam(value = "modeloId", defaultValue = "0") Long modeloId,
            @RequestParam(value = "vidroConvencional", defaultValue = "0") Integer vidroConvencional,
            @RequestParam(value = "vidroInteligente", defaultValue = "0") Integer vidroInteligente,
            Pageable pageable
    ) {
        Page<AplicacaoInstaleSoftDTO> list = service.modeloProdutoVi(ano, categoriaId, modeloId, vidroConvencional,
                vidroInteligente, pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/filtroprodutosmodelo")
    public ResponseEntity<Page<ProdutoporAplicacaoMinDTO>> filterProdutoModelo(
            @RequestParam(value = "categoryInstaleSoftId", defaultValue = "0") Long categoryInstaleSoftId,
            Pageable pageable
    ) {
        Page<ProdutoporAplicacaoMinDTO> list = service.produtoAplicacao(categoryInstaleSoftId, pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/filtromodeloproduto")
    public ResponseEntity<Page<ProdutosPorModeloMinDTO>> filterModeloProduto(
            @RequestParam(value = "productId", defaultValue = "0") Long productId,
            @RequestParam(value = "categoryInstaleSoftId", defaultValue = "0") Long categoryInstaleSoftId,
            Pageable pageable
    ) {
        Page<ProdutosPorModeloMinDTO> list = service.produtoModelo(productId, categoryInstaleSoftId, pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/filtromodeloprodutomontadora")
    public ResponseEntity<Page<ProdutosPorModeloMinDTO>> filterModeloProdutoMontadora(
            @RequestParam(value = "productId", defaultValue = "0") Long productId,
            @RequestParam(value = "categoryInstaleSoftId", defaultValue = "0") Long categoryInstaleSoftId,
            @RequestParam(value = "montadoraName", defaultValue = "0") String montadoraName,
            Pageable pageable
    ) {
        Page<ProdutosPorModeloMinDTO> list = service.produtoModeloFiltroMontadora(productId, categoryInstaleSoftId,
                montadoraName, pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/filtromodeloprodutomodeloname")
    public ResponseEntity<Page<ProdutosPorModeloMinDTO>> filterModeloProdutoModeloName(
            @RequestParam(value = "productId", defaultValue = "0") Long productId,
            @RequestParam(value = "categoryInstaleSoftId", defaultValue = "0") Long categoryInstaleSoftId,
            @RequestParam(value = "modeloName", defaultValue = "0") String modeloName,
            Pageable pageable
    ) {
        Page<ProdutosPorModeloMinDTO> list = service.produtoModeloFiltroModeloName(productId, categoryInstaleSoftId,
                modeloName, pageable);
        return ResponseEntity.ok().body(list);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_INSTALE')")
    @PostMapping(value = "/add")
    public ResponseEntity<AplicacaoInstaleSoftInsertDTO> insert(@Valid @RequestBody AplicacaoInstaleSoftInsertDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_INSTALE')")
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<AplicacaoInstaleSoftInsertDTO> update(@PathVariable Long id, @Valid @RequestBody
    AplicacaoInstaleSoftInsertDTO dto) {
        AplicacaoInstaleSoftInsertDTO newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_INSTALE')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
