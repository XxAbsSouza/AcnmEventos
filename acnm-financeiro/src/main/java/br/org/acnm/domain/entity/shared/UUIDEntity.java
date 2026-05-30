package br.org.acnm.domain.entity.shared;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public abstract class UUIDEntity extends SyncEntity {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    public UUID id;
}