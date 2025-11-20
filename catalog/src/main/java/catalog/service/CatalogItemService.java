package catalog.service;

import catalog.dto.CatalogDto;
import catalog.dto.CatalogItemDto;
import catalog.entity.Catalog;
import catalog.entity.CatalogItem;
import catalog.exception.CatalogNotFoundException;
import catalog.repository.CatalogItemRepository;
import catalog.repository.CatalogRepository;
import catalog.request.CatalogItemCreateRequest;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CatalogItemService {

    private CatalogRepository catalogRepository;

    private CatalogItemRepository repository;

    private ModelMapper modelMapper;

    public CatalogItemDto createCatalogItem(CatalogItemCreateRequest catalogItemCreateRequest) {
        Long catalogId = catalogItemCreateRequest.getCatalogId();
        String catalogName = catalogItemCreateRequest.getName();
        Catalog catalog = catalogRepository.findById(catalogId).orElseThrow(() -> new CatalogNotFoundException(catalogId));

        if (repository.existsByCatalogIdAndName(catalogId, catalogName)) {
            throw new IllegalStateException("Már létezik ilyen elem ebben a katalógusban: " + catalogName);
        }

        CatalogItem newCatalogItem = new CatalogItem(catalogItemCreateRequest.getItemValue(), catalogName, LocalDateTime.now());

        catalog.addCatalogItem(newCatalogItem);
        repository.save(newCatalogItem);
        return modelMapper.map(newCatalogItem, CatalogItemDto.class);
    }
}
