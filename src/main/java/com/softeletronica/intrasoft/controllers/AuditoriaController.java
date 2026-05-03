package com.softeletronica.intrasoft.controllers;

import com.softeletronica.intrasoft.dto.primary.AuditoriaDTO;
import com.softeletronica.intrasoft.dto.primary.DepartmentDTO;
import com.softeletronica.intrasoft.dto.secondary.ProductDTO;
import com.softeletronica.intrasoft.services.AuditoriaService;
import com.softeletronica.intrasoft.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auditoria")
public class AuditoriaController {

    @Autowired
    private AuditoriaService auditoriaService;

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI')")
    @GetMapping
    public ResponseEntity<Page<AuditoriaDTO>> findAll(Pageable pageable) {
        Page<AuditoriaDTO> list = auditoriaService.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI')")
    @GetMapping(value = "/date" )
    public ResponseEntity<Page<AuditoriaDTO>>findDate(
            @RequestParam(value = "inicio", defaultValue = "") String inicio,
            @RequestParam(value = "fim", defaultValue = "") String fim,
            Pageable pageable){
        Page<AuditoriaDTO> list = auditoriaService.findDate(inicio, fim, pageable);
        return ResponseEntity.ok().body(list);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_TI')")
    @GetMapping(value = "/objeto")
    public ResponseEntity<Page<AuditoriaDTO>> filterByObj(
            @RequestParam(value = "objeto", defaultValue = "") String objeto,
            Pageable pageable) {

        Page<AuditoriaDTO> list = auditoriaService.filterItem(objeto, pageable);
        return ResponseEntity.ok().body(list);
    }

}
