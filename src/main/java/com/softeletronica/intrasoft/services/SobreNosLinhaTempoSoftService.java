package com.softeletronica.intrasoft.services;


import com.apisoft.dto.SobreNosLinhaTempoSoftDTO;
import com.apisoft.entities.SobreNosLinhaTempoSoft;
import com.apisoft.repositories.SobreNosLinhaTempoSoftRepository;
import com.apisoft.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class SobreNosLinhaTempoSoftService {

    @Autowired
    private SobreNosLinhaTempoSoftRepository repository;

    @Transactional(readOnly = true)
    public Page<SobreNosLinhaTempoSoftDTO> findAll(Pageable pageable) {
        Page<SobreNosLinhaTempoSoft> list = repository.findAll(pageable);
        return list.map(x -> new SobreNosLinhaTempoSoftDTO(x));
    }

    @Transactional(readOnly = true)
    public SobreNosLinhaTempoSoftDTO findById(Long id) {
        Optional<SobreNosLinhaTempoSoft> obj = repository.findById(id);
        SobreNosLinhaTempoSoft entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new SobreNosLinhaTempoSoftDTO(entity);
    }


}