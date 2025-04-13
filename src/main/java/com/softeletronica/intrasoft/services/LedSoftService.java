package com.softeletronica.intrasoft.services;

import com.softeletronica.intrasoft.dto.primary.UserDTO;
import com.softeletronica.intrasoft.dto.secondary.LedSoftDTO;
import com.softeletronica.intrasoft.dto.secondary.LedSoftDTO;
import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.secondary.LedSoft;
import com.softeletronica.intrasoft.entities.secondary.LedSoft;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import com.softeletronica.intrasoft.repositories.secondary.LedSoftRepository;
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
public class LedSoftService {
    @Autowired
    private LedSoftRepository repository;
    @Autowired
    private UserService userService;
    @Autowired
    private AuditoriaRepository auditoriaRepository;
    @Transactional(readOnly = true)
    public Page<LedSoftDTO> findAll(Pageable pageable) {
        Page<LedSoft> list = repository.findAll(pageable);
        return list.map(x -> new LedSoftDTO(x));
    }
    @Transactional(readOnly = true)
    public LedSoftDTO findById(Long id) {
        Optional<LedSoft> obj = repository.findById(id);
        LedSoft entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new LedSoftDTO(entity);
    }@Transactional
    public LedSoftDTO insert(LedSoftDTO dto) {
        LedSoft entity = new LedSoft();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        salvarAuditoria("Led Soft Adicionado " + entity.getId());


        return new LedSoftDTO(entity);
    }
    @Transactional
    public LedSoftDTO  update(Long id, LedSoftDTO dto) {
        try {
            LedSoft entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            copyDtoToEntity(dto, entity);

            entity = repository.save(entity);
            salvarAuditoria("Led Soft Atualizado " + entity.getId());
            return new LedSoftDTO(entity);
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
            LedSoft entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            repository.deleteById(id);
            salvarAuditoria("Led Soft Deletado " + entity.getId());
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
    private void copyDtoToEntity(LedSoftDTO dto, LedSoft entity) {
        entity.setDescricao(dto.getDescricao());
        entity.setProducao(dto.getProducao());
        entity.setProjetos(dto.getProjetos());
        entity.setAplicacoes(dto.getAplicacoes());
        entity.setConclusao(dto.getConclusao());
        entity.setUrlImg(dto.getUrlImg());
        entity.setUrlImg_2(dto.getUrlImg_2());
        entity.setUrlImg_3(dto.getUrlImg_3());
        entity.setUrlImg_4(dto.getUrlImg_4());
        entity.setUrlImg_5(dto.getUrlImg_5());
        entity.setUrlImg_6(dto.getUrlImg_6());
        entity.setImgSiteLed_1(dto.getImgSiteLed_1());
        entity.setImgSiteLed_2(dto.getImgSiteLed_2());
        entity.setImgSiteLed_3(dto.getImgSiteLed_3());
        entity.setImgSiteLed_4(dto.getImgSiteLed_4());
        entity.setImgSiteLed_5(dto.getImgSiteLed_5());

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