package com.softeletronica.intrasoft.services;



import com.softeletronica.intrasoft.dto.primary.UserDTO;
import com.softeletronica.intrasoft.dto.secondary.IsoSoftDTO;
import com.softeletronica.intrasoft.dto.secondary.IsoSoftDTO;
import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.secondary.IsoSoft;
import com.softeletronica.intrasoft.entities.secondary.IsoSoft;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import com.softeletronica.intrasoft.repositories.secondary.IsoSoftRepository;
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
public class IsoSoftService {

    @Autowired
    private IsoSoftRepository repository;
    @Autowired
    private UserService userService;
    @Autowired
    private AuditoriaRepository auditoriaRepository;
    @Transactional(readOnly = true)
    public Page<IsoSoftDTO> findAll(Pageable pageable) {
        Page<IsoSoft> list = repository.findAll(pageable);
        return list.map(x -> new IsoSoftDTO(x));
    }

    @Transactional(readOnly = true)
    public IsoSoftDTO findById(Long id) {
        Optional<IsoSoft> obj = repository.findById(id);
        IsoSoft entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new IsoSoftDTO(entity);
    }

    @Transactional
    public IsoSoftDTO insert(IsoSoftDTO dto) {
        IsoSoft entity = new IsoSoft();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        salvarAuditoria("Iso Soft Adicionado " + entity.getId());


        return new IsoSoftDTO(entity);
    }
    @Transactional
    public IsoSoftDTO update(Long id, IsoSoftDTO dto) {
        try {
            IsoSoft entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            copyDtoToEntity(dto, entity);

            entity = repository.save(entity);
            salvarAuditoria("Led Soft Atualizado " + entity.getId());
            return new IsoSoftDTO(entity);
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
            IsoSoft entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            repository.deleteById(id);
            salvarAuditoria("Led Soft Deletado " + entity.getId());
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
    private void copyDtoToEntity(IsoSoftDTO dto, IsoSoft entity) {
        entity.setName(dto.getName());
        entity.setImgUrl(dto.getImgUrl());
        entity.setImgUrl2(dto.getImgUrl2());
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