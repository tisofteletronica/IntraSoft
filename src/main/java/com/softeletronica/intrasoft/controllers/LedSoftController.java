package com.softeletronica.intrasoft.controllers;

import com.apisoft.dto.LedSoftDTO;
import com.apisoft.services.LedSoftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/led-soft")
public class LedSoftController {
    @Autowired
    private LedSoftService service;

    @GetMapping
    public ResponseEntity<Page<LedSoftDTO>> findAll(Pageable pageable) {
        Page<LedSoftDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LedSoftDTO> findById(@PathVariable Long id) {
        LedSoftDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    
}
