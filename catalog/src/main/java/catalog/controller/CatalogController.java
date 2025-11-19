package catalog.controller;

import catalog.dto.CatalogDto;
import catalog.service.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    private ResponseEntity<List<CatalogDto>> getAllCatalogs() {
        List<CatalogDto> catalogs = service.getAllCatalogs();
        return ResponseEntity.ok(catalogs);
    }
}
