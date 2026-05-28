package br.org.acnm.domain.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import br.org.acnm.domain.enums.DonationType;

@Entity
@Table(name = "donation") 
public class Donation extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id") 
    public Event event; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id") 
    public Client client; 

    @Enumerated(EnumType.STRING)
    public DonationType type;
    
    public Integer amount;
    
    @Column(name = "product_description") 
    public String productDescription;

    @Column(name = "sync_status")
    public String syncStatus;

    @Column(name = "device_created_at")
    public LocalDateTime deviceCreatedAt;

    @CreationTimestamp
    @Column(name = "server_created_at")
    public LocalDateTime serverCreatedAt;
}
