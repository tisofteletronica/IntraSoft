package com.softeletronica.intrasoft.services;



import com.softeletronica.intrasoft.dto.primary.UserDTO;
import com.softeletronica.intrasoft.dto.secondary.SobreNosSoftDTO;
import com.softeletronica.intrasoft.dto.secondary.SobreNosSoftDTO;
import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.secondary.SobreNosSoft;
import com.softeletronica.intrasoft.entities.secondary.SobreNosSoft;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import com.softeletronica.intrasoft.repositories.secondary.SobreNosSoftRepository;
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
public class SobreNosSoftService {

    @Autowired
    private SobreNosSoftRepository repository;
    @Autowired
    private UserService userService;
    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Transactional(readOnly = true)
    public Page<SobreNosSoftDTO> findAll(Pageable pageable) {
        Page<SobreNosSoft> list = repository.findAll(pageable);
        return list.map(x -> new SobreNosSoftDTO(x));
    }

    @Transactional(readOnly = true)
    public SobreNosSoftDTO findById(Long id) {
        Optional<SobreNosSoft> obj = repository.findById(id);
        SobreNosSoft entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new SobreNosSoftDTO(entity);
    }
    @Transactional
    public SobreNosSoftDTO insert(SobreNosSoftDTO dto) {
        SobreNosSoft entity = new SobreNosSoft();
        copyDtoToEntity(dto, entity);

        salvarAuditoria("Sobre Nos Adicionado " + entity.getId());

        return new SobreNosSoftDTO(entity);
    }

    @Transactional
    public SobreNosSoftDTO  update(Long id, SobreNosSoftDTO dto) {
        try {
            SobreNosSoft entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            copyDtoToEntity(dto, entity);

            entity = repository.save(entity);
            salvarAuditoria("Sobre Nos Atualizado " + entity.getId());
            return new SobreNosSoftDTO(entity);
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
            SobreNosSoft entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            repository.deleteById(id);
            salvarAuditoria("Sobre Nos Deletado " + entity.getId());
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
    private void copyDtoToEntity(SobreNosSoftDTO dto, SobreNosSoft entity) {
        entity.setHistorico(dto.getHistorico());
        entity.setPolitica(dto.getPolitica());
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