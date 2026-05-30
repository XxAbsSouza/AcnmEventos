package br.org.acnm.aplication.service.products;

import java.util.List;
import java.util.stream.Collectors;

import br.org.acnm.aplication.dto.products.GlobalProductRequestDTO;
import br.org.acnm.aplication.dto.products.GlobalProductResponseDTO;
import br.org.acnm.domain.entity.product.Category;
import br.org.acnm.domain.entity.product.GlobalProduct;
import br.org.acnm.domain.repository.product.GlobalProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class GlobalProductService {

    @Inject
    GlobalProductRepository globalProductRepository; 

    @Transactional
    public GlobalProductResponseDTO create(GlobalProductRequestDTO request) {
        Category category = Category.findByIdOptional(request.categoryId())
                .map(cat -> (Category) cat)
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada."));

        GlobalProduct product = new GlobalProduct();
        product.name = request.name();
        product.category = category;

        globalProductRepository.persist(product);

        return new GlobalProductResponseDTO(product);
    }

    public List<GlobalProductResponseDTO> listAll() {
        return globalProductRepository.listAllWithCategory().stream()
                .map(GlobalProductResponseDTO::new)
                .collect(Collectors.toList());
    }

    public GlobalProductResponseDTO findById(Integer id) {
        return globalProductRepository.findByIdOptional(id)
                .map(GlobalProductResponseDTO::new)
                .orElseThrow(() -> new NotFoundException("Produto global não encontrado para o ID informado."));
    }

    public List<GlobalProductResponseDTO> findByCategoryHierarchy(Integer categoryId) {
        return globalProductRepository.findProductsByCategoryHierarchy(categoryId).stream()
                .map(GlobalProductResponseDTO::new)
                .collect(Collectors.toList());
    }
}