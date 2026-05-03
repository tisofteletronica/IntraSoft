package com.softeletronica.intrasoft.controllers;

import com.softeletronica.intrasoft.dto.secondary.ContatoSoftDTO;
import com.softeletronica.intrasoft.services.ContatoSoftService;
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
@RequestMapping(value = "/contatos-soft")
public class ContatoSoftController {
    @Autowired
    private ContatoSoftService service;

    @GetMapping
    public ResponseEntity<Page<ContatoSoftDTO>> findAll(Pageable pageable) {
        Page<ContatoSoftDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ContatoSoftDTO> findById(@PathVariable Long id) {
        ContatoSoftDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_SITE')")
    @PostMapping(value = "/add")
    public ResponseEntity<ContatoSoftDTO> insert(@Valid @RequestBody ContatoSoftDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_SITE')")
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ContatoSoftDTO> update(@PathVariable Long id, @Valid @RequestBody
    ContatoSoftDTO dto) {
        ContatoSoftDTO newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_SITE')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
