package com.softeletronica.intrasoft.services;


import com.apisoft.dto.RepresentanteSoftDTO;
import com.apisoft.entities.RepresentanteSoft;
import com.apisoft.repositories.RepresentanteSoftRepository;
import com.apisoft.services.exceptions.DatabaseException;
import com.apisoft.services.exceptions.ResourceNotFoundException;
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
public class RepresentanteSoftService {

    @Autowired
    private RepresentanteSoftRepository repository;

    @Transactional(readOnly = true)
    public Page<RepresentanteSoftDTO> findAll(Pageable pageable) {
        Page<RepresentanteSoft> list = repository.findAll(pageable);
        return list.map(x -> new RepresentanteSoftDTO(x));
    }

    @Transactional(readOnly = true)
    public RepresentanteSoftDTO findById(Long id) {
        Optional<RepresentanteSoft> obj = repository.findById(id);
        RepresentanteSoft entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new RepresentanteSoftDTO(entity);
    }

    @Transactional
    public RepresentanteSoftDTO insert(RepresentanteSoftDTO dto) {
        RepresentanteSoft entity = new RepresentanteSoft();
        copyDtoToEntity(dto, entity);
        entity.setCreateAt(Instant.now());
        entity.setUpdateAt(Instant.now());
        entity = repository.save(entity);
        return new RepresentanteSoftDTO(entity);
    }

    @Transactional
    public RepresentanteSoftDTO update(Long id, RepresentanteSoftDTO dto) {
        try {
            RepresentanteSoft entity = repository.getReferenceById(id);
            updateDtoToEntity(dto, entity);
            entity.setUpdateAt(Instant.now());
            entity = repository.save(entity);
            return new RepresentanteSoftDTO(entity);
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

    private void copyDtoToEntity(RepresentanteSoftDTO dto, RepresentanteSoft entity) {
        entity.setRepresentante(dto.getRepresentante());
        entity.setEstadosRepresentantes(dto.getEstadosRepresentantes());
        entity.setWhatsapp(dto.getWhatsapp());
        entity.setPhone1(dto.getPhone1());
        entity.setPhone2(dto.getPhone2());
        entity.setPhone3(dto.getPhone3());
        entity.setContato(dto.getContato());
        entity.setCreateAt(dto.getCreateAt());
        entity.setUpdateAt(dto.getUpdateAt());
        entity.setEmail(dto.getEmail());
        entity.setActive(dto.getActive());
    }

    private void updateDtoToEntity(RepresentanteSoftDTO dto, RepresentanteSoft entity) {
        entity.setRepresentante(dto.getRepresentante());
        entity.setEstadosRepresentantes(dto.getEstadosRepresentantes());
        entity.setWhatsapp(dto.getWhatsapp());
        entity.setPhone1(dto.getPhone1());
        entity.setPhone2(dto.getPhone2());
        entity.setPhone3(dto.getPhone3());
        entity.setContato(dto.getContato());
        entity.setUpdateAt(dto.getUpdateAt());
        entity.setEmail(dto.getEmail());
        entity.setActive(dto.getActive());
    }
}