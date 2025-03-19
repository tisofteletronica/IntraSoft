package com.softeletronica.intrasoft.controllers;

import com.softeletronica.intrasoft.dto.primary.AuditoriaDTO;
import com.softeletronica.intrasoft.dto.primary.DepartmentDTO;
import com.softeletronica.intrasoft.services.AuditoriaService;
import com.softeletronica.intrasoft.services.DepartmentService;
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
@RequestMapping(value = "/auditoria")
public class AuditoriaController {

    @Autowired
    private AuditoriaService auditoriaService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")

    @GetMapping
    public ResponseEntity<Page<AuditoriaDTO>> findAll(Pageable pageable) {
        Page<AuditoriaDTO> list = auditoriaService.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }


}
