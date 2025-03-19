package com.softeletronica.intrasoft.services;

import com.softeletronica.intrasoft.dto.primary.UserDTO;
import com.softeletronica.intrasoft.dto.secondary.*;
import com.softeletronica.intrasoft.entities.primary.Auditoria;
import com.softeletronica.intrasoft.entities.secondary.*;
import com.softeletronica.intrasoft.projections.AnoModeloProjection;
import com.softeletronica.intrasoft.projections.ModeloCategoriaProjection;
import com.softeletronica.intrasoft.projections.ProdutoPorAplicacaoProjection;
import com.softeletronica.intrasoft.projections.ProdutosPorModelosProjection;
import com.softeletronica.intrasoft.repositories.primary.AuditoriaRepository;
import com.softeletronica.intrasoft.repositories.secondary.*;
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
public class AplicacaoInstaleSoftService {
    @Autowired
    private AplicacaoInstaleSoftRepository repository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductAuxiliarRepository productAuxiliarRepository;

    @Autowired
    private ModeloInstalesoftRepository modeloInstalesoftRepository;

    @Autowired
    private CategoryProductInstaleSoftRepository categoryProductInstaleSoftRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private AuditoriaRepository auditoriaRepository;


    @Transactional(readOnly = true)
    public Page<AplicacaoInstaleSoftDTO> findAll(Pageable pageable) {
        Page<AplicacaoInstaleSoft> list = repository.findAll(pageable);
        return list.map(x -> new AplicacaoInstaleSoftDTO(x));
    }


