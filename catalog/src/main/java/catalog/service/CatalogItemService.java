package catalog.service;

import catalog.dto.CatalogItemDto;
import catalog.dto.ParameterDto;
import catalog.entity.Catalog;
import catalog.entity.CatalogItem;
import catalog.entity.CatalogItemHistory;
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
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CatalogItemService {

    private CatalogRepository catalogRepository;

    private CatalogItemRepository catalogItemRepository;

    private CatalogItemHistoryRepository historyRepository;

    private ObjectMapper objectMapper;

    private ModelMapper modelMapper;

    @Transactional
    public CatalogItemDto createCatalogItem(CatalogItemCreateRequest catalogItemCreateRequest) {
        Long catalogId = catalogItemCreateRequest.getCatalogId();
        String catalogItemName = catalogItemCreateRequest.getName();
        String catalogItemValue = catalogItemCreateRequest.getValue();

        Catalog catalog = catalogRepository.findById(catalogId).orElseThrow(() -> new CatalogNotFoundException(catalogId));
        if (catalogItemRepository.existsByCatalogIdAndName(catalogId, catalogItemName)) {
            throw new IllegalStateException("Már létezik ilyen elem ebben a katalógusban: " + catalogItemName);
        }

        CatalogItem newCatalogItem = new CatalogItem(catalogItemValue, catalogItemName, LocalDateTime.now());
        catalog.addCatalogItem(newCatalogItem);

        // --- History parameter JSON felépítése Jacksonnal a típusos DTO-ból ---
        List<ParameterDto> itemsToSave = catalogItemCreateRequest.getCurrentItems();

        if(itemsToSave == null) {
            itemsToSave = new ArrayList<>();
            itemsToSave.add(new ParameterDto(catalogItemValue, catalogItemName));
        }

        String parameterJson;
        try {
            parameterJson = objectMapper.writeValueAsString(itemsToSave);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Nem sikerült a history JSON szerializálása.", e);
        }

        // --- History létrehozása ---
        CatalogItemHistory history = new CatalogItemHistory(parameterJson, "Űj Elem létrehozva: ");
        catalog.addHistory(history);

        catalogRepository.save(catalog);
        return modelMapper.map(newCatalogItem, CatalogItemDto.class);
    }

    public void deleteCatalogItem(Long itemId) {
        CatalogItem catalogItem = catalogItemRepository.findById(itemId).orElseThrow();
        Catalog catalog = catalogItem.getCatalog();

        if (catalog != null) {
            catalog.removeCatalogItem(catalogItem);
            catalogRepository.save(catalog);
        } else {
            // Ha nincs szülője mehet a direkt törlés
            catalogItemRepository.delete(catalogItem);
        }

    }
}
