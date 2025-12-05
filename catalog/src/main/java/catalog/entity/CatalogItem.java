package catalog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "catalog_item")
public class CatalogItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_value")
    private String value;

    private String name;

    private LocalDateTime modified;

    public CatalogItem(String value, String name, LocalDateTime modified) {
        this.value = value;
        this.name = name;
        this.modified = modified;
    }

    @ManyToOne
    @JoinColumn(name = "catalog_id", nullable = false)
    private Catalog catalog;

    @OneToMany(mappedBy = "catalogItem")
    private List<CatalogItemHistory> historyList = new ArrayList<>();

    public void addHistory(CatalogItemHistory history) {
        this.historyList.add(history);
        history.setCatalogItem(this);
    }

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
