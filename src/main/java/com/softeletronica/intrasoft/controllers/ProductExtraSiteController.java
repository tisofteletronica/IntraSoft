package com.softeletronica.intrasoft.controllers;

import com.softeletronica.intrasoft.dto.secondary.ProductExtraSiteDTO;
import com.softeletronica.intrasoft.dto.secondary.ProductExtraSiteDTO;
import com.softeletronica.intrasoft.dto.secondary.ProdutoMontadoraMinDTO;
import com.softeletronica.intrasoft.services.ProductExtraSiteService;
import com.softeletronica.intrasoft.services.ProductService;
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
@RequestMapping(value = "/products-extra-site")
public class ProductExtraSiteController {
    @Autowired
    private ProductExtraSiteService service;

    @GetMapping
    public ResponseEntity<Page<ProductExtraSiteDTO>>findAll(Pageable pageable) {
        Page<ProductExtraSiteDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/nameProduct")
    public ResponseEntity<Page<ProductExtraSiteDTO>> filterByName(
            @RequestParam(value = "product", defaultValue = "") String name,
            Pageable pageable) {

        Page<ProductExtraSiteDTO> list = service.filterByName(name, pageable);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductExtraSiteDTO> findById(@PathVariable Long id) {
        ProductExtraSiteDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_TI') and hasRole('ROLE_SITE')")
    @PostMapping(value = "/add")
    public ResponseEntity<ProductExtraSiteDTO> insert(@Valid @RequestBody ProductExtraSiteDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_TI') and hasRole('ROLE_SITE')")
    @PutMapping(value = "/update/{id}")

    public ResponseEntity<ProductExtraSiteDTO> update(@PathVariable Long id, @Valid @RequestBody
    ProductExtraSiteDTO dto) {
        ProductExtraSiteDTO newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_TI') and hasRole('ROLE_SITE')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
