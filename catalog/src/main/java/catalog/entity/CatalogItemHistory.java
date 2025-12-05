package catalog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "catalog_item_history")
public class CatalogItemHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String parameter;

    private String comment;

    private LocalDateTime modified;

    public CatalogItemHistory(String parameter, String comment) {
        this.parameter = parameter;
        this.comment = comment;
    }

    @ManyToOne
    @JoinColumn(name = "catalog_item_id", nullable = false)
    private CatalogItem catalogItem;

    @PrePersist
    public void onCreate() {
        if (modified == null) {
            modified = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void onUpdate() {
        modified = LocalDateTime.now();
    }
}
