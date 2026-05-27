package br.org.acnm.model.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.time.LocalDateTime; 
import org.hibernate.annotations.CreationTimestamp;
import java.util.UUID;

@Entity
@Table(name = "app_user") 
public class AppUser extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    public String username;
    
    public String email;

    @Column(name = "password_hash") 
    public String passwordHash;

    @CreationTimestamp
    @Column(name = "created_at")
    public LocalDateTime createdAt;
}