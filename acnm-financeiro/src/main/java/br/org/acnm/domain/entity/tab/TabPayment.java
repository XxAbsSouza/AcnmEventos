package br.org.acnm.domain.entity.tab;


import br.org.acnm.domain.entity.shared.SyncEntity;
import br.org.acnm.domain.entity.users.AppUser;
import br.org.acnm.domain.enums.PaymentMethod;
import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "tab_payment") 
public class TabPayment extends SyncEntity {
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false) 
    @JoinColumn(name = "tab_id", nullable = false) 
    public Tab tab; 

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false) 
    @JoinColumn(name = "received_by_user_id", nullable = false) 
    public AppUser receivedByUser; 

    @NotNull
    @Positive
    @Column(name = "amount", nullable = false)
    public Integer amount;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false, length = 20) 
    public PaymentMethod paymentMethod;
}