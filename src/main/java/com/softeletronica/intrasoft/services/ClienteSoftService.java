package com.softeletronica.intrasoft.services;

import com.softeletronica.intrasoft.dto.primary.UserDTO;
import com.softeletronica.intrasoft.dto.secondary.ClienteSoftDTO;
import com.softeletronica.intrasoft.dto.secondary.ClienteSoftDTO;
import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.secondary.ClienteSoft;
import com.softeletronica.intrasoft.entities.secondary.ClienteSoft;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import com.softeletronica.intrasoft.repositories.secondary.ClienteSoftRepository;
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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ClienteSoftService {

    @Autowired
    private ClienteSoftRepository repository;
    @Autowired
    private UserService userService;
    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Transactional(readOnly = true)
    public Page<ClienteSoftDTO> findAll(Pageable pageable) {
        Page<ClienteSoft> list = repository.findAll(pageable);
        return list.map(x -> new ClienteSoftDTO(x));
    }

    @Transactional(readOnly = true)
    public ClienteSoftDTO findById(Long id) {
        Optional<ClienteSoft> obj = repository.findById(id);
        ClienteSoft entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new ClienteSoftDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<ClienteSoftDTO> findUfOrCity(String uf, String cidade) {
        List<ClienteSoft> list = repository.filterUForCity(uf, cidade);
        return list.stream().map(x-> new ClienteSoftDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Page<ClienteSoftDTO> findUfOrCityPage(String uf, String cidade, Pageable pageable) {
        Page<ClienteSoft> list = repository.filterUForCityPageable(uf, cidade, pageable);
        return list.map(x-> new ClienteSoftDTO(x));
    }

    @Transactional(readOnly = true)
    public Page<ClienteSoftDTO> findRazaoSocial(String razaoSocial, Pageable pageable) {
        Page<ClienteSoft> list = repository.filterNamePageable(razaoSocial, pageable);
        return list.map(x-> new ClienteSoftDTO(x));
    }

    @Transactional
    public ClienteSoftDTO insert(ClienteSoftDTO dto){
        ClienteSoft entity = new ClienteSoft();
        copyDtoToEntity(dto, entity);
        entity.setCreateAt(Instant.now());
        entity.setUpdateAt(Instant.now());
        entity = repository.save(entity);
        salvarAuditoria("Cliente adicionado " + entity.getRazaoSocial());

        return new ClienteSoftDTO(entity);
    }

    @Transactional
    public ClienteSoftDTO update(Long id, ClienteSoftDTO dto) {
        try {
            ClienteSoft entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            copyDtoToEntity(dto, entity);
            entity.setUpdateAt(Instant.now());
            entity = repository.save(entity);
            salvarAuditoria("Cliente atualizado " + entity.getRazaoSocial());

            return new ClienteSoftDTO(entity);
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
            ClienteSoft entity = repository.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Id not found " + id));
            repository.deleteById(id);
            salvarAuditoria("Cliente deletado " + entity.getRazaoSocial());
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(ClienteSoftDTO dto, ClienteSoft entity){
        entity.setTipo(dto.getTipo());
        entity.setCnpjCPF(dto.getCnpjCPF());
        entity.setRazaoSocial(dto.getRazaoSocial());
        entity.setEmail(dto.getEmail());
        entity.setTelefone1(dto.getTelefone1());
        entity.setTelefone2(dto.getTelefone2());
        entity.setCep(dto.getCep());
        entity.setEndereco(dto.getEndereco());
        entity.setNumero(dto.getNumero());
        entity.setComplemento(dto.getComplemento());
        entity.setBairro(dto.getBairro());
        entity.setCidade(dto.getCidade());
        entity.setUf(dto.getUf());
        entity.setLatitude(dto.getLatitude());
        entity.setLongitude(dto.getLongitude());
        entity.setSite(dto.getSite());
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