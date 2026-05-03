package com.softeletronica.intrasoft.services;



import com.softeletronica.intrasoft.dto.primary.UserDTO;
import com.softeletronica.intrasoft.dto.secondary.MontagemSoftDTO;
import com.softeletronica.intrasoft.dto.secondary.MontagemSoftDTO;
import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.secondary.MontagemSoft;
import com.softeletronica.intrasoft.entities.secondary.MontagemSoft;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import com.softeletronica.intrasoft.repositories.secondary.MontagemSoftRepository;
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
public class MontagemSoftService {

    @Autowired
    private MontagemSoftRepository repository;
    @Autowired
    private UserService userService;
    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Transactional(readOnly = true)
    public Page<MontagemSoftDTO> findAll(Pageable pageable) {
        Page<MontagemSoft> list = repository.findAll(pageable);
        return list.map(x -> new MontagemSoftDTO(x));
    }

    @Transactional(readOnly = true)
    public MontagemSoftDTO findById(Long id) {
        Optional<MontagemSoft> obj = repository.findById(id);
        MontagemSoft entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new MontagemSoftDTO(entity);
    }
    @Transactional
    public MontagemSoftDTO insert(MontagemSoftDTO dto) {
        MontagemSoft entity = new MontagemSoft();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        salvarAuditoria("Montagem Soft Adicionado " + entity.getId());

        return new MontagemSoftDTO(entity);
    }

    @Transactional
    public MontagemSoftDTO  update(Long id, MontagemSoftDTO dto) {
        try {
            MontagemSoft entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            copyDtoToEntity(dto, entity);

            entity = repository.save(entity);
            salvarAuditoria("Montagem Soft Atualizado " + entity.getId());
            return new MontagemSoftDTO(entity);
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
            MontagemSoft entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            repository.deleteById(id);
            salvarAuditoria("Montagem Soft Deletado " + entity.getId());
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
    private void copyDtoToEntity(MontagemSoftDTO dto, MontagemSoft entity) {
        entity.setDescricao(dto.getDescricao());
        entity.setAreaAtuacao(dto.getAreaAtuacao());
        entity.setUrlImg(dto.getUrlImg());
        entity.setUrlImg_2(dto.getUrlImg_2());
        entity.setUrlImg_3(dto.getUrlImg_3());
        entity.setUrlImg_4(dto.getUrlImg_4());
        entity.setUrlImg_5(dto.getUrlImg_5());
        entity.setUrlImg_6(dto.getUrlImg_6());
        entity.setUrlImg_7(dto.getUrlImg_7());
        entity.setUrlImg_8(dto.getUrlImg_8());
        entity.setUrlImg_9(dto.getUrlImg_9());
        entity.setUrlImg_10(dto.getUrlImg_10());
        entity.setUrlImg_11(dto.getUrlImg_11());
        entity.setUrlImg_12(dto.getUrlImg_12());
        entity.setUrlImg_13(dto.getUrlImg_13());
        entity.setUrlImg_14(dto.getUrlImg_14());
        entity.setUrlImg_15(dto.getUrlImg_15());
        entity.setUrlImg_16(dto.getUrlImg_16());
        entity.setUrlImg_17(dto.getUrlImg_17());
        entity.setUrlImg_18(dto.getUrlImg_18());
        entity.setUrlImg_19(dto.getUrlImg_19());
        entity.setUrlImg_20(dto.getUrlImg_20());
        entity.setUrlImg_21(dto.getUrlImg_21());
        entity.setUrlImg_22(dto.getUrlImg_22());
        entity.setUrlImg_23(dto.getUrlImg_23());
        entity.setUrlImg_24(dto.getUrlImg_24());
        entity.setUrlImg_25(dto.getUrlImg_25());
        entity.setUrlImg_26(dto.getUrlImg_26());
        entity.setUrlImg_27(dto.getUrlImg_27());
        entity.setUrlImg_28(dto.getUrlImg_28());
        entity.setUrlImg_29(dto.getUrlImg_29());
        entity.setUrlImg_30(dto.getUrlImg_30());
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