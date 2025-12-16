package catalog.repository;

import catalog.entity.Catalog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {
    @Query("SELECT c FROM Catalog c LEFT JOIN FETCH c.historyList WHERE c.id = :id")
    Optional<Catalog> findByIdWithItemsAndHistory(@Param("id") Long id);

}
