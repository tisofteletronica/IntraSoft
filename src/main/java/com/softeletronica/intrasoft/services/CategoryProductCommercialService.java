package com.softeletronica.intrasoft.services;

import com.softeletronica.intrasoft.dto.primary.UserDTO;
import com.softeletronica.intrasoft.dto.secondary.CategoryProductCommercialDTO;
import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.secondary.CategoryProductCommercial;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import com.softeletronica.intrasoft.repositories.secondary.CategoryProductCommercialRepository;
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
public class CategoryProductCommercialService {
    @Autowired
    private CategoryProductCommercialRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Transactional(readOnly = true)
    public Page<CategoryProductCommercialDTO> findAll(Pageable pageable) {
        Page<CategoryProductCommercial> list = repository.findAll(pageable);
        return list.map(x -> new CategoryProductCommercialDTO(x));
    }

    @Transactional(readOnly = true)
    public CategoryProductCommercialDTO findById(Long id) {
        Optional<CategoryProductCommercial> obj = repository.findById(id);
        CategoryProductCommercial entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new CategoryProductCommercialDTO(entity);
    }


    @Transactional
    public CategoryProductCommercialDTO insert(CategoryProductCommercialDTO dto) {
        CategoryProductCommercial entity = new CategoryProductCommercial();
        copyDtoToEntity(dto, entity);
        entity.setCreatedAt(Instant.now());
        entity.setUpdateAt(Instant.now());
        entity = repository.save(entity);
        // Criando registro de auditoria
        salvarAuditoria("Categoria Comercial Adicionada " + entity.getName());

        return new CategoryProductCommercialDTO(entity);
    }

    @Transactional
    public CategoryProductCommercialDTO update(Long id, CategoryProductCommercialDTO dto) {
        try {
            CategoryProductCommercial entity = repository.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Id not found " + id));
            updateDtoToEntity(dto, entity);
            entity.setUpdateAt(Instant.now());
            entity = repository.save(entity);
            salvarAuditoria("Categoria Comercial Atualizada " + entity.getName());

            return new CategoryProductCommercialDTO(entity);
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
            CategoryProductCommercial entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));

            repository.deleteById(id);
            salvarAuditoria("Categoria Comercial Deletada " + entity.getName());

        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(CategoryProductCommercialDTO dto, CategoryProductCommercial entity) {
        entity.setName(dto.getName());
        entity.setImgUrl(dto.getImgUrl());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdateAt(dto.getUpdateAt());
        entity.setActive(dto.getActive());
    }

    private void updateDtoToEntity(CategoryProductCommercialDTO dto, CategoryProductCommercial entity) {
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
