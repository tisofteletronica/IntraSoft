package com.softeletronica.intrasoft.services;

import com.softeletronica.intrasoft.dto.primary.UserDTO;
import com.softeletronica.intrasoft.dto.secondary.SetoresAtendimentoSoftDTO;
import com.softeletronica.intrasoft.dto.secondary.SetoresAtendimentoSoftDTO;
import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.secondary.SetoresAtendimentoSoft;
import com.softeletronica.intrasoft.entities.secondary.SetoresAtendimentoSoft;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import com.softeletronica.intrasoft.repositories.secondary.SetoresAtendimentoSoftRepository;
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
public class SetoresAtedimentoSoftService {

    @Autowired
    private SetoresAtendimentoSoftRepository repository;
    @Autowired
    private UserService userService;
    @Autowired
    private AuditoriaRepository auditoriaRepository;


    @Transactional(readOnly = true)
    public Page<SetoresAtendimentoSoftDTO> findAll(Pageable pageable) {
        Page<SetoresAtendimentoSoft> list = repository.findAll(pageable);
        return list.map(x -> new SetoresAtendimentoSoftDTO(x));
    }

    @Transactional(readOnly = true)
    public SetoresAtendimentoSoftDTO findById(Long id) {
        Optional<SetoresAtendimentoSoft> obj = repository.findById(id);
        SetoresAtendimentoSoft entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new SetoresAtendimentoSoftDTO(entity);
    }
    @Transactional
    public SetoresAtendimentoSoftDTO insert(SetoresAtendimentoSoftDTO dto) {
        SetoresAtendimentoSoft entity = new SetoresAtendimentoSoft();
        copyDtoToEntity(dto, entity);
        entity.setCreateAt(Instant.now());
        entity.setUpdateAt(Instant.now());
        entity = repository.save(entity);

        salvarAuditoria("Setores Atendimento Adicionado " + entity.getId());

        return new SetoresAtendimentoSoftDTO(entity);
    }

    @Transactional
    public SetoresAtendimentoSoftDTO  update(Long id, SetoresAtendimentoSoftDTO dto) {
        try {
            SetoresAtendimentoSoft entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            copyDtoToEntity(dto, entity);
            entity.setUpdateAt(Instant.now());
            entity = repository.save(entity);

            salvarAuditoria("Setores Atendimento Atualizado " + entity.getId());
            return new SetoresAtendimentoSoftDTO(entity);
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
            SetoresAtendimentoSoft entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            repository.deleteById(id);
            salvarAuditoria("Setores Atendimento Deletado " + entity.getId());
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
    private void copyDtoToEntity(SetoresAtendimentoSoftDTO dto, SetoresAtendimentoSoft entity) {
        entity.setDescricao(dto.getDescricao());
        entity.setImg_url(dto.getImg_url());
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