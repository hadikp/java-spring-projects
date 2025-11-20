package catalog.controller;

import catalog.dto.CatalogDto;
import catalog.dto.CatalogItemDto;
import catalog.request.CatalogItemCreateRequest;
import catalog.service.CatalogItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog-item")
public class CatalogItemController {

    private CatalogItemService service;

    public CatalogItemController(CatalogItemService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<CatalogItemDto> createCatalogItem (@RequestBody CatalogItemCreateRequest catalogItemCreateRequest){
        CatalogItemDto created = service.createCatalogItem(catalogItemCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
