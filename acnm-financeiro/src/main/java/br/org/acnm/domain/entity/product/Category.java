package br.org.acnm.domain.entity.product;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;

import org.hibernate.annotations.ColumnTransformer; 

@Entity
@Table(name = "category", schema = "public", uniqueConstraints = {
        @UniqueConstraint(
            name = "uk_category_path",
            columnNames = "path"
        )
    })
public class Category extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    public Integer id;

    @NotBlank(message = "O nome da categoria é obrigatório")
    @Column(nullable = false)
    public String name;

    @Column(name = "path", nullable = false, columnDefinition = "ltree")
    @ColumnTransformer(
        read = "path::text",
        write = "?::ltree"
    )
    public String path;
}