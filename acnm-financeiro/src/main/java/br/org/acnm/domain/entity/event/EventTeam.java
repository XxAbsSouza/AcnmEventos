package br.org.acnm.domain.entity.event;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import br.org.acnm.domain.entity.users.AppUser;
import br.org.acnm.domain.enums.RoleType;

@Entity
@Table(name = "event_team", uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_event_team_event_user",
            columnNames = {"event_id", "user_id"}
        )
    }) 
public class EventTeam extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    public AppUser user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_id", nullable = false) 
    public Event event;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "role_type", nullable = false, length = 20)
    public RoleType roleType;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    public LocalDateTime createdAt;
}
