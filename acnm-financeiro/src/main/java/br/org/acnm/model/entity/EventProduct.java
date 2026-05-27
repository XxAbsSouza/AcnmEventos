package br.org.acnm.model.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "event_product") 
public class EventProduct extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "event_id") 
    public Event event;

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "global_product_id") 
    public GlobalProduct globalProduct; 

    @Column(name = "unit_price") 
    public Integer unitPrice;

    @Column(name = "is_active") 
    public Boolean isActive;
}