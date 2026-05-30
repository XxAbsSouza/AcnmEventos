package br.org.acnm.domain.entity.product;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(
    name = "global_product",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_global_product_category_name", columnNames = {"category_id", "name"})
    }
)
public class GlobalProduct extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    public Category category;

    @NotBlank(message = "O nome do produto é obrigatório")
    @Column(nullable = false)
    public String name;
}