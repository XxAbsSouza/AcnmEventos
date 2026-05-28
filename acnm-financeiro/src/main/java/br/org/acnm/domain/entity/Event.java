package br.org.acnm.domain.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "event")
public class Event extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    public String title;
    @Column(name = "start_time")
    public LocalDateTime startTime;
    @Column(name = "end_time")
    public LocalDateTime endTime;
}