package com.softeletronica.intrasoft.controllers;

import com.apisoft.dto.MontagemSoftServicosDTO;
import com.apisoft.services.MontagemSoftServicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/montagem-servicos-soft")
public class MontagemSoftServicosController {
    @Autowired
    private MontagemSoftServicosService service;

    @GetMapping
    public ResponseEntity<Page<MontagemSoftServicosDTO>> findAll(Pageable pageable) {
        Page<MontagemSoftServicosDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MontagemSoftServicosDTO> findById(@PathVariable Long id) {
        MontagemSoftServicosDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }


}
