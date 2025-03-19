package com.softeletronica.intrasoft.services;

import com.softeletronica.intrasoft.dto.primary.UserDTO;
import com.softeletronica.intrasoft.dto.secondary.CategoryProductInstaleSoftDTO;
import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.secondary.CategoryProductInstaleSoft;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import com.softeletronica.intrasoft.repositories.secondary.CategoryProductInstaleSoftRepository;
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
public class CategoryProductInstaleSoftService {
    @Autowired
    private CategoryProductInstaleSoftRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Transactional(readOnly = true)
    public Page<CategoryProductInstaleSoftDTO> findAll(Pageable pageable) {
        Page<CategoryProductInstaleSoft> list = repository.findAll(pageable);
        return list.map(x -> new CategoryProductInstaleSoftDTO(x));
    }

    @Transactional(readOnly = true)
    public CategoryProductInstaleSoftDTO findById(Long id) {
        Optional<CategoryProductInstaleSoft> obj = repository.findById(id);
        CategoryProductInstaleSoft entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new CategoryProductInstaleSoftDTO(entity);
    }


    @Transactional
    public CategoryProductInstaleSoftDTO insert(CategoryProductInstaleSoftDTO dto) {
        CategoryProductInstaleSoft entity = new CategoryProductInstaleSoft();
        copyDtoToEntity(dto, entity);
        entity.setCreatedAt(Instant.now());
        entity.setUpdateAt(Instant.now());
        entity = repository.save(entity);
        // Criando registro de auditoria
        salvarAuditoria("Categoria InstaleSoft Adicionada " + entity.getName());

        return new CategoryProductInstaleSoftDTO(entity);
    }

    @Transactional
    public CategoryProductInstaleSoftDTO update(Long id, CategoryProductInstaleSoftDTO dto) {
        try {
            CategoryProductInstaleSoft entity = repository.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Id not found " + id));
            updateDtoToEntity(dto, entity);
            entity.setUpdateAt(Instant.now());
            entity = repository.save(entity);
            salvarAuditoria("Categoria InstaleSoft Atualizada " + entity.getName());

            return new CategoryProductInstaleSoftDTO(entity);
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
            CategoryProductInstaleSoft entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));

            repository.deleteById(id);
            salvarAuditoria("Categoria InstaleSoft Deletada " + entity.getName());

        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(CategoryProductInstaleSoftDTO dto, CategoryProductInstaleSoft entity) {
        entity.setName(dto.getName());
        entity.setImgUrl(dto.getImgUrl());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdateAt(dto.getUpdateAt());
        entity.setActive(dto.getActive());
    }

    private void updateDtoToEntity(CategoryProductInstaleSoftDTO dto, CategoryProductInstaleSoft entity) {
        entity.setName(dto.getName());
        entity.setImgUrl(dto.getImgUrl());
        entity.setUpdateAt(dto.getUpdateAt());
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
