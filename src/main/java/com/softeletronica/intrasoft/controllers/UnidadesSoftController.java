package com.softeletronica.intrasoft.controllers;

import com.softeletronica.intrasoft.dto.secondary.UnidadeSoftDTO;
import com.softeletronica.intrasoft.services.UnidadeSoftService;
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
@RequestMapping(value = "/unidades-soft")
public class UnidadesSoftController {
    @Autowired
    private UnidadeSoftService service;

    @GetMapping
    public ResponseEntity<Page<UnidadeSoftDTO>> findAll(Pageable pageable) {
        Page<UnidadeSoftDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UnidadeSoftDTO> findById(@PathVariable Long id) {
        UnidadeSoftDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TI')")
    @PostMapping(value = "/add")
    public ResponseEntity<UnidadeSoftDTO> insert(@Valid @RequestBody UnidadeSoftDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TI')")
    @PutMapping(value = "/update/{id}")

    public ResponseEntity<UnidadeSoftDTO> update(@PathVariable Long id, @Valid @RequestBody
    UnidadeSoftDTO dto) {
        UnidadeSoftDTO newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
