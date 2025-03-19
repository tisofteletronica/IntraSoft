package com.softeletronica.intrasoft.controllers;

import com.apisoft.dto.MontagemSoftAtuacaoDTO;
import com.apisoft.services.MontagemSoftAtuacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/montagem-soft-atuacao")
public class MontagemSoftAtuacaoController {
    @Autowired
    private MontagemSoftAtuacaoService service;

    @GetMapping
    public ResponseEntity<Page<MontagemSoftAtuacaoDTO>> findAll(Pageable pageable) {
        Page<MontagemSoftAtuacaoDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MontagemSoftAtuacaoDTO> findById(@PathVariable Long id) {
        MontagemSoftAtuacaoDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

}
