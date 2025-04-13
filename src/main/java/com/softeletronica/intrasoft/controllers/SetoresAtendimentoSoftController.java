package com.softeletronica.intrasoft.controllers;

import com.softeletronica.intrasoft.dto.secondary.SetoresAtendimentoSoftDTO;
import com.softeletronica.intrasoft.dto.secondary.SetoresAtendimentoSoftDTO;
import com.softeletronica.intrasoft.services.SetoresAtedimentoSoftService;
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
@RequestMapping(value = "/setores-atendimento-soft")
public class SetoresAtendimentoSoftController {
    @Autowired
    private SetoresAtedimentoSoftService service;

    @GetMapping
    public ResponseEntity<Page<SetoresAtendimentoSoftDTO>> findAll(Pageable pageable) {
        Page<SetoresAtendimentoSoftDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SetoresAtendimentoSoftDTO> findById(@PathVariable Long id) {
        SetoresAtendimentoSoftDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_SITE')")
    @PostMapping(value = "/add")
    public ResponseEntity<SetoresAtendimentoSoftDTO> insert(@Valid @RequestBody SetoresAtendimentoSoftDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_SITE')")
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<SetoresAtendimentoSoftDTO> update(@PathVariable Long id, @Valid @RequestBody
    SetoresAtendimentoSoftDTO dto) {
        SetoresAtendimentoSoftDTO newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_SITE')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
