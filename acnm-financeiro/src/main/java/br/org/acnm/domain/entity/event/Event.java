package br.org.acnm.domain.entity.event;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "event")
public class Event extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @NotBlank(message = "O título do evento não pode ser vazio")
    @Column(nullable = false)
    public String title;
    
    @NotBlank(message = "A data de início é obrigatória")
    @Column(name = "start_time", nullable = false)
    public LocalDateTime startTime;

    @Column(name = "end_time")
    public LocalDateTime endTime;
}