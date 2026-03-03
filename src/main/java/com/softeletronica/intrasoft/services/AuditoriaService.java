package com.softeletronica.intrasoft.services;

import com.softeletronica.intrasoft.dto.primary.AuditoriaDTO;


import com.softeletronica.intrasoft.dto.secondary.ProductDTO;
import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.secondary.Product;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

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
    public Page<AuditoriaDTO> findDate(String inicio, String fim, Pageable pageable) {
        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate start = inicio.equals("")? today.minusDays(365): LocalDate.parse(inicio);
        LocalDate end = fim.equals("")? today : LocalDate.parse(fim);
        Page<Auditoria> list = auditoriaRepository.findByDate(start, end, pageable);

        return list.map(x-> new AuditoriaDTO(x));
    }

    @Transactional(readOnly = true)
    public Page<AuditoriaDTO> filterItem(String objeto, Pageable pageable) {

        if (objeto != "") {
            Page<Auditoria> list = auditoriaRepository.filterByObjeto(objeto, pageable);
            return list.map(x -> new AuditoriaDTO(x));
        } else {
            Page<Auditoria> list = auditoriaRepository.findAll(pageable);
            return list.map(x -> new AuditoriaDTO(x));
        }
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
