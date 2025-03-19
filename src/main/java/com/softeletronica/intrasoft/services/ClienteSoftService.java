package com.softeletronica.intrasoft.services;


import com.apisoft.dto.ClienteSoftDTO;
import com.apisoft.entities.ClienteSoft;
import com.apisoft.repositories.ClienteSoftRepository;
import com.apisoft.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ClienteSoftService {

    @Autowired
    private ClienteSoftRepository repository;

    @Transactional(readOnly = true)
    public Page<ClienteSoftDTO> findAll(Pageable pageable) {
        Page<ClienteSoft> list = repository.findAll(pageable);
        return list.map(x -> new ClienteSoftDTO(x));
    }

    @Transactional(readOnly = true)
    public ClienteSoftDTO findById(Long id) {
        Optional<ClienteSoft> obj = repository.findById(id);
        ClienteSoft entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new ClienteSoftDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<ClienteSoftDTO> findUfOrCity(String uf, String cidade) {
        List<ClienteSoft> list = repository.filterUForCity(uf, cidade);
        return list.stream().map(x-> new ClienteSoftDTO(x)).collect(Collectors.toList());
    }
}