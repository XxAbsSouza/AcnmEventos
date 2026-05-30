package br.org.acnm.domain.entity.tab;


import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import br.org.acnm.domain.enums.TabAction;
import br.org.acnm.domain.entity.product.EventProduct;
import br.org.acnm.domain.entity.shared.SyncEntity;
import br.org.acnm.domain.entity.users.AppUser;

@Entity
@Table(name = "tab_transaction")
public class TabTransaction extends SyncEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tab_id", nullable = false)
    public Tab tab;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_product_id", nullable = false)
    public EventProduct eventProduct;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "created_by_user_id", nullable = false)
    public AppUser createdByUser; 

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "action", nullable = false, length = 15)
    public TabAction action;
    
    @NotNull
    @Positive
    @Column(name = "quantity", nullable = false)
    public Integer quantity;

    @NotNull
    @PositiveOrZero
    @Column(name = "unit_price", nullable = false) 
    public Integer unitPrice;

    @Column(name = "notes")
    public String notes;

    @NotNull
    @Column(name = "needs_review", nullable = false)
    public boolean needsReview = false;
}