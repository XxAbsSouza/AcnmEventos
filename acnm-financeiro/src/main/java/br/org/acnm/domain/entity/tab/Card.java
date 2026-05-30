package br.org.acnm.domain.entity.tab;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(
    name = "card",
    indexes = {
        @Index(name = "idx_card_number", columnList = "card_number"),
        @Index(name = "idx_card_access_token", columnList = "access_token")
    }
)
public class Card extends PanacheEntityBase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    public Long id;

    @Column(name = "card_number", unique = true)
    public Integer cardNumber;

    @Column(name = "access_token", unique = true)
    public String accessToken;

    @Column(name = "is_active", nullable = false)
    public boolean isActive = true;
}