package br.org.acnm.domain.entity.users;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "person")
public class Person extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    public UUID id;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "user_id",
        unique = true,
        foreignKey = @ForeignKey(name = "fk_person_user")
    )
    public AppUser appUser; 

    @NotBlank(message = "First name não pode ser vazio")
    @Column(name = "first_name", nullable = false)
    public String firstName;

    @Column(name = "last_name") 
    public String lastName;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;
}