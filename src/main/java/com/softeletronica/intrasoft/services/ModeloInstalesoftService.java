package com.softeletronica.intrasoft.services;




import com.softeletronica.intrasoft.dto.primary.UserDTO;
import com.softeletronica.intrasoft.dto.secondary.ModeloInstalesoftDTO;
import com.softeletronica.intrasoft.entities.primary.Auditoria;

import com.softeletronica.intrasoft.entities.secondary.ModeloInstalesoft;
import com.softeletronica.intrasoft.entities.secondary.MontadoraInstalesoft;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import com.softeletronica.intrasoft.repositories.secondary.ModeloInstalesoftRepository;
import com.softeletronica.intrasoft.repositories.secondary.MontadoraInstalesoftRepository;
import com.softeletronica.intrasoft.services.exceptions.DatabaseException;
import com.softeletronica.intrasoft.services.exceptions.ResourceNotFoundException;
import com.softeletronica.intrasoft.utils.PageUtils;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ModeloInstalesoftService {

    @Autowired
    private ModeloInstalesoftRepository repository;

    @Autowired
    private MontadoraInstalesoftRepository montadoraInstalesoftRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AuditoriaRepository auditoriaRepository;


    @Transactional(readOnly = true)
    public Page<ModeloInstalesoftDTO>findAllPaged(Pageable pageable) {
        Page<ModeloInstalesoft> list = repository.findAll(pageable);
        return list.map(x-> new ModeloInstalesoftDTO(x));
    }

    @Transactional(readOnly = true)
    public Page<ModeloInstalesoftDTO> findAllName(String name, Pageable pageable) {
        if (name != "") {
            Page<ModeloInstalesoft> list = repository.filterByName(name, pageable);
            return list.map(x -> new ModeloInstalesoftDTO(x));
        } else {
            Page<ModeloInstalesoft> list = repository.findAllName(pageable);
            return list.map(x -> new ModeloInstalesoftDTO(x));
        }
    }

    @Transactional(readOnly = true)
    public Page<ModeloInstalesoftDTO> findByIdMontadora(Long montadoraId, Pageable pageable) {
        Page<ModeloInstalesoft> list = repository.findByIdMontadora(montadoraId, PageUtils.adjustPageNumber(pageable));
        return list.map(x -> new ModeloInstalesoftDTO(x));
    }

    @Transactional
    public List<ModeloInstalesoftDTO> ListByIdMontadora(Long montadoraId) {
        List<ModeloInstalesoft> list = repository.ListByIdMontadora(montadoraId);
        return list.stream().limit(50).map(x -> new ModeloInstalesoftDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Page<ModeloInstalesoftDTO> findByNameMontadora(String montadora, Pageable pageable) {
        Page<ModeloInstalesoft> list = repository.findByNameMontadora(montadora, PageUtils.adjustPageNumber(pageable));
        return list.map(x -> new ModeloInstalesoftDTO(x));
    }

    @Transactional(readOnly = true)
    public ModeloInstalesoftDTO findById(Long id) {
        Optional<ModeloInstalesoft> obj = repository.findById(id);
        ModeloInstalesoft entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new ModeloInstalesoftDTO(entity);
    }

    @Transactional
    public ModeloInstalesoftDTO insert(ModeloInstalesoftDTO dto) {
        ModeloInstalesoft entity = new ModeloInstalesoft();
        copyDtoToEntity(dto, entity);
        entity.setCreatedAt(Instant.now());
        entity.setUpdatedAt(Instant.now());
        entity = repository.save(entity);
        // Criando registro de auditoria
        salvarAuditoria("Modelo Adicionado " + entity.getName());
        return new ModeloInstalesoftDTO(entity);
    }

    @Transactional
    public ModeloInstalesoftDTO update(Long id, ModeloInstalesoftDTO dto) {
        try {
            ModeloInstalesoft entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            updateDtoToEntity(dto, entity);
            entity.setUpdatedAt(Instant.now());
            entity = repository.save(entity);
            // Criando registro de auditoria
            salvarAuditoria("Modelo Atualizado " + entity.getName());
            return new ModeloInstalesoftDTO(entity);
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
            ModeloInstalesoft entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));

            repository.deleteById(id);
            // Criando registro de auditoria
            salvarAuditoria("Modelo Deletado " + entity.getName());
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(ModeloInstalesoftDTO dto, ModeloInstalesoft entity) {
        entity.setName(dto.getName());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setActive(dto.getActive());

        if (dto.getMontadoraId() != null) {
            MontadoraInstalesoft montadoraInstalesoft = montadoraInstalesoftRepository.findById(dto.getMontadoraId())

                    .orElseThrow(() -> new ResourceNotFoundException("Montadora não encontrada"));

            entity.setMontadoras(montadoraInstalesoft);
        }
    }


    private void updateDtoToEntity(ModeloInstalesoftDTO dto, ModeloInstalesoft entity) {
        entity.setName(dto.getName());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setActive(dto.getActive());

        if (dto.getMontadoraId() != null) {
            MontadoraInstalesoft montadoraInstalesoft = montadoraInstalesoftRepository.findById(dto.getMontadoraId())

                    .orElseThrow(() -> new ResourceNotFoundException("Montadora não encontrada"));

            entity.setMontadoras(montadoraInstalesoft);
        }
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