package com.softeletronica.intrasoft.services;


import com.softeletronica.intrasoft.dto.primary.UserDTO;
import com.softeletronica.intrasoft.dto.secondary.ConectividadeSoftDTO;
import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.secondary.ConectividadeSoft;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import com.softeletronica.intrasoft.repositories.secondary.ConectividadeSoftRepository;
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
public class ConectividadeSoftService {

    @Autowired
    private ConectividadeSoftRepository repository;
    @Autowired
    private UserService userService;
    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Transactional(readOnly = true)
    public Page<ConectividadeSoftDTO> findAll(Pageable pageable) {
        Page<ConectividadeSoft> list = repository.findAll(pageable);
        return list.map(x -> new ConectividadeSoftDTO(x));
    }

    @Transactional(readOnly = true)
    public ConectividadeSoftDTO findById(Long id) {
        Optional<ConectividadeSoft> obj = repository.findById(id);
        ConectividadeSoft entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new ConectividadeSoftDTO(entity);
    }

    @Transactional
    public ConectividadeSoftDTO insert(ConectividadeSoftDTO dto) {
        ConectividadeSoft entity = new ConectividadeSoft();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);

        salvarAuditoria("Conectividade BLE Adicionado " + entity.getId());

        return new ConectividadeSoftDTO(entity);
    }

    @Transactional
    public ConectividadeSoftDTO  update(Long id, ConectividadeSoftDTO dto) {
        try {
            ConectividadeSoft entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            copyDtoToEntity(dto, entity);

            entity = repository.save(entity);
            salvarAuditoria("Conectividade BLE Atualizado " + entity.getId());
            return new ConectividadeSoftDTO(entity);
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
            ConectividadeSoft entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            repository.deleteById(id);
            salvarAuditoria("Conectividade BLE Deletado " + entity.getId());
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
    private void copyDtoToEntity(ConectividadeSoftDTO dto, ConectividadeSoft entity) {
        entity.setDescricao(dto.getDescricao());
        entity.setSistemasConexaoBle(dto.getSistemasConexaoBle());
        entity.setAplicacoes(dto.getAplicacoes());
        entity.setAnatel(dto.getAnatel());
        entity.setUrlImg1(dto.getUrlImg1());
        entity.setUrlImg2(dto.getUrlImg2());
        entity.setUrlImg3(dto.getUrlImg3());

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