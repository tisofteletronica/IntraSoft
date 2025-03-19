package com.softeletronica.intrasoft.controllers;

import com.softeletronica.intrasoft.dto.secondary.CategoryProductInstaleSoftDTO;
import com.softeletronica.intrasoft.services.CategoryProductCommercialService;
import com.softeletronica.intrasoft.services.CategoryProductInstaleSoftService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/categoriesproducts-instalesoft")
public class CategoryProductInstaleSoftController {
    @Autowired
    private CategoryProductInstaleSoftService service;

    @GetMapping
    public ResponseEntity<Page<CategoryProductInstaleSoftDTO>> findAll(Pageable pageable) {
        Page<CategoryProductInstaleSoftDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryProductInstaleSoftDTO> findById(@PathVariable Long id) {
        CategoryProductInstaleSoftDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_TI') and hasRole('ROLE_INSTALE') and hasRole('ROLE_SITE')")
    @PostMapping(value = "/add")
    public ResponseEntity<CategoryProductInstaleSoftDTO> insert(@Valid @RequestBody CategoryProductInstaleSoftDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_TI') and hasRole('ROLE_INSTALE') and hasRole('ROLE_SITE')")
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<CategoryProductInstaleSoftDTO> update(@PathVariable Long id, @Valid @RequestBody
    CategoryProductInstaleSoftDTO dto) {
        CategoryProductInstaleSoftDTO newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_TI') and hasRole('ROLE_INSTALE') and hasRole('ROLE_SITE')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
