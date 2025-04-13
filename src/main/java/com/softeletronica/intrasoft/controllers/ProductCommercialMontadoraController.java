package com.softeletronica.intrasoft.controllers;

import com.softeletronica.intrasoft.dto.secondary.ProductCommercialMontadoraDTO;
import com.softeletronica.intrasoft.dto.secondary.ProductCommercialMontadoraDTO;
import com.softeletronica.intrasoft.entities.secondary.ProductCommercialMontadora;
import com.softeletronica.intrasoft.services.ProductAuxiliarService;
import com.softeletronica.intrasoft.services.ProductCommercialMontadoraService;
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
@RequestMapping(value = "/products-commercial-montadora")
public class ProductCommercialMontadoraController {

    @Autowired
    private ProductCommercialMontadoraService productCommercialMontadoraService;

    @GetMapping
    public ResponseEntity<Page<ProductCommercialMontadoraDTO>> findAll(Pageable pageable) {
        Page<ProductCommercialMontadoraDTO> list = productCommercialMontadoraService.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductCommercialMontadoraDTO> findById(@PathVariable Long id) {
        ProductCommercialMontadoraDTO dto = productCommercialMontadoraService.findById(id);
        return ResponseEntity.ok().body(dto);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_SITE')")
    @PostMapping(value = "/add")
    public ResponseEntity<ProductCommercialMontadoraDTO> insert(@Valid @RequestBody ProductCommercialMontadoraDTO dto) {
        dto = productCommercialMontadoraService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_SITE')")
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ProductCommercialMontadoraDTO> update(@PathVariable Long id, @Valid @RequestBody
    ProductCommercialMontadoraDTO dto) {
        ProductCommercialMontadoraDTO newDto = productCommercialMontadoraService.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_SITE')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productCommercialMontadoraService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
