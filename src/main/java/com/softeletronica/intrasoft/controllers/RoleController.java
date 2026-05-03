package com.softeletronica.intrasoft.controllers;

import com.softeletronica.intrasoft.dto.primary.DepartmentDTO;
import com.softeletronica.intrasoft.dto.primary.RoleDTO;
import com.softeletronica.intrasoft.services.DepartmentService;
import com.softeletronica.intrasoft.services.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    @Autowired
    private RoleService service;

    @GetMapping
    public ResponseEntity<Page<RoleDTO>> findAll(Pageable pageable) {
        Page<RoleDTO> list = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

   
    @GetMapping(value = "/{id}")
    public ResponseEntity<RoleDTO> findById(@PathVariable Long id) {
        RoleDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }


}
