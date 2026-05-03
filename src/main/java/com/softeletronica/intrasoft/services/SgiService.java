package com.softeletronica.intrasoft.services;

import com.softeletronica.intrasoft.dto.primary.UserDTO;
import com.softeletronica.intrasoft.dto.secondary.SgiDTO;
import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.secondary.Sgi;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import com.softeletronica.intrasoft.repositories.secondary.SgiRepository;
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
public class SgiService {

    @Autowired
    private SgiRepository repository;
    @Autowired
    private UserService userService;
    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Transactional(readOnly = true)
    public Page<SgiDTO> findAll(Pageable pageable) {
        Page<Sgi> list = repository.findAll(pageable);
        return list.map(x -> new SgiDTO(x));
    }

    @Transactional(readOnly = true)
    public SgiDTO findById(Long id) {
        Optional<Sgi> obj = repository.findById(id);
        Sgi entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new SgiDTO(entity);
    }

    @Transactional
    public SgiDTO insert(SgiDTO dto) {
        Sgi entity = new Sgi();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        salvarAuditoria("Iso Soft Adicionado " + entity.getId());


        return new SgiDTO(entity);
    }
    @Transactional
    public SgiDTO update(Long id, SgiDTO dto) {
        try {
            Sgi entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            copyDtoToEntity(dto, entity);

            entity = repository.save(entity);
            salvarAuditoria("Led Soft Atualizado " + entity.getId());
            return new SgiDTO(entity);
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
            Sgi entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            repository.deleteById(id);
            salvarAuditoria("Led Soft Deletado " + entity.getId());
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
    private void copyDtoToEntity(SgiDTO dto, Sgi entity) {
        entity.setFrase1(dto.getFrase1());
        entity.setFrase2(dto.getFrase2());
        entity.setFrase3(dto.getFrase3());


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