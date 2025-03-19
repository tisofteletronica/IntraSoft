package com.softeletronica.intrasoft.services;


import com.apisoft.dto.SobreNosSoftDTO;
import com.apisoft.entities.SobreNosSoft;
import com.apisoft.repositories.SobreNosSoftRepository;
import com.apisoft.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class SobreNosSoftService {

    @Autowired
    private SobreNosSoftRepository repository;

    @Transactional(readOnly = true)
    public Page<SobreNosSoftDTO> findAll(Pageable pageable) {
        Page<SobreNosSoft> list = repository.findAll(pageable);
        return list.map(x -> new SobreNosSoftDTO(x));
    }

    @Transactional(readOnly = true)
    public SobreNosSoftDTO findById(Long id) {
        Optional<SobreNosSoft> obj = repository.findById(id);
        SobreNosSoft entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new SobreNosSoftDTO(entity);
    }


}