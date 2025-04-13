package com.softeletronica.intrasoft.services;



import com.softeletronica.intrasoft.dto.primary.UserDTO;
import com.softeletronica.intrasoft.dto.secondary.CatalogoSoftDTO;
import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.secondary.CatalogoSoft;
import com.softeletronica.intrasoft.entities.secondary.Product;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import com.softeletronica.intrasoft.repositories.secondary.CatalogoSoftRepository;
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
public class CatalogoSoftService {

    @Autowired
    private CatalogoSoftRepository repository;
    @Autowired
    private UserService userService;
    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Transactional(readOnly = true)
    public Page<CatalogoSoftDTO> findAll(Pageable pageable) {
        Page<CatalogoSoft> list = repository.findAll(pageable);
        return list.map(x -> new CatalogoSoftDTO(x));
    }

    @Transactional(readOnly = true)
    public CatalogoSoftDTO findById(Long id) {
        Optional<CatalogoSoft> obj = repository.findById(id);
        CatalogoSoft entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new CatalogoSoftDTO(entity);
    }

    @Transactional
    public CatalogoSoftDTO insert(CatalogoSoftDTO dto){
        CatalogoSoft entity = new CatalogoSoft();
        copyDtoToEntity(dto, entity);
        entity.setCreateAt(Instant.now());
        entity.setUpdateAt(Instant.now());
        entity = repository.save(entity);
        salvarAuditoria("Catalogo adicionado " + entity.getId());

        return new CatalogoSoftDTO(entity);
    }

    @Transactional
    public CatalogoSoftDTO update(Long id, CatalogoSoftDTO dto) {
        try {
            CatalogoSoft entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            copyDtoToEntity(dto, entity);
            entity.setUpdateAt(Instant.now());
            entity = repository.save(entity);
            salvarAuditoria("Catalogo atualizado " + entity.getId());

            return new CatalogoSoftDTO(entity);
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
            CatalogoSoft entity = repository.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Id not found " + id));
            repository.deleteById(id);
            salvarAuditoria("Catalogo deletado " + entity.getId());
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(CatalogoSoftDTO dto, CatalogoSoft entity){
        entity.setDescricao(dto.getDescricao());
        entity.setLocal(dto.getLocal());
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