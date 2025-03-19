package com.softeletronica.intrasoft.services;

import com.softeletronica.intrasoft.dto.primary.UserDTO;
import com.softeletronica.intrasoft.dto.secondary.ContatoSoftDTO;
import com.softeletronica.intrasoft.dto.secondary.ModeloInstalesoftDTO;
import com.softeletronica.intrasoft.dto.secondary.ProductAuxiliarDTO;
import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.secondary.ContatoSoft;
import com.softeletronica.intrasoft.entities.secondary.ModeloInstalesoft;
import com.softeletronica.intrasoft.entities.secondary.Product;

import com.softeletronica.intrasoft.entities.secondary.ProductAuxiliar;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import com.softeletronica.intrasoft.repositories.secondary.ProductAuxiliarRepository;
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
import java.util.Optional;


@Service
public class ProductAuxiliarService {
    @Autowired
    private ProductAuxiliarRepository productAuxiliarRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private AuditoriaRepository auditoriaRepository;
    @Transactional(readOnly = true)
    public Page<ProductAuxiliarDTO>findAllPaged(Pageable pageable) {
        Page<ProductAuxiliar> list = productAuxiliarRepository.findAll(pageable);
        return list.map(x-> new ProductAuxiliarDTO(x));
    }

    @Transactional(readOnly = true)
    public ProductAuxiliarDTO findById(Long id) {
        Optional<ProductAuxiliar> obj = productAuxiliarRepository.findById(id);
        ProductAuxiliar entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new ProductAuxiliarDTO(entity);
    }

    @Transactional
    public ProductAuxiliarDTO insert(ProductAuxiliarDTO dto) {
        ProductAuxiliar entity = new ProductAuxiliar();
        copyDtoToEntity(dto, entity);

        entity = productAuxiliarRepository.save(entity);
        // Criando registro de auditoria
        salvarAuditoria("Produto Auxiliar Adicionado " + entity.getProductauxiliar().getName());
        return new ProductAuxiliarDTO(entity);
    }

    @Transactional
    public ProductAuxiliarDTO update(Long id, ProductAuxiliarDTO dto) {
        try {
            ProductAuxiliar entity = productAuxiliarRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            copyDtoToEntity(dto, entity);

            entity = productAuxiliarRepository.save(entity);
            // Criando registro de auditoria
            salvarAuditoria("Produto Auxiliar atualizado " + entity.getProductauxiliar().getName());
            return new ProductAuxiliarDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    private void copyDtoToEntity(ProductAuxiliarDTO dto, ProductAuxiliar entity) {
        if (dto.getProductId() != null) {
            Product product = productRepository.findById(dto.getProductId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
            entity.setProductauxiliar(product);
        }
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!productAuxiliarRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            ProductAuxiliar entity = productAuxiliarRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));

            productAuxiliarRepository.deleteById(id);
            // Criando registro de auditoria
            salvarAuditoria("Produto Auxiliar Deletado " + entity.getProductauxiliar().getName());
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
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
