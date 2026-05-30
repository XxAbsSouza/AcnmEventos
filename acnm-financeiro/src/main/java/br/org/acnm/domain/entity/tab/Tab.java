package br.org.acnm.domain.entity.tab;

import br.org.acnm.domain.entity.event.Event;
import br.org.acnm.domain.entity.shared.SyncEntity;
import br.org.acnm.domain.entity.users.Person;
import br.org.acnm.domain.enums.TabStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tab")
public class Tab extends SyncEntity {
    
    @NotNull
    @Column(name = "tab_number", nullable = false)
    public Integer tabNumber;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_id", nullable = false)
    public Event event;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    public Person person;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    public Card card;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    public TabStatus status;
    
}