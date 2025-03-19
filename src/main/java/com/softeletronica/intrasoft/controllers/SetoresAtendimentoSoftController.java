package com.softeletronica.intrasoft.controllers;

import com.apisoft.dto.SetoresAtendimentoSoftDTO;
import com.apisoft.services.SetoresAtedimentoSoftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
