package com.softeletronica.intrasoft.services;



import com.softeletronica.intrasoft.dto.secondary.CatalogoSoftDTO;
import com.softeletronica.intrasoft.entities.secondary.CatalogoSoft;
import com.softeletronica.intrasoft.repositories.secondary.CatalogoSoftRepository;
import com.softeletronica.intrasoft.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class CatalogoSoftService {

    @Autowired
    private CatalogoSoftRepository repository;

    @Transactional(readOnly = true)
    public Page<CatalogoSoftDTO> findAll(Pageable pageable) {
        Page<CatalogoSoft> list = repository.findAll(pageable);
        return list.map(x -> new CatalogoSoftDTO(x));
    }

    @Transactional(readOnly = true)
    public CatalogoSoftDTO findById(Long id) {
        Optional<CatalogoSoft> obj = repository.findById(id);
        CatalogoSoft entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new CatalogoSoftDTO(entity);
    }


}