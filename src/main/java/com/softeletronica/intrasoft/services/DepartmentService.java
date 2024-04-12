package com.softeletronica.intrasoft.services;

import com.softeletronica.intrasoft.dto.DepartmentDTO;
import com.softeletronica.intrasoft.entities.Department;
import com.softeletronica.intrasoft.repositories.DepartmentRepository;
import com.softeletronica.intrasoft.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository repository;
    @Transactional(readOnly = true)
    public Page<DepartmentDTO>findAllPaged(Pageable pageable) {
        Page<Department> list = repository.findAll(pageable);
        return list.map(x-> new DepartmentDTO(x));
    }

    @Transactional(readOnly = true)
    public DepartmentDTO findById(Long id) {
        Optional<Department> obj = repository.findById(id);
        Department entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new DepartmentDTO(entity);
    }

}
