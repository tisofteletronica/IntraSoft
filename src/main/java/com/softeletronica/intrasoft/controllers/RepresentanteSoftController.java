package com.softeletronica.intrasoft.controllers;

import com.apisoft.dto.RepresentanteSoftDTO;
import com.apisoft.services.RepresentanteSoftService;
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
@RequestMapping(value = "/representantes-soft-site")
public class RepresentanteSoftController {
    @Autowired
    private RepresentanteSoftService service;

    @GetMapping
    public ResponseEntity<Page<RepresentanteSoftDTO>> findAll(Pageable pageable) {
        Page<RepresentanteSoftDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RepresentanteSoftDTO> findById(@PathVariable Long id) {
        RepresentanteSoftDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TI')")
    @PostMapping(value = "/add")
    public ResponseEntity<RepresentanteSoftDTO> insert(@Valid @RequestBody RepresentanteSoftDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TI')")
    @PutMapping(value = "/update/{id}")

    public ResponseEntity<RepresentanteSoftDTO> update(@PathVariable Long id, @Valid @RequestBody
    RepresentanteSoftDTO dto) {
        RepresentanteSoftDTO newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
