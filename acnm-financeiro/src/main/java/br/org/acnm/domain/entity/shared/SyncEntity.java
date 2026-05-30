package br.org.acnm.domain.entity.shared;

import br.org.acnm.domain.enums.SyncStatus;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

@MappedSuperclass
public abstract class SyncEntity extends PanacheEntityBase {

    @Enumerated(EnumType.STRING)
    @Column(name = "sync_status", nullable = false, length = 15)
    public SyncStatus syncStatus = SyncStatus.PENDING;

    @Column(name = "device_created_at")
    public LocalDateTime deviceCreatedAt;

    @CreationTimestamp
    @Column(name = "server_created_at", nullable = false, updatable = false)
    public LocalDateTime serverCreatedAt;
}