package com.softeletronica.intrasoft.services;


import com.apisoft.dto.MontagemSoftDTO;
import com.apisoft.entities.MontagemSoft;
import com.apisoft.repositories.MontagemSoftRepository;
import com.apisoft.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class MontagemSoftService {

    @Autowired
    private MontagemSoftRepository repository;

    @Transactional(readOnly = true)
    public Page<MontagemSoftDTO> findAll(Pageable pageable) {
        Page<MontagemSoft> list = repository.findAll(pageable);
        return list.map(x -> new MontagemSoftDTO(x));
    }

    @Transactional(readOnly = true)
    public MontagemSoftDTO findById(Long id) {
        Optional<MontagemSoft> obj = repository.findById(id);
        MontagemSoft entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new MontagemSoftDTO(entity);
    }


}