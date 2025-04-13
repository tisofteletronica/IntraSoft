package com.softeletronica.intrasoft.services;

import com.softeletronica.intrasoft.dto.primary.UnidadesSoftDTO;
import com.softeletronica.intrasoft.dto.primary.UserDTO;

import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.primary.UnidadesSoft;

import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import com.softeletronica.intrasoft.repositories.primary.UnidadeSoftRepository;
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
public class UnidadesSoftService {
    @Autowired
    private UnidadeSoftRepository repository;
    @Autowired
    private UserService userService;
    @Autowired
    private AuditoriaRepository auditoriaRepository;
    @Transactional(readOnly = true)
    public Page<UnidadesSoftDTO>findAllPaged(Pageable pageable) {
        Page<UnidadesSoft> list = repository.findAll(pageable);
        return list.map(x-> new UnidadesSoftDTO(x));
    }

    @Transactional(readOnly = true)
    public UnidadesSoftDTO findById(Long id) {
        Optional<UnidadesSoft> obj = repository.findById(id);
        UnidadesSoft entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new UnidadesSoftDTO(entity);
    }
    @Transactional
    public UnidadesSoftDTO insert(UnidadesSoftDTO dto) {
        UnidadesSoft entity = new UnidadesSoft();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        salvarAuditoria("Unidade Soft Assinatura Adicionado " + entity.getName());

        return new UnidadesSoftDTO(entity);
    }

    @Transactional
    public UnidadesSoftDTO  update(Long id, UnidadesSoftDTO dto) {
        try {
            UnidadesSoft entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            copyDtoToEntity(dto, entity);

            entity = repository.save(entity);
            salvarAuditoria("Unidade Soft Assinatura Atualizado " + entity.getName());
            return new UnidadesSoftDTO(entity);
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
            UnidadesSoft entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            repository.deleteById(id);
            salvarAuditoria("Unidade Soft Assinatura Deletado " + entity.getName());
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
    private void copyDtoToEntity(UnidadesSoftDTO dto, UnidadesSoft entity) {
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setCity(dto.getCity());
        entity.setUf(dto.getUf());
        entity.setNeighborhood(dto.getNeighborhood());
        entity.setCep(dto.getCep());
        entity.setPhone1(dto.getPhone1());
        entity.setPhone2(dto.getPhone2());

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
