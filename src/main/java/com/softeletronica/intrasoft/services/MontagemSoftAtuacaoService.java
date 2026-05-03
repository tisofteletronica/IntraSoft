package com.softeletronica.intrasoft.services;



import com.softeletronica.intrasoft.dto.primary.UserDTO;
import com.softeletronica.intrasoft.dto.secondary.MontagemSoftAtuacaoDTO;
import com.softeletronica.intrasoft.dto.secondary.MontagemSoftAtuacaoDTO;
import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.secondary.MontagemSoftAtuacao;
import com.softeletronica.intrasoft.entities.secondary.MontagemSoftAtuacao;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import com.softeletronica.intrasoft.repositories.secondary.MontagemSoftAtuacaoRepository;
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
public class MontagemSoftAtuacaoService {

    @Autowired
    private MontagemSoftAtuacaoRepository repository;
    @Autowired
    private UserService userService;
    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Transactional(readOnly = true)
    public Page<MontagemSoftAtuacaoDTO> findAll(Pageable pageable) {
        Page<MontagemSoftAtuacao> list = repository.findAll(pageable);
        return list.map(x -> new MontagemSoftAtuacaoDTO(x));
    }

    @Transactional(readOnly = true)
    public MontagemSoftAtuacaoDTO findById(Long id) {
        Optional<MontagemSoftAtuacao> obj = repository.findById(id);
        MontagemSoftAtuacao entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new MontagemSoftAtuacaoDTO(entity);
    }
    @Transactional
    public MontagemSoftAtuacaoDTO insert(MontagemSoftAtuacaoDTO dto) {
        MontagemSoftAtuacao entity = new MontagemSoftAtuacao();
        copyDtoToEntity(dto, entity);
        entity.setCreateAt(Instant.now());
        entity.setUpdateAt(Instant.now());

        entity = repository.save(entity);

        salvarAuditoria("Montagem Soft Adicionado " + entity.getId());

        return new MontagemSoftAtuacaoDTO(entity);
    }

    @Transactional
    public MontagemSoftAtuacaoDTO  update(Long id, MontagemSoftAtuacaoDTO dto) {
        try {
            MontagemSoftAtuacao entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            copyDtoToEntity(dto, entity);

            entity = repository.save(entity);
            entity.setUpdateAt(Instant.now());

            salvarAuditoria("Montagem Soft Atualizado " + entity.getId());
            return new MontagemSoftAtuacaoDTO(entity);
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
            MontagemSoftAtuacao entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            repository.deleteById(id);
            salvarAuditoria("Montagem Soft Deletado " + entity.getId());
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
    private void copyDtoToEntity(MontagemSoftAtuacaoDTO dto, MontagemSoftAtuacao entity) {
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