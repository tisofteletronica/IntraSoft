package com.softeletronica.intrasoft.controllers;

import com.softeletronica.intrasoft.dto.secondary.MontagemSoftMaquinasDTO;
import com.softeletronica.intrasoft.dto.secondary.MontagemSoftMaquinasDTO;
import com.softeletronica.intrasoft.services.MontagemSoftMaquinasService;
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
@RequestMapping(value = "/montagem-maquinas-soft")
public class MontagemSoftMaquinasController {
    @Autowired
    private MontagemSoftMaquinasService service;

    @GetMapping
    public ResponseEntity<Page<MontagemSoftMaquinasDTO>> findAll(Pageable pageable) {
        Page<MontagemSoftMaquinasDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MontagemSoftMaquinasDTO> findById(@PathVariable Long id) {
        MontagemSoftMaquinasDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_SITE')")
    @PostMapping(value = "/add")
    public ResponseEntity<MontagemSoftMaquinasDTO> insert(@Valid @RequestBody MontagemSoftMaquinasDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_SITE')")
    @PutMapping(value = "/update/{id}")

    public ResponseEntity<MontagemSoftMaquinasDTO> update(@PathVariable Long id, @Valid @RequestBody
    MontagemSoftMaquinasDTO dto) {
        MontagemSoftMaquinasDTO newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_SITE')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
