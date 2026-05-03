package com.softeletronica.intrasoft.services;

import com.softeletronica.intrasoft.dto.primary.UserDTO;
import com.softeletronica.intrasoft.dto.secondary.SobreNosLinhaTempoSoftDTO;

import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.secondary.SobreNosLinhaTempoSoft;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import com.softeletronica.intrasoft.repositories.secondary.SobreNosLinhaTempoSoftRepository;
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
public class SobreNosLinhaTempoSoftService {

    @Autowired
    private SobreNosLinhaTempoSoftRepository repository;
    @Autowired
    private UserService userService;
    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Transactional(readOnly = true)
    public Page<SobreNosLinhaTempoSoftDTO> findAll(Pageable pageable) {
        Page<SobreNosLinhaTempoSoft> list = repository.findAll(pageable);
        return list.map(x -> new SobreNosLinhaTempoSoftDTO(x));
    }

    @Transactional(readOnly = true)
    public SobreNosLinhaTempoSoftDTO findById(Long id) {
        Optional<SobreNosLinhaTempoSoft> obj = repository.findById(id);
        SobreNosLinhaTempoSoft entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new SobreNosLinhaTempoSoftDTO(entity);
    }
    @Transactional
    public SobreNosLinhaTempoSoftDTO insert(SobreNosLinhaTempoSoftDTO dto) {
        SobreNosLinhaTempoSoft entity = new SobreNosLinhaTempoSoft();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);

        salvarAuditoria("Linha Tempo Adicionado " + entity.getId());

        return new SobreNosLinhaTempoSoftDTO(entity);
    }

    @Transactional
    public SobreNosLinhaTempoSoftDTO  update(Long id, SobreNosLinhaTempoSoftDTO dto) {
        try {
            SobreNosLinhaTempoSoft entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            copyDtoToEntity(dto, entity);

            entity = repository.save(entity);
            salvarAuditoria("Linha Tempo Atualizado " + entity.getId());
            return new SobreNosLinhaTempoSoftDTO(entity);
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
            SobreNosLinhaTempoSoft entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            repository.deleteById(id);
            salvarAuditoria("Linha Tempo Deletado " + entity.getId());
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
    private void copyDtoToEntity(SobreNosLinhaTempoSoftDTO dto, SobreNosLinhaTempoSoft entity) {
        entity.setAnos(dto.getAnos());
        entity.setHistorico(dto.getHistorico());

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