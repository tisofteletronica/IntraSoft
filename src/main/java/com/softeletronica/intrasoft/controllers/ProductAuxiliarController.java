package com.softeletronica.intrasoft.controllers;

import com.softeletronica.intrasoft.dto.primary.DepartmentDTO;
import com.softeletronica.intrasoft.dto.secondary.MontadoraInstalesoftDTO;
import com.softeletronica.intrasoft.dto.secondary.ProductAuxiliarDTO;
import com.softeletronica.intrasoft.services.DepartmentService;
import com.softeletronica.intrasoft.services.ProductAuxiliarService;
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
@RequestMapping(value = "/products-auxiliar")
public class ProductAuxiliarController {

    @Autowired
    private ProductAuxiliarService productAuxiliarService;

    @GetMapping
    public ResponseEntity<Page<ProductAuxiliarDTO>> findAll(Pageable pageable) {
        Page<ProductAuxiliarDTO> list = productAuxiliarService.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductAuxiliarDTO> findById(@PathVariable Long id) {
        ProductAuxiliarDTO dto = productAuxiliarService.findById(id);
        return ResponseEntity.ok().body(dto);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_TI') and hasRole('ROLE_INSTALE')")
    @PostMapping(value = "/add")
    public ResponseEntity<ProductAuxiliarDTO> insert(@Valid @RequestBody ProductAuxiliarDTO dto) {
        dto = productAuxiliarService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_TI') and hasRole('ROLE_INSTALE')")
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ProductAuxiliarDTO> update(@PathVariable Long id, @Valid @RequestBody
    ProductAuxiliarDTO dto) {
        ProductAuxiliarDTO newDto = productAuxiliarService.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_TI') and hasRole('ROLE_INSTALE')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productAuxiliarService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
