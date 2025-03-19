package com.softeletronica.intrasoft.services;


import com.softeletronica.intrasoft.dto.secondary.ContatoSoftDTO;
import com.softeletronica.intrasoft.entities.secondary.ContatoSoft;
import com.softeletronica.intrasoft.repositories.secondary.ContatoSoftRepository;
import com.softeletronica.intrasoft.services.exceptions.DatabaseException;
import com.softeletronica.intrasoft.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;


@Service
public class ContatoSoftService {

    @Autowired
    private ContatoSoftRepository repository;

    @Transactional(readOnly = true)
    public Page<ContatoSoftDTO> findAll(Pageable pageable) {
        Page<ContatoSoft> list = repository.findAll(pageable);
        return list.map(x -> new ContatoSoftDTO(x));
    }

    @Transactional(readOnly = true)
    public ContatoSoftDTO findById(Long id) {
        Optional<ContatoSoft> obj = repository.findById(id);
        ContatoSoft entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new ContatoSoftDTO(entity);
    }

    @Transactional
    public ContatoSoftDTO insert(ContatoSoftDTO dto) {
        ContatoSoft entity = new ContatoSoft();
        copyDtoToEntity(dto, entity);
        entity.setCreateAt(Instant.now());
        entity.setUpdateAt(Instant.now());
        entity = repository.save(entity);
        return new ContatoSoftDTO(entity);
    }

    @Transactional
    public ContatoSoftDTO update(Long id, ContatoSoftDTO dto) {
        try {
            ContatoSoft entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            copyDtoToEntity(dto, entity);
            entity.setUpdateAt(Instant.now());
            entity = repository.save(entity);
            return new ContatoSoftDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(ContatoSoftDTO dto, ContatoSoft entity) {
        entity.setSetor(dto.getSetor());
        entity.setWhatsapp(dto.getWhatsapp());
        entity.setPhone1(dto.getPhone1());
        entity.setPhone2(dto.getPhone2());
        entity.setPhone3(dto.getPhone3());
        entity.setCreateAt(dto.getCreateAt());
        entity.setUpdateAt(dto.getUpdateAt());
        entity.setEmail(dto.getEmail());
        entity.setActive(dto.getActive());
    }

    private void updateDtoToEntity(ContatoSoftDTO dto, ContatoSoft entity) {
        entity.setSetor(dto.getSetor());
        entity.setWhatsapp(dto.getWhatsapp());
        entity.setPhone1(dto.getPhone1());
        entity.setPhone2(dto.getPhone2());
        entity.setPhone3(dto.getPhone3());
        entity.setUpdateAt(dto.getUpdateAt());
        entity.setEmail(dto.getEmail());
        entity.setActive(dto.getActive());
    }
}