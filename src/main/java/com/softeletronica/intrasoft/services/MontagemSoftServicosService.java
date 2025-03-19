package com.softeletronica.intrasoft.services;


import com.apisoft.dto.MontagemSoftServicosDTO;
import com.apisoft.entities.MontagemSoftServicos;
import com.apisoft.repositories.MontagemSoftServicosRepository;
import com.apisoft.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class MontagemSoftServicosService {

    @Autowired
    private MontagemSoftServicosRepository repository;

    @Transactional(readOnly = true)
    public Page<MontagemSoftServicosDTO> findAll(Pageable pageable) {
        Page<MontagemSoftServicos> list = repository.findAll(pageable);
        return list.map(x -> new MontagemSoftServicosDTO(x));
    }

    @Transactional(readOnly = true)
    public MontagemSoftServicosDTO findById(Long id) {
        Optional<MontagemSoftServicos> obj = repository.findById(id);
        MontagemSoftServicos entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new MontagemSoftServicosDTO(entity);
    }


}