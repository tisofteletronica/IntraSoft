package com.softeletronica.intrasoft.controllers;


import com.softeletronica.intrasoft.dto.secondary.ModeloInstalesoftDTO;
import com.softeletronica.intrasoft.services.ModeloInstalesoftService;
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
@RequestMapping(value = "/modelos-instalesoft")
public class ModeloInstalesoftController {
    @Autowired
    private ModeloInstalesoftService service;

    @GetMapping(value = "/all")
    public ResponseEntity<Page<ModeloInstalesoftDTO>> findAllPaged(Pageable pageable) {
        Page<ModeloInstalesoftDTO> list = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/filterByName")
    public ResponseEntity<Page<ModeloInstalesoftDTO>> findName(
            @RequestParam(value = "name", defaultValue = "") String name,
            Pageable pageable) {
        Page<ModeloInstalesoftDTO> list = service.findAllName(name, pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/filterByIdMontadora")
    public ResponseEntity<Page<ModeloInstalesoftDTO>> findIdMontadora(
            @RequestParam(value = "montadoraId", defaultValue = "0") Long montadoraId,
            Pageable pageable) {
        Page<ModeloInstalesoftDTO> list = service.findByIdMontadora(montadoraId, pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/ListByIdMontadora")
    public ResponseEntity<List<ModeloInstalesoftDTO>> findIdMontadora(
            @RequestParam(value = "montadoraId", defaultValue = "0") Long montadoraId) {
        List<ModeloInstalesoftDTO> list = service.ListByIdMontadora(montadoraId);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/filterByNameMontadora")
    public ResponseEntity<Page<ModeloInstalesoftDTO>> findNameMontadora(
            @RequestParam(value = "montadora", defaultValue = "") String montadora,
            Pageable pageable) {
        Page<ModeloInstalesoftDTO> list = service.findByNameMontadora(montadora, pageable);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<ModeloInstalesoftDTO> findById(@PathVariable Long id) {
        ModeloInstalesoftDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_INSTALE')")
    @PostMapping(value = "/add")
    public ResponseEntity<ModeloInstalesoftDTO> insert(@Valid @RequestBody ModeloInstalesoftDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_INSTALE')")
    @PutMapping(value = "/update/{id}")

    public ResponseEntity<ModeloInstalesoftDTO> update(@PathVariable Long id, @Valid @RequestBody
    ModeloInstalesoftDTO dto) {
        ModeloInstalesoftDTO newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_INSTALE')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
