package com.softeletronica.intrasoft.services;

import com.softeletronica.intrasoft.dto.primary.UserDTO;
import com.softeletronica.intrasoft.dto.secondary.ProductAuxiliarDTO;
import com.softeletronica.intrasoft.dto.secondary.ProductCommercialMontadoraDTO;
import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.secondary.MontadoraInstalesoft;
import com.softeletronica.intrasoft.entities.secondary.Product;
import com.softeletronica.intrasoft.entities.secondary.ProductAuxiliar;
import com.softeletronica.intrasoft.entities.secondary.ProductCommercialMontadora;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import com.softeletronica.intrasoft.repositories.secondary.MontadoraInstalesoftRepository;
import com.softeletronica.intrasoft.repositories.secondary.ProductAuxiliarRepository;
import com.softeletronica.intrasoft.repositories.secondary.ProductCommercialMontadoraRepository;
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
public class ProductCommercialMontadoraService {
    @Autowired
    private ProductCommercialMontadoraRepository productCommercialMontadoraRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MontadoraInstalesoftRepository montadoraInstalesoftRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private AuditoriaRepository auditoriaRepository;
    @Transactional(readOnly = true)
    public Page<ProductCommercialMontadoraDTO> findAllPaged(Pageable pageable) {
        Page<ProductCommercialMontadora> list = productCommercialMontadoraRepository.findAll(pageable);
        return list.map(x -> new ProductCommercialMontadoraDTO(x.getProductcommercial(), x));
    }


    @Transactional(readOnly = true)
    public ProductCommercialMontadoraDTO findById(Long id) {
        Optional<ProductCommercialMontadora> obj = productCommercialMontadoraRepository.findById(id);
        ProductCommercialMontadora entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));

        return new ProductCommercialMontadoraDTO(entity.getProductcommercial(), entity);
    }


    @Transactional
    public ProductCommercialMontadoraDTO insert(ProductCommercialMontadoraDTO dto) {
        ProductCommercialMontadora entity = new ProductCommercialMontadora();
        copyDtoToEntity(dto, entity);

        entity = productCommercialMontadoraRepository.save(entity);
        // Criando registro de auditoria
        salvarAuditoria("Produto Comercial Montadora Adicionado " + entity.getProductmontadoras().getName()
                + entity.getProductcommercial().getName());
        return new ProductCommercialMontadoraDTO(entity.getProductcommercial(), entity);
    }

    @Transactional
    public ProductCommercialMontadoraDTO update(Long id, ProductCommercialMontadoraDTO dto) {
        try {
            ProductCommercialMontadora entity = productCommercialMontadoraRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
            copyDtoToEntity(dto, entity);

            entity = productCommercialMontadoraRepository.save(entity);
            // Criando registro de auditoria
            salvarAuditoria("Produto Comercial Montadora Atualizado " + entity.getProductcommercial().getName()
                    + entity.getProductmontadoras().getName());
            return new ProductCommercialMontadoraDTO(entity.getProductcommercial(), entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        if (!productCommercialMontadoraRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            ProductCommercialMontadora entity = productCommercialMontadoraRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));

            productCommercialMontadoraRepository.deleteById(id);
            // Criando registro de auditoria
            salvarAuditoria("Produto Comercial Montadora Deletado " + entity.getProductcommercial().getName());
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(ProductCommercialMontadoraDTO dto, ProductCommercialMontadora entity) {
        if (dto.getProductId() != null) {
            Product product = productRepository.findById(dto.getProductId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
            entity.setProductcommercial(product);
        }

        if (dto.getMontadoraId() != null) {
            MontadoraInstalesoft montadora = montadoraInstalesoftRepository.findById(dto.getMontadoraId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
            entity.setProductmontadoras(montadora);
        }
    }
    @Transactional(propagation = Propagation.SUPPORTS)

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
