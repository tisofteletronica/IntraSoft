package com.softeletronica.intrasoft.services;

import com.softeletronica.intrasoft.dto.UnidadesSoftDTO;
import com.softeletronica.intrasoft.entities.UnidadesSoft;
import com.softeletronica.intrasoft.repositories.UnidadesSoftRepository;
import com.softeletronica.intrasoft.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UnidadesSoftService {
    @Autowired
    private UnidadesSoftRepository repository;
    @Transactional(readOnly = true)
    public Page<UnidadesSoftDTO>findAllPaged(Pageable pageable) {
        Page<UnidadesSoft> list = repository.findAll(pageable);
        return list.map(x-> new UnidadesSoftDTO(x));
    }

    @Transactional(readOnly = true)
    public UnidadesSoftDTO findById(Long id) {
        Optional<UnidadesSoft> obj = repository.findById(id);
        UnidadesSoft entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new UnidadesSoftDTO(entity);
    }

}
