package com.softeletronica.intrasoft.controllers;

import com.apisoft.dto.ClienteSoftDTO;
import com.apisoft.services.ClienteSoftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes-soft-site")
public class ClienteSoftController {
    @Autowired
    private ClienteSoftService service;

    @GetMapping
    public ResponseEntity<Page<ClienteSoftDTO>> findAll(Pageable pageable) {
        Page<ClienteSoftDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteSoftDTO> findById(@PathVariable Long id) {
        ClienteSoftDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/filterUfOrCity")
    public ResponseEntity<List<ClienteSoftDTO>> findAll(
            @RequestParam(value = "uf", defaultValue = "") String uf,
            @RequestParam(value = "cidade", defaultValue = "") String cidade
    ) {
        List<ClienteSoftDTO> list = service.findUfOrCity(uf, cidade);
        return ResponseEntity.ok().body(list);
    }


}
