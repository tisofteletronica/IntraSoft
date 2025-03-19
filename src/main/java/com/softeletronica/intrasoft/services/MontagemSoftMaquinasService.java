package com.softeletronica.intrasoft.services;


import com.apisoft.dto.MontagemSoftMaquinasDTO;
import com.apisoft.entities.MontagemSoftMaquinas;
import com.apisoft.repositories.MontagemSoftMaquinasRepository;
import com.apisoft.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class MontagemSoftMaquinasService {

    @Autowired
    private MontagemSoftMaquinasRepository repository;

    @Transactional(readOnly = true)
    public Page<MontagemSoftMaquinasDTO> findAll(Pageable pageable) {
        Page<MontagemSoftMaquinas> list = repository.findAll(pageable);
        return list.map(x -> new MontagemSoftMaquinasDTO(x));
    }

    @Transactional(readOnly = true)
    public MontagemSoftMaquinasDTO findById(Long id) {
        Optional<MontagemSoftMaquinas> obj = repository.findById(id);
        MontagemSoftMaquinas entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new MontagemSoftMaquinasDTO(entity);
    }


}