package br.org.acnm.domain.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import br.org.acnm.domain.enums.PaymentMethod;

@Entity
@Table(name = "tab_payment") 
public class TabPayment extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "tab_id") 
    public Tab tab; 

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "received_by_user_id") 
    public AppUser  appUser; 

    public Integer amount;

    @Column(name = "payment_method") 
    @Enumerated(EnumType.STRING)
    public PaymentMethod paymentMethod;

    @Column(name = "sync_status")
    public String syncStatus;

    @Column(name = "device_created_at")
    public LocalDateTime deviceCreatedAt;

    @CreationTimestamp
    @Column(name = "server_created_at")
    public LocalDateTime serverCreatedAt;
}
