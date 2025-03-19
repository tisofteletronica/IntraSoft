package com.softeletronica.intrasoft.services;


import com.apisoft.dto.LedSoftDTO;
import com.apisoft.entities.LedSoft;
import com.apisoft.repositories.LedSoftRepository;
import com.apisoft.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class LedSoftService {

    @Autowired
    private LedSoftRepository repository;

    @Transactional(readOnly = true)
    public Page<LedSoftDTO> findAll(Pageable pageable) {
        Page<LedSoft> list = repository.findAll(pageable);
        return list.map(x -> new LedSoftDTO(x));
    }

    @Transactional(readOnly = true)
    public LedSoftDTO findById(Long id) {
        Optional<LedSoft> obj = repository.findById(id);
        LedSoft entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new LedSoftDTO(entity);
    }


}