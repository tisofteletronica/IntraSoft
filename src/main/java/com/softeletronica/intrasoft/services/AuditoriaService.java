package com.softeletronica.intrasoft.services;

import com.softeletronica.intrasoft.dto.primary.AuditoriaDTO;


import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class AuditoriaService {
    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Transactional(readOnly = true)
    public Page<AuditoriaDTO> findAllPaged(Pageable pageable) {
        Page<Auditoria> list = auditoriaRepository.findAll(pageable);
        return list.map(x-> new AuditoriaDTO(x));
    }
    @Transactional
    public AuditoriaDTO insert(AuditoriaDTO dto) {
        Auditoria entity = new Auditoria();
        copyDtoToEntity(dto, entity);
        entity.setCreated(Instant.now());

        entity = auditoriaRepository.save(entity);
        return new AuditoriaDTO(entity);
    }
    private void copyDtoToEntity(AuditoriaDTO dto, Auditoria entity) {
        entity.setCreated(dto.getCreated());
        entity.setObjeto(dto.getObjeto());
        entity.setUsuario(dto.getUsuario());

    }
}
