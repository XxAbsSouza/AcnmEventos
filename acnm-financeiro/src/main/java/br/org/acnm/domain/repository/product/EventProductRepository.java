package br.org.acnm.domain.repository.product;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

import br.org.acnm.domain.entity.product.EventProduct;

@ApplicationScoped
public class EventProductRepository implements PanacheRepositoryBase<EventProduct, Integer> {

    public List<EventProduct> findByEventIdAndActive(Integer eventId, Boolean isActive) {
        return find("SELECT ep FROM EventProduct ep " +
                    "JOIN FETCH ep.globalProduct gp " +
                    "JOIN FETCH gp.category c " +
                    "WHERE ep.event.id = ?1 AND ep.isActive = ?2 " +
                    "ORDER BY c.name ASC, gp.name ASC", eventId, isActive).list();
    }
public List<EventProduct> findPriceAlteredProducts(Integer eventId) {
        return find("SELECT DISTINCT ep FROM TabTransaction tx " +
                    "JOIN tx.eventProduct ep " +
                    "JOIN FETCH ep.globalProduct gp " +
                    "JOIN FETCH gp.category c " +
                    "WHERE ep.event.id = ?1 AND tx.unitPriceApplied != ep.unitPrice " +
                    "ORDER BY c.name ASC, gp.name ASC", eventId).list();
    }
}