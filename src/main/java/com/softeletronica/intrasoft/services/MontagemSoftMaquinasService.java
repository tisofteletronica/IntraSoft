package com.softeletronica.intrasoft.services;

import com.softeletronica.intrasoft.dto.primary.UserDTO;
import com.softeletronica.intrasoft.dto.secondary.MontagemSoftMaquinasDTO;
import com.softeletronica.intrasoft.dto.secondary.MontagemSoftMaquinasDTO;
import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.secondary.MontagemSoftMaquinas;
import com.softeletronica.intrasoft.entities.secondary.MontagemSoftMaquinas;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import com.softeletronica.intrasoft.repositories.secondary.MontagemSoftMaquinasRepository;
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
public class MontagemSoftMaquinasService {

    @Autowired
    private MontagemSoftMaquinasRepository repository;
    @Autowired
    private UserService userService;
    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Transactional(readOnly = true)
    public Page<MontagemSoftMaquinasDTO> findAll(Pageable pageable) {
        Page<MontagemSoftMaquinas> list = repository.findAll(pageable);
        return list.map(x -> new MontagemSoftMaquinasDTO(x));
    }

    @Transactional(readOnly = true)
    public MontagemSoftMaquinasDTO findById(Long id) {
        Optional<MontagemSoftMaquinas> obj = repository.findById(id);
        MontagemSoftMaquinas entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new MontagemSoftMaquinasDTO(entity);
    }
    @Transactional
    public MontagemSoftMaquinasDTO insert(MontagemSoftMaquinasDTO dto) {
        MontagemSoftMaquinas entity = new MontagemSoftMaquinas();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);

        salvarAuditoria("Montagem Maquinas Adicionado " + entity.getId());

        return new MontagemSoftMaquinasDTO(entity);
    }

    @Transactional
    public MontagemSoftMaquinasDTO  update(Long id, MontagemSoftMaquinasDTO dto) {
        try {
            MontagemSoftMaquinas entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            copyDtoToEntity(dto, entity);

            entity = repository.save(entity);
            salvarAuditoria("Montagem Maquinas Atualizado " + entity.getId());
            return new MontagemSoftMaquinasDTO(entity);
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
            MontagemSoftMaquinas entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            repository.deleteById(id);
            salvarAuditoria("Montagem Maquinas Deletado " + entity.getId());
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
    private void copyDtoToEntity(MontagemSoftMaquinasDTO dto, MontagemSoftMaquinas entity) {
        entity.setTipo(dto.getTipo());
        entity.setMaquina(dto.getMaquina());
        entity.setDescricao(dto.getDescricao());



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