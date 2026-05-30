package br.org.acnm.domain.entity.product;

import br.org.acnm.domain.entity.event.Event;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;

@Entity
@Table(
    name = "event_product",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_event_product_event_global", columnNames = {"event_id", "global_product_id"})
    }
)
public class EventProduct extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    public Event event;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "global_product_id", nullable = false)
    public GlobalProduct globalProduct;

    @NotNull
    @Column(name = "unit_price", nullable = false)
    public Integer unitPrice;

    @NotNull
    @Column(name = "is_active", nullable = false)
    public Boolean isActive = true;
}