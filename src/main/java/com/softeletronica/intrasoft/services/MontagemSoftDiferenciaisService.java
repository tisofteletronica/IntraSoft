package com.softeletronica.intrasoft.services;


import com.apisoft.dto.MontagemSoftDiferenciaisDTO;
import com.apisoft.entities.MontagemSoftDiferenciais;
import com.apisoft.repositories.MontagemSoftDiferenciaisRepository;
import com.apisoft.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class MontagemSoftDiferenciaisService {

    @Autowired
    private MontagemSoftDiferenciaisRepository repository;

    @Transactional(readOnly = true)
    public Page<MontagemSoftDiferenciaisDTO> findAll(Pageable pageable) {
        Page<MontagemSoftDiferenciais> list = repository.findAll(pageable);
        return list.map(x -> new MontagemSoftDiferenciaisDTO(x));
    }

    @Transactional(readOnly = true)
    public MontagemSoftDiferenciaisDTO findById(Long id) {
        Optional<MontagemSoftDiferenciais> obj = repository.findById(id);
        MontagemSoftDiferenciais entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new MontagemSoftDiferenciaisDTO(entity);
    }


}