    @Transactional(readOnly = true)
    public AplicacaoInstaleSoftDTO findById(Long id) {
        Optional<AplicacaoInstaleSoft> obj = repository.findById(id);
        AplicacaoInstaleSoft entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
        return new AplicacaoInstaleSoftDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<AnoCarroMinDTO> filtrarAnos(Long id) {
        List<AnoModeloProjection> list = repository.anomodelo(id);
        return list.stream().limit(50).map(x -> new AnoCarroMinDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Page<CategoriaModeloMinDTO> filtrarCategoria(Long modeloId, Integer ano, Pageable pageable) {
        Page<ModeloCategoriaProjection> list = repository.modelocategoria(modeloId, ano, pageable);
        return list.map(x -> new CategoriaModeloMinDTO(x));
    }
    @Transactional(readOnly = true)
    public Page<AplicacaoInstaleSoftDTO> modeloProduto(Integer ano, Long categoriaId, Long modeloId, Pageable pageable) {
        Page<AplicacaoInstaleSoft> list = repository.modeloProduto(ano, categoriaId, modeloId, pageable);
        return list.map(x -> new AplicacaoInstaleSoftDTO(x, ano));
    }
    @Transactional(readOnly = true)
    public Page<AplicacaoInstaleSoftDTO> modeloProdutoVc(Integer ano, Long categoriaId, Long modeloId, Integer vidroConvencional,
                                                         Pageable pageable) {
        Page<AplicacaoInstaleSoft> list = repository.modeloProdutoVc(ano, categoriaId, modeloId, vidroConvencional, pageable);
        return list.map(x -> new AplicacaoInstaleSoftDTO(x, ano));
    }

    @Transactional(readOnly = true)
    public Page<AplicacaoInstaleSoftDTO> modeloProdutoVi(Integer ano, Long categoriaId, Long modeloId, Integer vidroConvencional,
                                                         Integer vidroInteligente, Pageable pageable) {
        Page<AplicacaoInstaleSoft> list = repository.modeloProdutoVI(ano, categoriaId, modeloId, vidroConvencional,
                vidroInteligente, pageable);
        return list.map(x -> new AplicacaoInstaleSoftDTO(x, ano));
    }

    @Transactional(readOnly = true)
    public Page<ProdutoporAplicacaoMinDTO> produtoAplicacao(Long categoryInstaleSoftId, Pageable pageable){
        Page<ProdutoPorAplicacaoProjection> list = repository.produtoPorAplicacao(categoryInstaleSoftId, pageable);
        return list.map(x -> new ProdutoporAplicacaoMinDTO(x));
    }

    @Transactional(readOnly = true)
    public Page<ProdutosPorModeloMinDTO> produtoModelo(Long produtctId, Long categoryInstaleSoftId, Pageable pageable){
        Page<ProdutosPorModelosProjection> list = repository.produtoPorModelo(produtctId,categoryInstaleSoftId, pageable);

        return list.map(x -> new ProdutosPorModeloMinDTO(x));
    }

    @Transactional(readOnly = true)
    public Page<ProdutosPorModeloMinDTO> produtoModeloFiltroMontadora(Long produtctId, Long categoryInstaleSoftId,
                                                                      String montadoraName, Pageable pageable){
        Page<ProdutosPorModelosProjection> list = repository.produtoPorModeloFiltroMontadora(produtctId,categoryInstaleSoftId,
                montadoraName,pageable);

        return list.map(x -> new ProdutosPorModeloMinDTO(x));
    }
    @Transactional(readOnly = true)
    public Page<ProdutosPorModeloMinDTO> produtoModeloFiltroModeloName(Long produtctId, Long categoryInstaleSoftId,
                                                                       String modeloName, Pageable pageable){
        Page<ProdutosPorModelosProjection> list = repository.produtoPorModeloFiltroModeloName(produtctId,categoryInstaleSoftId,
                modeloName,pageable);

        return list.map(x -> new ProdutosPorModeloMinDTO(x));
    }
    @Transactional
    public AplicacaoInstaleSoftInsertDTO insert(AplicacaoInstaleSoftInsertDTO dto) {
        AplicacaoInstaleSoft entity = new AplicacaoInstaleSoft();
        copyDtoToEntity(dto, entity);
        entity.setCreatedAt(Instant.now());
        entity.setUpdatedAt(Instant.now());
        entity = repository.save(entity);
        // Criando registro de auditoria
        salvarAuditoria("InstaleSoft Id " + entity.getId() +
                        "InstaleSoft Modelo Adicionado " + entity.getModeloInstalesoft().getName());

        return new AplicacaoInstaleSoftInsertDTO(entity);
    }
    @Transactional
    public AplicacaoInstaleSoftInsertDTO update(Long id, AplicacaoInstaleSoftInsertDTO dto) {
        try {
            AplicacaoInstaleSoft entity = repository.findById(id)
                    .orElseThrow(()-> new ResourceNotFoundException("Id not found " + id));
            copyDtoToEntity(dto, entity);
            entity.setUpdatedAt(Instant.now());
            entity = repository.save(entity);
            // Criando registro de auditoria
            salvarAuditoria("InstaleSoft Id " + entity.getId() +
                    "InstaleSoft Modelo Atualizado " + entity.getModeloInstalesoft().getName());
            return new AplicacaoInstaleSoftInsertDTO(entity);
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
            AplicacaoInstaleSoft entity = repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));

            repository.deleteById(id);
            // Criando registro de auditoria
            salvarAuditoria("InstaleSoft Id " + entity.getModeloInstalesoft().getName());

        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(AplicacaoInstaleSoftInsertDTO dto, AplicacaoInstaleSoft entity) {
        // Busca o modelo no banco
        ModeloInstalesoft modeloInstalesoft = modeloInstalesoftRepository.findById(dto.getModeloInstalesoftId())
                .orElseThrow(() -> new ResourceNotFoundException("ModeloInstalesoft not found"));
        entity.setModeloInstalesoft(modeloInstalesoft);

        entity.setAnoDe(dto.getAnoDe());
        entity.setAnoAte(dto.getAnoAte());

        // Busca a categoria no banco
        CategoryProductInstaleSoft categoryProductInstaleSoft = categoryProductInstaleSoftRepository.findById(dto.getCategoryInstaleSoftId())
                .orElseThrow(() -> new ResourceNotFoundException("CategoryProductInstaleSoft not found"));
        entity.setCategoryProductInstaleSoft(categoryProductInstaleSoft);

        // Busca o produto principal no banco
        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        entity.setProducts(product);

        entity.setQuantidade(dto.getQuantidade());
        entity.setVidroConvencional(dto.getVidroConvencional());
        entity.setVidroInteligente(dto.getVidroInteligente());
        entity.setPortas2(dto.getPortas2());
        entity.setPortas4(dto.getPorta4());
        entity.setObservacao(dto.getObservacao());
        entity.setUrlEsquema(dto.getUrlEsquema());
        entity.setUrlVideo(dto.getUrlVideo());

        // Busca o produto auxiliar no banco
        if (dto.getProductId2() != null) {
            ProductAuxiliar products2 = productAuxiliarRepository.findById(dto.getProductId2())
                    .orElseThrow(() -> new ResourceNotFoundException("ProductAuxiliar not found"));
            entity.setProducts2(products2);
        }
        entity.setQuantidade2(dto.getQuantidade2());
        entity.setVidroConvencional2(dto.getVidroConvencional2());
        entity.setVidroInteligente2(dto.getVidroInteligente2());
        entity.setObservacao2(dto.getObservacao2());
        entity.setUrlEsquema2(dto.getUrlEsquema2());
        entity.setUrlVideo2(dto.getUrlVideo2());

        entity.setCombo(dto.getCombo());
        entity.setActive(dto.getActive());
    }


    private void updateDtoToEntity(AplicacaoInstaleSoftInsertDTO dto, AplicacaoInstaleSoft entity) {
        ModeloInstalesoft modeloInstalesoft = new ModeloInstalesoft();
        modeloInstalesoft.setId(dto.getModeloInstalesoftId());
        entity.setModeloInstalesoft(modeloInstalesoft);

        entity.setAnoDe(dto.getAnoDe());
        entity.setAnoAte(dto.getAnoAte());

        CategoryProductInstaleSoft categoryProductInstaleSoft = new CategoryProductInstaleSoft();
        categoryProductInstaleSoft.setId(dto.getCategoryInstaleSoftId());
        entity.setCategoryProductInstaleSoft(categoryProductInstaleSoft);

        Product product = new Product();
        product.setId(dto.getProductId());
        entity.setProducts(product);

        entity.setObservacao(dto.getObservacao());
        entity.setUrlEsquema(dto.getUrlEsquema());
        entity.setUrlVideo(dto.getUrlVideo());
        entity.setQuantidade(dto.getQuantidade());
        entity.setVidroConvencional(dto.getVidroConvencional());
        entity.setVidroInteligente(dto.getVidroInteligente());
        entity.setPortas2(dto.getPortas2());
        entity.setPortas4(dto.getPorta4());

        ProductAuxiliar products2 = new ProductAuxiliar();
        products2.setId(dto.getProductId2());
        entity.setProducts2(products2);
        entity.setObservacao2(dto.getObservacao2());
        entity.setUrlEsquema(dto.getUrlEsquema2());
        entity.setUrlVideo(dto.getUrlVideo2());
        entity.setQuantidade(dto.getQuantidade2());
        entity.setVidroConvencional(dto.getVidroConvencional2());
        entity.setVidroInteligente(dto.getVidroInteligente2());


        entity.setCombo(dto.getCombo());
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
