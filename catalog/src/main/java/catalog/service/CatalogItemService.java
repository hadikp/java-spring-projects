package catalog.service;

import catalog.dto.CatalogDto;
import catalog.dto.CatalogItemDto;
import catalog.dto.ParameterDto;
import catalog.entity.Catalog;
import catalog.entity.CatalogItem;
import catalog.entity.CatalogItemHistory;
import catalog.exception.CatalogItemWithoutCatalogException;
import catalog.exception.CatalogNotFoundException;
import catalog.repository.CatalogItemHistoryRepository;
import catalog.repository.CatalogItemRepository;
import catalog.repository.CatalogRepository;
import catalog.request.CatalogItemCreateRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CatalogItemService {

    private CatalogRepository catalogRepository;

    private CatalogItemRepository catalogItemRepository;

    private CatalogItemHistoryRepository historyRepository;

    private CatalogItemRepository repository;

    private ObjectMapper objectMapper;

    private ModelMapper modelMapper;

    @Transactional
    public CatalogItemDto createCatalogItem(CatalogItemCreateRequest catalogItemCreateRequest) {
        Long catalogId = catalogItemCreateRequest.getCatalogId();
        String catalogName = catalogItemCreateRequest.getName();
        String catalogItemValue = catalogItemCreateRequest.getValue();

        Catalog catalog = catalogRepository.findById(catalogId).orElseThrow(() -> new CatalogNotFoundException(catalogId));
        if (catalogItemRepository.existsByCatalogIdAndName(catalogId, catalogName)) {
            throw new IllegalStateException("Már létezik ilyen elem ebben a katalógusban: " + catalogName);
        }

        CatalogItem newCatalogItem = new CatalogItem(catalogItemValue, catalogName, LocalDateTime.now());
        catalog.addCatalogItem(newCatalogItem);
        catalogItemRepository.save(newCatalogItem);

        // --- History parameter JSON felépítése Jacksonnal a típusos DTO-ból ---
        ParameterDto param = new ParameterDto(catalogItemValue, catalogName);
        String parameterJson;
        try {
            parameterJson = objectMapper.writeValueAsString(param);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Nem sikerült a history JSON szerializálása.", e);
        }

        // --- History létrehozása ---
        CatalogItemHistory history = new CatalogItemHistory(parameterJson, "Elem létrehozva: ");
        newCatalogItem.addHistory(history);
        historyRepository.save(history);


        catalogRepository.save(catalog);
        return modelMapper.map(newCatalogItem, CatalogItemDto.class);
    }

    public void deleteCatalogItem(Long itemId) {
        CatalogItem catalogItem = repository.findById(itemId).orElseThrow();
        Catalog catalog = catalogItem.getCatalog();
        if (catalog == null) {
            throw new CatalogItemWithoutCatalogException(itemId);
        }
        // Töröljük a history rekordokat
        historyRepository.deleteByCatalogItemId(itemId);

        // Eltávolítjuk az elemet a katalógusból
        catalog.removeCatalogItem(catalogItem);

        // Mentjük a katalógust (orphanRemoval miatt törlődik az elem)
        catalogRepository.save(catalog);
    }
}
