package com.softeletronica.intrasoft.controllers;

import com.apisoft.dto.MontagemSoftMaquinasDTO;
import com.apisoft.services.MontagemSoftMaquinasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
