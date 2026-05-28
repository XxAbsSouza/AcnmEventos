package br.org.acnm.domain.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.util.UUID;
import java.time.LocalDateTime; 
import org.hibernate.annotations.CreationTimestamp;

import br.org.acnm.domain.enums.TabStatus;

@Entity
@Table(name = "tab")
public class Tab extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    public Event event;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    public Client client;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    public Card card;
    
    @Enumerated(EnumType.STRING)
    public TabStatus status;
    
    @Column(name = "device_created_at")
    public LocalDateTime deviceCreatedAt;
    
    @CreationTimestamp
    @Column(name = "server_created_at")
    public LocalDateTime serverCreatedAt;
    
    @Column(name = "sync_status")
    public String syncStatus;
    
    @Column(name = "tab_number")
    public Integer tabNumber;
}