package com.softeletronica.intrasoft.controllers;

import com.apisoft.dto.ConectividadeSoftDTO;
import com.apisoft.services.ConectividadeSoftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/conectividade-soft")
public class ConectividadeSoftController {
    @Autowired
    private ConectividadeSoftService service;

    @GetMapping
    public ResponseEntity<Page<ConectividadeSoftDTO>> findAll(Pageable pageable) {
        Page<ConectividadeSoftDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ConectividadeSoftDTO> findById(@PathVariable Long id) {
        ConectividadeSoftDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

/*
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TI')")
    @PostMapping(value = "/add")
    public ResponseEntity<UnidadeSoftDTO> insert(@Valid @RequestBody UnidadeSoftDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TI')")
    @PutMapping(value = "/{id}")

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
    }*/
}
