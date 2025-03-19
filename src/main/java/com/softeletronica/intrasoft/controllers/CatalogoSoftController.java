package com.softeletronica.intrasoft.controllers;

import com.apisoft.dto.CatalogoSoftDTO;
import com.apisoft.services.CatalogoSoftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/catalogo-soft")
public class CatalogoSoftController {
    @Autowired
    private CatalogoSoftService service;

    @GetMapping
    public ResponseEntity<Page<CatalogoSoftDTO>> findAll(Pageable pageable) {
        Page<CatalogoSoftDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CatalogoSoftDTO> findById(@PathVariable Long id) {
        CatalogoSoftDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

}
