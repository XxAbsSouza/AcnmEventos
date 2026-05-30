package br.org.acnm.domain.entity.event;


import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;

import br.org.acnm.domain.entity.shared.SyncEntity;
import br.org.acnm.domain.entity.users.Person;
import br.org.acnm.domain.enums.DonationType;

@Entity
@Table(name = "donation") 
public class Donation extends SyncEntity  {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_id", nullable = false) 
    public Event event; 

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable = false) 
    public Person person; 

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    public DonationType type;
    
    @NotNull
    @Column(nullable = false)
    public Integer amount;
    
    @Column(name = "product_description") 
    public String productDescription;
}
