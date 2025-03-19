package com.softeletronica.intrasoft.controllers;

import com.apisoft.dto.SobreNosLinhaTempoSoftDTO;
import com.apisoft.services.SobreNosLinhaTempoSoftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sobrenoslinhatempo-soft")
public class SobreNosLinhaTempoSoftController {
    @Autowired
    private SobreNosLinhaTempoSoftService service;

    @GetMapping
    public ResponseEntity<Page<SobreNosLinhaTempoSoftDTO>> findAll(Pageable pageable) {
        Page<SobreNosLinhaTempoSoftDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SobreNosLinhaTempoSoftDTO> findById(@PathVariable Long id) {
        SobreNosLinhaTempoSoftDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }


}
