package com.softeletronica.intrasoft.controllers;

import com.softeletronica.intrasoft.dto.UnidadesSoftDTO;
import com.softeletronica.intrasoft.services.UnidadesSoftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/unities")
public class UnidadesSoftController {

    @Autowired
    private UnidadesSoftService service;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TI')")
    @GetMapping
    public ResponseEntity<Page<UnidadesSoftDTO>> findAll(Pageable pageable) {
        Page<UnidadesSoftDTO> list = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TI')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UnidadesSoftDTO> findById(@PathVariable Long id) {
        UnidadesSoftDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
}
