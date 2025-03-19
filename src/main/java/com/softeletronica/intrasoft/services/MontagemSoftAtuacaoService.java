package com.softeletronica.intrasoft.services;


import com.apisoft.dto.MontagemSoftAtuacaoDTO;
import com.apisoft.entities.MontagemSoftAtuacao;
import com.apisoft.repositories.MontagemSoftAtuacaoRepository;
import com.apisoft.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class MontagemSoftAtuacaoService {

    @Autowired
    private MontagemSoftAtuacaoRepository repository;

    @Transactional(readOnly = true)
    public Page<MontagemSoftAtuacaoDTO> findAll(Pageable pageable) {
        Page<MontagemSoftAtuacao> list = repository.findAll(pageable);
        return list.map(x -> new MontagemSoftAtuacaoDTO(x));
    }

    @Transactional(readOnly = true)
    public MontagemSoftAtuacaoDTO findById(Long id) {
        Optional<MontagemSoftAtuacao> obj = repository.findById(id);
        MontagemSoftAtuacao entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new MontagemSoftAtuacaoDTO(entity);
    }


}