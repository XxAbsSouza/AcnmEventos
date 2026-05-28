package br.org.acnm.domain.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import br.org.acnm.domain.enums.RoleType;

@Entity
@Table(name = "event_team") 
public class EventTeam extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public AppUser appUser;

    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "event_id") 
    public Event event;

    @Column(name = "role_type") 
    @Enumerated(EnumType.STRING)
    public RoleType roleType;

    @CreationTimestamp
    @Column(name = "created_at")
    public LocalDateTime createdAt;
}
