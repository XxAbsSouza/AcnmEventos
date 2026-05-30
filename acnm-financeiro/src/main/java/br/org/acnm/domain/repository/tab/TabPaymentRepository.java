package br.org.acnm.domain.repository.tab;

import br.org.acnm.aplication.dto.tab.PaymentMethodSummaryDTO;
import br.org.acnm.domain.entity.tab.TabPayment;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TabPaymentRepository implements PanacheRepositoryBase<TabPayment, UUID> {

    public List<TabPayment> findByTabId(UUID tabId) {
        return find("tab.id = ?1 ORDER BY deviceCreatedAt ASC", tabId).list();
    }

 public List<PaymentMethodSummaryDTO> sumPaymentsByMethod(Integer eventId) {

        return getEntityManager()
                .createQuery("""
                    SELECT new br.org.acnm.aplication.dto.tab.PaymentMethodSummaryDTO(
                        tp.paymentMethod,
                        SUM(tp.amount)
                    )
                    FROM TabPayment tp
                    WHERE tp.tab.event.id = :eventId
                    GROUP BY tp.paymentMethod
                    """, PaymentMethodSummaryDTO.class)
                .setParameter("eventId", eventId)
                .getResultList();
    }
}