package com.softeletronica.intrasoft.services;

import com.softeletronica.intrasoft.dto.primary.UserDTO;
import com.softeletronica.intrasoft.dto.secondary.ProductDTO;
import com.softeletronica.intrasoft.dto.secondary.ProdutoMontadoraMinDTO;
import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.secondary.CategoryProductCommercial;
import com.softeletronica.intrasoft.entities.secondary.ModeloInstalesoft;
import com.softeletronica.intrasoft.entities.secondary.Product;
import com.softeletronica.intrasoft.projections.ProdutoMontadoraProjection;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import com.softeletronica.intrasoft.repositories.secondary.CategoryProductCommercialRepository;
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
public class ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    CategoryProductCommercialRepository categoryProductCommercialRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> list = repository.findAll(pageable);
        return list.map(x -> new ProductDTO(x));
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> SorteCode(String code, Pageable pageable) {
        Page<Product> list = repository.SorteCode(code, pageable);
        return list.map(ProductDTO::new);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> filterCode(String code, Pageable pageable) {
        Page<Product> list = repository.filterCode(code, pageable);
        return list.map(ProductDTO::new);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> filterCategoryById(Long categoryCommercialId, Pageable pageable) {
        Page<Product> list = repository.filterCategoryById(categoryCommercialId, pageable);
        return list.map(x -> new ProductDTO(x));
    }
    @Transactional(readOnly = true)
    public Page<ProductDTO> filterByName(String name, Pageable pageable) {

        if (name != "") {
            Page<Product> list = repository.filterByName(name, pageable);
            return list.map(x -> new ProductDTO(x));
        } else {
            Page<Product> list = repository.findAll(pageable);
            return list.map(x -> new ProductDTO(x));
        }
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> filterByCode(String code, Pageable pageable) {

        if (code != "") {
            Page<Product> list = repository.filterByCode(code, pageable);
            return list.map(x -> new ProductDTO(x));
        } else {
            Page<Product> list = repository.findAll(pageable);
            return list.map(x -> new ProductDTO(x));
        }
    }
    @Transactional
    public Page<ProductDTO> filterByCategoryTravaAtuador(String name, Long categoryCommercialId, Pageable pageable) {
        Page<Product> list = repository.filterByCategoryTravaAtuador(name, categoryCommercialId, pageable);
        return list.map(x -> new ProductDTO(x));
    }

    @Transactional
    public List<ProductDTO> filterTravaMontadoraList(String montadora) {
        List<Product> list = repository.filterTravaMontadora(montadora);
        return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public List<ProductDTO> filterAtuadorMontadoraList(String montadora) {
        List<Product> list = repository.filterAtuadorMontadora(montadora);
        return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public List<ProductDTO> filterUniqueMontadoraList(String montadora) {
        List<Product> list = repository.filterUniqueMontadora(montadora);
        return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
    }
    @Transactional
    public List<ProdutoMontadoraMinDTO> filterProdutoTravaMontadoraList() {
        List<ProdutoMontadoraProjection> list = repository.filterProdutoTravaMontadoraList();
        return list.stream().map(x -> new ProdutoMontadoraMinDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public List<ProdutoMontadoraMinDTO> filterProdutoAtuadorMontadoraList() {
        List<ProdutoMontadoraProjection> list = repository.filterProdutoAtuadorMontadoraList();
        return list.stream().map(x -> new ProdutoMontadoraMinDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public List<ProdutoMontadoraMinDTO> filterProdutoUniqueMontadoraList() {
        List<ProdutoMontadoraProjection> list = repository.filterProdutoUniqueMontadoraList();
        return list.stream().map(x -> new ProdutoMontadoraMinDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        Product entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new ProductDTO(entity);
    }
    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();
        copyDtoToEntity(dto, entity);
        entity.setCreatedAt(Instant.now());
        entity.setUpdatedAt(Instant.now());
        entity = repository.save(entity);
        salvarAuditoria("Produto Adicionado " + entity.getName());
        return new ProductDTO(entity);
    }
    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
        try {
            Product entity = repository.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Id not found " + id));
            copyDtoToEntity(dto, entity);
            entity.setUpdatedAt(Instant.now());
            entity = repository.save(entity);
            salvarAuditoria("Produto Atualizado " + entity.getName());
            return new ProductDTO(entity);
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
            Product entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));

            repository.deleteById(id);
            salvarAuditoria("Produto deletado " + entity.getName());
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
    private void copyDtoToEntity(ProductDTO dto, Product entity) {
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setDescriptionCommercialResume(dto.getDescriptionCommercialResume());
        entity.setDescriptionCommercial(dto.getDescriptionCommercial());
        entity.setDescriptionCharacteristicsCommercial(dto.getDescriptionCharacteristicsCommercial());
        entity.setApplicationCommercial(dto.getApplicationCommercial());
        entity.setEpilogueCommercial(dto.getEpilogueCommercial());
        entity.setDescriptionInstalesoft(dto.getDescriptionInstalesoft());
        entity.setWeight(dto.getWeight());
        entity.setLength(dto.getLength());
        entity.setWidth(dto.getWidth());
        entity.setHeight(dto.getHeight());
        entity.setCapaImagem(dto.getCapaImagem());
        entity.setImgUrl1(dto.getImgUrl1());
        entity.setImgUrl2(dto.getImgUrl2());
        entity.setImgUrl3(dto.getImgUrl3());
        entity.setImgUrl4(dto.getImgUrl4());
        entity.setImgUrl5(dto.getImgUrl5());
        entity.setUrlLogoImg(dto.getUrlLogoImg());
        entity.setUrlManual(dto.getUrlManual());
        entity.setZip(dto.getZip());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setActive(dto.getActive());

        if (dto.getCategoryCommercialId()!= null) {
            CategoryProductCommercial categoryProductCommercial = categoryProductCommercialRepository.findById(dto.getCategoryCommercialId())
                    .orElseThrow(()-> new ResourceNotFoundException("Categoria Comercial não encontrada"));
            entity.setCategoryProductCommercial(categoryProductCommercial);
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
