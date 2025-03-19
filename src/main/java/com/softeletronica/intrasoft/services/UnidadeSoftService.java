package com.softeletronica.intrasoft.services;


import com.apisoft.dto.UnidadeSoftDTO;
import com.apisoft.entities.UnidadeSoft;
import com.apisoft.repositories.UnidadeSoftRepository;
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
public class UnidadeSoftService {

    @Autowired
    private UnidadeSoftRepository repository;

    @Transactional(readOnly = true)
    public Page<UnidadeSoftDTO> findAll(Pageable pageable) {
        Page<UnidadeSoft> list = repository.findAll(pageable);
        return list.map(x -> new UnidadeSoftDTO(x));
    }

    @Transactional(readOnly = true)
    public UnidadeSoftDTO findById(Long id) {
        Optional<UnidadeSoft> obj = repository.findById(id);
        UnidadeSoft entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new UnidadeSoftDTO(entity);
    }

    @Transactional
    public UnidadeSoftDTO insert(UnidadeSoftDTO dto) {
        UnidadeSoft entity = new UnidadeSoft();
        copyDtoToEntity(dto, entity);
        entity.setCreatedAt(Instant.now());
        entity.setUpdateAt(Instant.now());
        entity = repository.save(entity);
        return new UnidadeSoftDTO(entity);
    }

    @Transactional
    public UnidadeSoftDTO update(Long id, UnidadeSoftDTO dto) {
        try {
            UnidadeSoft entity = repository.getReferenceById(id);
            updateDtoToEntity(dto, entity);
            entity.setUpdateAt(Instant.now());
            entity = repository.save(entity);
            return new UnidadeSoftDTO(entity);
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

    private void copyDtoToEntity(UnidadeSoftDTO dto, UnidadeSoft entity) {
        entity.setDescription(dto.getDescription());
        entity.setAddress(dto.getAddress());
        entity.setAddress(dto.getAddress());
        entity.setNumber(dto.getNumber());
        entity.setComplement(dto.getComplement());
        entity.setCity(dto.getCity());
        entity.setNeighborhood(dto.getNeighborhood());
        entity.setUf(dto.getUf());
        entity.setCountry(dto.getCountry());
        entity.setCep(dto.getCep());
        entity.setPhone1(dto.getPhone1());
        entity.setPhone2(dto.getPhone2());
        entity.setPhone3(dto.getPhone3());
        entity.setImgUrl1(dto.getImgUrl1());
        entity.setImgUrl2(dto.getImgUrl2());
        entity.setImgUrl3(dto.getImgUrl3());
        entity.setImgUrl4(dto.getImgUrl4());
        entity.setImgUrl5(dto.getImgUrl5());
        entity.setImgUrl6(dto.getImgUrl6());
        entity.setImgUrl7(dto.getImgUrl7());
        entity.setImgUrl8(dto.getImgUrl8());
        entity.setImgUrl9(dto.getImgUrl9());
        entity.setImgUrl10(dto.getImgUrl10());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdateAt(dto.getUpdateAt());
        entity.setActive(dto.getActive());
    }

    private void updateDtoToEntity(UnidadeSoftDTO dto, UnidadeSoft entity) {
        entity.setDescription(dto.getDescription());
        entity.setAddress(dto.getAddress());
        entity.setAddress(dto.getAddress());
        entity.setNumber(dto.getNumber());
        entity.setComplement(dto.getComplement());
        entity.setCity(dto.getCity());
        entity.setNeighborhood(dto.getNeighborhood());
        entity.setUf(dto.getUf());
        entity.setCountry(dto.getCountry());
        entity.setCep(dto.getCep());
        entity.setPhone1(dto.getPhone1());
        entity.setPhone2(dto.getPhone2());
        entity.setPhone3(dto.getPhone3());
        entity.setImgUrl1(dto.getImgUrl1());
        entity.setImgUrl2(dto.getImgUrl2());
        entity.setImgUrl3(dto.getImgUrl3());
        entity.setImgUrl4(dto.getImgUrl4());
        entity.setImgUrl5(dto.getImgUrl5());
        entity.setImgUrl6(dto.getImgUrl6());
        entity.setImgUrl7(dto.getImgUrl7());
        entity.setImgUrl8(dto.getImgUrl8());
        entity.setImgUrl9(dto.getImgUrl9());
        entity.setImgUrl10(dto.getImgUrl10());
        entity.setUpdateAt(dto.getUpdateAt());
        entity.setActive(dto.getActive());
    }
}