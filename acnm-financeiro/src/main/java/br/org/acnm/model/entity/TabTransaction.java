package br.org.acnm.model.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import br.org.acnm.model.enums.TabAction;

@Entity
@Table(name = "tab_transaction")
public class TabTransaction extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tab_id")
    public Tab tab;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_product_id")
    public EventProduct eventProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_user_id")
    public AppUser user; 

    @Enumerated(EnumType.STRING)
    public TabAction action;
    
    public Integer quantity;

    @Column(name = "unit_price") 
    public Integer unitPrice;

    public String notes;

    @Column(name = "needs_review")
    public Boolean needsReview;

    @Column(name = "sync_status")
    public String syncStatus;

    @Column(name = "device_created_at")
    public LocalDateTime deviceCreatedAt;

    @CreationTimestamp
    @Column(name = "server_created_at")
    public LocalDateTime serverCreatedAt;
}