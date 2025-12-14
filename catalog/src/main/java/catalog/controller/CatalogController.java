package catalog.controller;

import catalog.dto.CatalogAndItemsDto;
import catalog.service.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private CatalogService service;

    public CatalogController(CatalogService service) {
        this.service = service;
    }

    @GetMapping
    private ResponseEntity<List<CatalogAndItemsDto>> getAllCatalogs() {
        List<CatalogAndItemsDto> catalogs = service.getAllCatalogs();
        return ResponseEntity.ok(catalogs);
    }

    @GetMapping("/{id}")
    private ResponseEntity<CatalogAndItemsDto> getCatalogById(@PathVariable("id") Long id) {
        CatalogAndItemsDto catalogDto = service.findCatalogById(id);
        return ResponseEntity.ok(catalogDto);
    }
}
