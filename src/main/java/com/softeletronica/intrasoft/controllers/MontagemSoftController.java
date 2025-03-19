package com.softeletronica.intrasoft.controllers;

import com.apisoft.dto.MontagemSoftDTO;
import com.apisoft.services.MontagemSoftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/montagem-soft")
public class MontagemSoftController {
    @Autowired
    private MontagemSoftService service;

    @GetMapping
    public ResponseEntity<Page<MontagemSoftDTO>> findAll(Pageable pageable) {
        Page<MontagemSoftDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MontagemSoftDTO> findById(@PathVariable Long id) {
        MontagemSoftDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }


}
