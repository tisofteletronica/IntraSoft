package com.softeletronica.intrasoft.controllers;

import com.softeletronica.intrasoft.dto.secondary.ClienteSoftDTO;
import com.softeletronica.intrasoft.services.ClienteSoftService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping(value = "/filterUfOrCityPage")
    public ResponseEntity<Page<ClienteSoftDTO>> findAllPage(
            @RequestParam(value = "uf", defaultValue = "") String uf,
            @RequestParam(value = "cidade", defaultValue = "") String cidade, Pageable pageable
    ) {
        Page<ClienteSoftDTO> list = service.findUfOrCityPage(uf, cidade, pageable);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/name")
    public ResponseEntity<Page<ClienteSoftDTO>> findName(
            @RequestParam(value = "name", defaultValue = "") String razaoSocial, Pageable pageable
    ) {
        Page<ClienteSoftDTO> list = service.findRazaoSocial(razaoSocial, pageable);
        return ResponseEntity.ok().body(list);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_SITE')")
    @PostMapping(value = "/add")
    public ResponseEntity<ClienteSoftDTO> insert(@Valid @RequestBody ClienteSoftDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_SITE')")
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ClienteSoftDTO> update(@PathVariable Long id, @Valid @RequestBody
    ClienteSoftDTO dto) {
        ClienteSoftDTO newDto = service.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI') or hasRole('ROLE_SITE')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
