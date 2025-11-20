package catalog.repository;

import catalog.entity.CatalogItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogItemRepository extends JpaRepository<CatalogItem, Long> {

    boolean existsByCatalogIdAndName(Long catalogId, String name);
}
