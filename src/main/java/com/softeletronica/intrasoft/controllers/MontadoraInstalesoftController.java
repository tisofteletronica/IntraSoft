package com.softeletronica.intrasoft.controllers;


import com.softeletronica.intrasoft.dto.secondary.MontadoraInstalesoftDTO;
import com.softeletronica.intrasoft.services.MontadoraInstalesoftService;
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
@RequestMapping(value = "/montadoras-instalesoft")
public class MontadoraInstalesoftController {
    @Autowired
    private MontadoraInstalesoftService service;

    @GetMapping
    public ResponseEntity<List<MontadoraInstalesoftDTO>> findAll() {
        List<MontadoraInstalesoftDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/page")
    public ResponseEntity<Page<MontadoraInstalesoftDTO>> findAllPage(Pageable pageable) {
        Page<MontadoraInstalesoftDTO> list = service.findAllPage(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MontadoraInstalesoftDTO> findById(@PathVariable Long id) {
        MontadoraInstalesoftDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_INSTALE')")
    @PostMapping(value = "/add")
    public ResponseEntity<MontadoraInstalesoftDTO> insert(@Valid @RequestBody MontadoraInstalesoftDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_INSTALE')")
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<MontadoraInstalesoftDTO> update(@PathVariable Long id, @Valid @RequestBody
    MontadoraInstalesoftDTO dto) {
        MontadoraInstalesoftDTO newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_INSTALE')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
