package com.softeletronica.intrasoft.controllers;

import com.apisoft.dto.SobreNosSoftDTO;
import com.apisoft.services.SobreNosSoftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sobrenos-soft")
public class SobreNosSoftController {
    @Autowired
    private SobreNosSoftService service;

    @GetMapping
    public ResponseEntity<Page<SobreNosSoftDTO>> findAll(Pageable pageable) {
        Page<SobreNosSoftDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SobreNosSoftDTO> findById(@PathVariable Long id) {
        SobreNosSoftDTO dto = service.findById(id);
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
