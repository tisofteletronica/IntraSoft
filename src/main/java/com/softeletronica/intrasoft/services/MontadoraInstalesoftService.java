package com.softeletronica.intrasoft.services;



import com.softeletronica.intrasoft.dto.primary.UserDTO;
import com.softeletronica.intrasoft.dto.secondary.MontadoraInstalesoftDTO;
import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.secondary.MontadoraInstalesoft;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import com.softeletronica.intrasoft.repositories.secondary.MontadoraInstalesoftRepository;
import com.softeletronica.intrasoft.services.exceptions.DatabaseException;
import com.softeletronica.intrasoft.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class MontadoraInstalesoftService {

    @Autowired
    private MontadoraInstalesoftRepository repository;

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public List<MontadoraInstalesoftDTO> findAll() {
        List<MontadoraInstalesoft> list = repository.byName();
        return list.stream().map(x -> new MontadoraInstalesoftDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MontadoraInstalesoftDTO findById(Long id) {
        Optional<MontadoraInstalesoft> obj = repository.findById(id);
        MontadoraInstalesoft entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new MontadoraInstalesoftDTO(entity);
    }

    @Transactional
    public MontadoraInstalesoftDTO insert(MontadoraInstalesoftDTO dto) {
        MontadoraInstalesoft entity = new MontadoraInstalesoft();
        copyDtoToEntity(dto, entity);
        entity.setCreatedAt(Instant.now());
        entity.setUpdateAt(Instant.now());
        entity = repository.save(entity);

        // Criando registro de auditoria
        salvarAuditoria("Montadora Adicionada " + entity.getName());

        return new MontadoraInstalesoftDTO(entity);
    }

    @Transactional
    public MontadoraInstalesoftDTO update(Long id, MontadoraInstalesoftDTO dto) {
        try {
            MontadoraInstalesoft entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));

            updateDtoToEntity(dto, entity);
            entity.setUpdateAt(Instant.now());
            entity = repository.save(entity);

            salvarAuditoria("Montadora Atualizada " + entity.getName());
            return new MontadoraInstalesoftDTO(entity);
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
            // Buscar a entidade antes da exclusão para registrar na auditoria
            MontadoraInstalesoft entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));

            repository.deleteById(id);
            salvarAuditoria("Montadora Deletada " + entity.getName());

        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }


    private void copyDtoToEntity(MontadoraInstalesoftDTO dto, MontadoraInstalesoft entity) {
        entity.setName(dto.getName());
        entity.setUrlImg(dto.getUrlImg());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdateAt(dto.getUpdateAt());
        entity.setActive(dto.getActive());

    }

    private void updateDtoToEntity(MontadoraInstalesoftDTO dto, MontadoraInstalesoft entity) {
        entity.setName(dto.getName());
        entity.setUrlImg(dto.getUrlImg());
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