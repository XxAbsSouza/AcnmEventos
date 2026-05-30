package br.org.acnm.domain.repository.product;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

import br.org.acnm.domain.entity.product.GlobalProduct;

@ApplicationScoped
public class GlobalProductRepository implements PanacheRepositoryBase<GlobalProduct, Integer> {

    public List<GlobalProduct> listAllWithCategory() {
        return find("""
                SELECT gp
                FROM GlobalProduct gp
                JOIN FETCH gp.category
                ORDER BY gp.category.name, gp.name
                """).list();
    }

    public List<GlobalProduct> findByCategoryId(Integer categoryId) {
        return find("category.id", categoryId).list();
    }

    @SuppressWarnings("unchecked")
    public List<GlobalProduct> findProductsByCategoryHierarchy(Integer categoryId) {
        return getEntityManager().createNativeQuery("""
                SELECT gp.* FROM global_product gp
                JOIN category c ON gp.category_id = c.id
                WHERE c.path <@ (SELECT cat.path FROM category cat WHERE cat.id = :categoryId)
                """, GlobalProduct.class)
                .setParameter("categoryId", categoryId)
                .getResultList();
    }
}