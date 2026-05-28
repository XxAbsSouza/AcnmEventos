package br.org.acnm.domain.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "client")
public class Client extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true) 
    public AppUser appUser; 

    @Column(name = "first_name") 
    public String firstName;
    @Column(name = "last_name") 
    public String lastName;

    public String phone;
}