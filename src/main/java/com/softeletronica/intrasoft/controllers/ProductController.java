package com.softeletronica.intrasoft.controllers;

import com.softeletronica.intrasoft.dto.secondary.ProductDTO;
import com.softeletronica.intrasoft.dto.secondary.ProdutoMontadoraMinDTO;
import com.softeletronica.intrasoft.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable) {
        Page<ProductDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/categoryById")
    public ResponseEntity<Page<ProductDTO>> filterByCategoryId(
            @RequestParam(value = "categoryId", defaultValue = "0") Long categoryCommercialId,
            Pageable pageable) {
        Page<ProductDTO> list = service.filterCategoryById(categoryCommercialId, pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/nameProduct")
    public ResponseEntity<Page<ProductDTO>> filterByName(
            @RequestParam(value = "product", defaultValue = "") String name,
            Pageable pageable) {

        Page<ProductDTO> list = service.filterByName(name, pageable);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/filtercode")
    public ResponseEntity<Page<ProductDTO>> filterCode(
            @RequestParam(value = "code", defaultValue = "") String code,
            Pageable pageable) {
        Page<ProductDTO> list = service.SorteCode(code, pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/sortcode")
    public ResponseEntity<Page<ProductDTO>> SortCode(
            @RequestParam(required = false) String code,
            Pageable pageable) {
        Page<ProductDTO> list = service.SorteCode(code, pageable);
        return ResponseEntity.ok().body(list);
    }


    @GetMapping(value = "/filterCategoryTravaAtuador")
    public ResponseEntity<Page<ProductDTO>> filterByCategoryCustom(
            @RequestParam(value = "product", defaultValue = "") String name,
            @RequestParam(value = "category", defaultValue = "0") Long categoryCommercialId,
            Pageable pageable)
    {
        Page<ProductDTO> list = service.filterByCategoryTravaAtuador(name, categoryCommercialId, pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/travaListaMontadora")
    public ResponseEntity<List<ProdutoMontadoraMinDTO>> TravaListaMontadora() {
        List<ProdutoMontadoraMinDTO> list = service.filterProdutoTravaMontadoraList();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/atuadorListaMontadora")
    public ResponseEntity<List<ProdutoMontadoraMinDTO>> AtuadorListaMontadora() {
        List<ProdutoMontadoraMinDTO> list = service.filterProdutoAtuadorMontadoraList();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/uniqueListaMontadora")
    public ResponseEntity<List<ProdutoMontadoraMinDTO>> UniqueListaMontadora() {
        List<ProdutoMontadoraMinDTO> list = service.filterProdutoUniqueMontadoraList();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/travaProdutoMontadora")
    public ResponseEntity<List<ProductDTO>> TravaProdutoMontadora(
            @RequestParam(value = "montadora", defaultValue = "") String montadora

    ) {
        List<ProductDTO> list = service.filterTravaMontadoraList( montadora);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/atuadorProdutoMontadora")
    public ResponseEntity<List<ProductDTO>> AtuadorProdutoMontadora(
            @RequestParam(value = "montadora", defaultValue = "") String montadora

    ) {
        List<ProductDTO> list = service.filterAtuadorMontadoraList( montadora);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/uniqueProdutoMontadora")
    public ResponseEntity<List<ProductDTO>> uniqueProdutoMontadora(
            @RequestParam(value = "montadora", defaultValue = "") String montadora

    ) {
        List<ProductDTO> list = service.filterUniqueMontadoraList(montadora);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        ProductDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_TI') and hasRole('ROLE_SITE')")
    @PostMapping(value = "/add")
    public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_TI') and hasRole('ROLE_SITE')")
    @PutMapping(value = "/update/{id}")

    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @Valid @RequestBody
    ProductDTO dto) {
        ProductDTO newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_TI') and hasRole('ROLE_SITE')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
