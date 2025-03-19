package com.softeletronica.intrasoft.services;

import com.softeletronica.intrasoft.dto.primary.UserDTO;
import com.softeletronica.intrasoft.dto.secondary.ProductExtraSiteDTO;
import com.softeletronica.intrasoft.dto.secondary.ProdutoMontadoraMinDTO;
import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.secondary.CategoryProductCommercial;
import com.softeletronica.intrasoft.entities.secondary.Product;
import com.softeletronica.intrasoft.entities.secondary.ProductExtraSite;
import com.softeletronica.intrasoft.projections.ProdutoMontadoraProjection;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import com.softeletronica.intrasoft.repositories.secondary.CategoryProductCommercialRepository;
import com.softeletronica.intrasoft.repositories.secondary.ProductExtraSiteRepository;
import com.softeletronica.intrasoft.repositories.secondary.ProductRepository;
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
public class ProductExtraSiteService {
    @Autowired
    private ProductExtraSiteRepository repository;

    @Autowired
    private UserService userService;
    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Transactional(readOnly = true)
    public Page<ProductExtraSiteDTO> findAll(Pageable pageable) {
        Page<ProductExtraSite> list = repository.findAll(pageable);
        return list.map(x -> new ProductExtraSiteDTO(x));
    }

    @Transactional(readOnly = true)
    public Page<ProductExtraSiteDTO> filterByName(String name, Pageable pageable) {

        if (name != "") {
            Page<ProductExtraSite> list = repository.filterByName(name, pageable);
            return list.map(x -> new ProductExtraSiteDTO(x));
        } else {
            Page<ProductExtraSite> list = repository.findAll(pageable);
            return list.map(x -> new ProductExtraSiteDTO(x));
        }
    }
    @Transactional(readOnly = true)
    public ProductExtraSiteDTO findById(Long id) {
        Optional<ProductExtraSite> obj = repository.findById(id);
        ProductExtraSite entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new ProductExtraSiteDTO(entity);
    }
    @Transactional
    public ProductExtraSiteDTO insert(ProductExtraSiteDTO dto) {
        ProductExtraSite entity = new ProductExtraSite();
        copyDtoToEntity(dto, entity);
        entity.setCreatedAt(Instant.now());
        entity.setUpdatedAt(Instant.now());
        entity = repository.save(entity);
        salvarAuditoria("Produto Extra Site Adicionado " + entity.getName());
        return new ProductExtraSiteDTO(entity);
    }
    @Transactional
    public ProductExtraSiteDTO update(Long id, ProductExtraSiteDTO dto) {
        try {
            ProductExtraSite entity = repository.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Id not found " + id));
            updateDtoToEntity(dto, entity);
            entity.setUpdatedAt(Instant.now());
            entity = repository.save(entity);
            salvarAuditoria("Produto Extra Site Atualizado " + entity.getName());
            return new ProductExtraSiteDTO(entity);
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
            ProductExtraSite entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));

            repository.deleteById(id);
            salvarAuditoria("Produto Extra Site deletado " + entity.getName());
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
    private void copyDtoToEntity(ProductExtraSiteDTO dto, ProductExtraSite entity) {
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());

        entity.setImgUrl1(dto.getImgUrl1());
        entity.setImgUrl2(dto.getImgUrl2());
        entity.setImgUrl3(dto.getImgUrl3());
        entity.setImgUrl4(dto.getImgUrl4());
        entity.setImgUrl5(dto.getImgUrl5());
        entity.setUrlLogoImg(dto.getUrlLogoImg());
        entity.setUrlManual(dto.getUrlManual());
        entity.setUrlManual_1(dto.getUrlManual_1());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setActive(dto.getActive());



    }

    private void updateDtoToEntity(ProductExtraSiteDTO dto, ProductExtraSite entity) {
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setImgUrl1(dto.getImgUrl1());
        entity.setImgUrl2(dto.getImgUrl2());
        entity.setImgUrl3(dto.getImgUrl3());
        entity.setImgUrl4(dto.getImgUrl4());
        entity.setImgUrl5(dto.getImgUrl5());
        entity.setUrlLogoImg(dto.getUrlLogoImg());
        entity.setUrlManual(dto.getUrlManual());
        entity.setUrlManual_1(dto.getUrlManual_1());
        entity.setUpdatedAt(dto.getUpdatedAt());
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
