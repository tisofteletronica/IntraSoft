package com.softeletronica.intrasoft.services;

import com.softeletronica.intrasoft.dto.primary.DepartmentDTO;
import com.softeletronica.intrasoft.dto.primary.UserDTO;
import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.primary.Department;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import com.softeletronica.intrasoft.repositories.primary.DepartmentRepository;
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
public class DepartmentService {
    @Autowired
    private DepartmentRepository repository;
    @Autowired
    private UserService userService;
    @Autowired
    private AuditoriaRepository auditoriaRepository;
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
    @Transactional
    public DepartmentDTO insert(DepartmentDTO dto) {
        Department entity = new Department();
        copyDtoToEntity(dto, entity);
        salvarAuditoria("Departamento Adicionado " + entity.getName());

        return new DepartmentDTO(entity);
    }
    @Transactional
    public DepartmentDTO  update(Long id, DepartmentDTO dto) {
        try {
            Department entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            copyDtoToEntity(dto, entity);

            entity = repository.save(entity);
            salvarAuditoria("Departamento Atualizado " + entity.getName());
            return new DepartmentDTO(entity);
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
            Department entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            repository.deleteById(id);
            salvarAuditoria("Departamento Deletado " + entity.getName());
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(DepartmentDTO dto, Department entity) {
       entity.setName(dto.getName());
       entity.setImgUrl(dto.getImgUrl());
       entity.setActive(dto.getActive());

    }
    private void salvarAuditoria(String objeto) {
        // Obtendo usuário autenticado
        UserDTO usuarioAutenticado = userService.getMe();

        // Criando e salvando auditoria
        Auditoria auditoria = new Auditoria();
        auditoria.setCreated(Instant.now());
        auditoria.setObjeto(objeto);
        auditoria.setUsuario(usuarioAutenticado.getEmail());

        auditoriaRepository.save(auditoria);
    }

}
