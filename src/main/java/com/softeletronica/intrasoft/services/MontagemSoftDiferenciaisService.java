package com.softeletronica.intrasoft.services;

import com.softeletronica.intrasoft.dto.primary.UserDTO;
import com.softeletronica.intrasoft.dto.secondary.MontagemSoftDiferenciaisDTO;
import com.softeletronica.intrasoft.dto.secondary.MontagemSoftDiferenciaisDTO;
import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.secondary.MontagemSoftDiferenciais;
import com.softeletronica.intrasoft.entities.secondary.MontagemSoftDiferenciais;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import com.softeletronica.intrasoft.repositories.secondary.MontagemSoftDiferenciaisRepository;
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
public class MontagemSoftDiferenciaisService {

    @Autowired
    private MontagemSoftDiferenciaisRepository repository;
    @Autowired
    private UserService userService;
    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Transactional(readOnly = true)
    public Page<MontagemSoftDiferenciaisDTO> findAll(Pageable pageable) {
        Page<MontagemSoftDiferenciais> list = repository.findAll(pageable);
        return list.map(x -> new MontagemSoftDiferenciaisDTO(x));
    }

    @Transactional(readOnly = true)
    public MontagemSoftDiferenciaisDTO findById(Long id) {
        Optional<MontagemSoftDiferenciais> obj = repository.findById(id);
        MontagemSoftDiferenciais entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new MontagemSoftDiferenciaisDTO(entity);
    }
    @Transactional
    public MontagemSoftDiferenciaisDTO insert(MontagemSoftDiferenciaisDTO dto) {
        MontagemSoftDiferenciais entity = new MontagemSoftDiferenciais();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        salvarAuditoria("Montagem Soft Diferencial Adicionado " + entity.getId());

        return new MontagemSoftDiferenciaisDTO(entity);
    }

    @Transactional
    public MontagemSoftDiferenciaisDTO  update(Long id, MontagemSoftDiferenciaisDTO dto) {
        try {
            MontagemSoftDiferenciais entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            copyDtoToEntity(dto, entity);

            entity = repository.save(entity);
            salvarAuditoria("Montagem Soft Diferencial Atualizado " + entity.getId());
            return new MontagemSoftDiferenciaisDTO(entity);
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
            MontagemSoftDiferenciais entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            repository.deleteById(id);
            salvarAuditoria("Montagem Soft Diferencial Deletado " + entity.getId());
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
    private void copyDtoToEntity(MontagemSoftDiferenciaisDTO dto, MontagemSoftDiferenciais entity) {
        entity.setDiferencial(dto.getDiferencial());
        entity.setDescricao(dto.getDescricao());
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