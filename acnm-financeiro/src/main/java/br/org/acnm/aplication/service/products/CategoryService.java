package br.org.acnm.aplication.service.products;

import java.util.List;
import java.util.stream.Collectors;

import br.org.acnm.aplication.dto.products.CategoryRequestDTO;
import br.org.acnm.aplication.dto.products.CategoryResponseDTO;
import br.org.acnm.domain.entity.product.Category;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class CategoryService {

    @Transactional
    public CategoryResponseDTO create(CategoryRequestDTO request) {
        Category category = new Category();
        category.name = request.name();
        
        category.persist(); 
        
        if (request.parentId() != null) {
            Category parent = Category.findByIdOptional(request.parentId())
                    .map(p -> (Category) p)
                    .orElseThrow(() -> new NotFoundException("Categoria pai não encontrada."));
            
            category.path = parent.path + "." + category.id;
        } else {
            category.path = String.valueOf(category.id);
        }
        
        return new CategoryResponseDTO(category);
    }

    public List<CategoryResponseDTO> listAll() {
        return Category.listAll().stream()
                .map(entity -> new CategoryResponseDTO((Category) entity))
                .collect(Collectors.toList());
    }

    public CategoryResponseDTO findById(Integer id) {
        return Category.findByIdOptional(id)
                .map(entity -> new CategoryResponseDTO((Category) entity))
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada para o ID informado."));
    }
}