package br.org.acnm.model.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "card")
public class Card extends PanacheEntityBase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @Column(name = "card_number", unique = true)
    public Integer cardNumber;

    @Column(name = "access_token", unique = true)
    public String accessToken;

    @Column(name = "is_active")
    public Boolean isActive = true;
}