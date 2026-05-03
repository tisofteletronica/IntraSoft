package com.softeletronica.intrasoft.services;

import com.softeletronica.intrasoft.dto.primary.UserDTO;
import com.softeletronica.intrasoft.dto.secondary.MontagemSoftServicosDTO;
import com.softeletronica.intrasoft.dto.secondary.MontagemSoftServicosDTO;
import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.secondary.MontagemSoftServicos;
import com.softeletronica.intrasoft.entities.secondary.MontagemSoftServicos;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import com.softeletronica.intrasoft.repositories.secondary.MontagemSoftServicosRepository;
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
public class MontagemSoftServicosService {

    @Autowired
    private MontagemSoftServicosRepository repository;
    @Autowired
    private UserService userService;
    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Transactional(readOnly = true)
    public Page<MontagemSoftServicosDTO> findAll(Pageable pageable) {
        Page<MontagemSoftServicos> list = repository.findAll(pageable);
        return list.map(x -> new MontagemSoftServicosDTO(x));
    }

    @Transactional(readOnly = true)
    public MontagemSoftServicosDTO findById(Long id) {
        Optional<MontagemSoftServicos> obj = repository.findById(id);
        MontagemSoftServicos entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new MontagemSoftServicosDTO(entity);
    }
    @Transactional
    public MontagemSoftServicosDTO insert(MontagemSoftServicosDTO dto) {
        MontagemSoftServicos entity = new MontagemSoftServicos();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);

        salvarAuditoria("Montagem Soft Servicos Adicionado " + entity.getId());

        return new MontagemSoftServicosDTO(entity);
    }

    @Transactional
    public MontagemSoftServicosDTO  update(Long id, MontagemSoftServicosDTO dto) {
        try {
            MontagemSoftServicos entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            copyDtoToEntity(dto, entity);

            entity = repository.save(entity);
            salvarAuditoria("Montagem Soft Servicos Atualizado " + entity.getId());
            return new MontagemSoftServicosDTO(entity);
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
            MontagemSoftServicos entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            repository.deleteById(id);
            salvarAuditoria("Montagem Soft Servicos Deletado " + entity.getId());
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
    private void copyDtoToEntity(MontagemSoftServicosDTO dto, MontagemSoftServicos entity) {
        entity.setServicos(dto.getServicos());
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