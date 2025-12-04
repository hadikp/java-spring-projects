package catalog.repository;

import catalog.entity.CatalogItemHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogItemHistoryRepository extends JpaRepository<CatalogItemHistory, Long> {

    void deleteByCatalogItemId(Long catalogItemId);
}
