package com.softeletronica.intrasoft.controllers;

import com.apisoft.dto.MontagemSoftDiferenciaisDTO;
import com.apisoft.services.MontagemSoftDiferenciaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/montagem-diferenciais-soft")
public class MontagemSoftDiferenciaisController {
    @Autowired
    private MontagemSoftDiferenciaisService service;

    @GetMapping
    public ResponseEntity<Page<MontagemSoftDiferenciaisDTO>> findAll(Pageable pageable) {
        Page<MontagemSoftDiferenciaisDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MontagemSoftDiferenciaisDTO> findById(@PathVariable Long id) {
        MontagemSoftDiferenciaisDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }


}
