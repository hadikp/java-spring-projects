package catalog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DialectOverride;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String parameter;

    private LocalDateTime modified;

    @OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL, orphanRemoval = true)
    @Where(clause = "deleted = false") // soft delete miatt
    private List<CatalogItem> catalogItems = new ArrayList<>();

    @OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<CatalogItemHistory> historyList = new ArrayList<>();

    public void addCatalogItem(CatalogItem catalogItem) {
        if (catalogItem == null) {
            throw new IllegalArgumentException("CatalogItem nem lehet null");
        }
        if (!catalogItems.contains(catalogItem)) {
            catalogItems.add(catalogItem);
            catalogItem.setCatalog(this);
        }
    }

    public void removeCatalogItem(CatalogItem catalogItem) {
        if (catalogItem == null) {
            throw new IllegalArgumentException("CatalogItem nem lehet null");
        }
        if (catalogItems.contains(catalogItem)) {
            catalogItems.remove(catalogItem);
            catalogItem.setCatalog(null); // Kapcsolat megszüntetése
        }
    }

    public void addHistory(CatalogItemHistory history){
        if(history == null) {
            throw new IllegalArgumentException("A history nem lehet null");
        }
        if (!historyList.contains(history)) {
            this.historyList.add(history);
            history.setCatalog(this);
        }
    }
}
