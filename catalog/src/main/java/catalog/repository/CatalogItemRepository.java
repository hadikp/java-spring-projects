package catalog.repository;

import catalog.entity.CatalogItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatalogItemRepository extends JpaRepository<CatalogItem, Long> {

    boolean existsByCatalogIdAndName(Long catalogId, String name);

    // Ha mindent látni akarsz (törölteket is):
    List<CatalogItem> findByCatalogId(Long catalogId);

    // Ha konkrétan a törölteket keresed:
    List<CatalogItem> findByCatalogIdAndDeletedTrue(Long catalogId);
}
