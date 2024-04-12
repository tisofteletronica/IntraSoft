package com.softeletronica.intrasoft.controllers;

import com.softeletronica.intrasoft.services.DepartmentService;
import com.softeletronica.intrasoft.dto.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TI')")
    @GetMapping
    public ResponseEntity<Page<DepartmentDTO>> findAll(Pageable pageable) {
        Page<DepartmentDTO> list = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TI')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> findById(@PathVariable Long id) {
        DepartmentDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
}
