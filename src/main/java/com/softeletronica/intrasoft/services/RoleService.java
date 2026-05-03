package com.softeletronica.intrasoft.services;

import com.softeletronica.intrasoft.dto.primary.RoleDTO;
import com.softeletronica.intrasoft.entities.primary.Role;
import com.softeletronica.intrasoft.repositories.primary.RoleRepository;
import com.softeletronica.intrasoft.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repository;

    @Transactional(readOnly = true)
    public Page<RoleDTO>findAllPaged(Pageable pageable) {
        Page<Role>list = repository.findAll(pageable);
        return list.map(x-> new RoleDTO(x));
    }
    @Transactional(readOnly = true)
    public RoleDTO findById(Long id) {
        Optional<Role> obj = repository.findById(id);
        Role entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new RoleDTO(entity);
    }

}
