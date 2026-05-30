package br.org.acnm.domain.entity.users;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;

import br.org.acnm.domain.enums.UserRole;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "app_user", uniqueConstraints = {
    @UniqueConstraint(name = "uk_user_email", columnNames = "email"),
    @UniqueConstraint(name = "uk_user_username", columnNames = "username")
})
public class AppUser extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @NaturalId 
    @NotBlank(message = "Username não pode ser vazio")
    @Column(nullable = false)
    public String username;
    
    @NaturalId 
    @Email(message = "Email inválido")
    @NotBlank
    @Column(nullable = false)
    public String email;

    @Column(name = "password_hash", nullable = false) 
    public String passwordHash;
    
    public String phone;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false, length = 20)
    public UserRole userRole = UserRole.USER;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    public LocalDateTime createdAt;
}