package com.softeletronica.intrasoft.controllers;

import com.softeletronica.intrasoft.dto.primary.UnidadesSoftDTO;

import com.softeletronica.intrasoft.services.UnidadesSoftService;
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
@RequestMapping(value = "/unities")
public class UnidadeSoftController {

    @Autowired
    private UnidadesSoftService service;


    @GetMapping
    public ResponseEntity<Page<UnidadesSoftDTO>> findAll(Pageable pageable) {
        Page<UnidadesSoftDTO> list = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<UnidadesSoftDTO> findById(@PathVariable Long id) {
        UnidadesSoftDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_SITE')")
    @PostMapping(value = "/add")
    public ResponseEntity<UnidadesSoftDTO> insert(@Valid @RequestBody UnidadesSoftDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_SITE')")
    @PutMapping(value = "/update/{id}")

    public ResponseEntity<UnidadesSoftDTO> update(@PathVariable Long id, @Valid @RequestBody
    UnidadesSoftDTO dto) {
        UnidadesSoftDTO newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_SITE')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}

