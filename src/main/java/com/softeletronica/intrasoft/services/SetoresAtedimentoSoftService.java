package com.softeletronica.intrasoft.services;


import com.apisoft.dto.SetoresAtendimentoSoftDTO;
import com.apisoft.entities.SetoresAtendimentoSoft;
import com.apisoft.repositories.SetoresAtendimentoSoftRepository;
import com.apisoft.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class SetoresAtedimentoSoftService {

    @Autowired
    private SetoresAtendimentoSoftRepository repository;

    @Transactional(readOnly = true)
    public Page<SetoresAtendimentoSoftDTO> findAll(Pageable pageable) {
        Page<SetoresAtendimentoSoft> list = repository.findAll(pageable);
        return list.map(x -> new SetoresAtendimentoSoftDTO(x));
    }

    @Transactional(readOnly = true)
    public SetoresAtendimentoSoftDTO findById(Long id) {
        Optional<SetoresAtendimentoSoft> obj = repository.findById(id);
        SetoresAtendimentoSoft entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new SetoresAtendimentoSoftDTO(entity);
    }


}