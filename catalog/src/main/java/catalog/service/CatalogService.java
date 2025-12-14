package catalog.service;

import catalog.dto.CatalogAndItemsDto;
import catalog.entity.Catalog;
import catalog.exception.CatalogNotFoundException;
import catalog.repository.CatalogRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CatalogService {

    private CatalogRepository repository;

    private ModelMapper modelMapper;


    public List<CatalogAndItemsDto> getAllCatalogs() {
        List<Catalog> catalogs = repository.findAll();
        return catalogs.stream().map(c -> modelMapper.map(c, CatalogAndItemsDto.class)).collect(Collectors.toList());
    }

    public CatalogAndItemsDto findCatalogById(Long id) {
        Catalog findCatalog = repository.findById(id).orElseThrow(() -> new CatalogNotFoundException(id));
        return modelMapper.map(findCatalog, CatalogAndItemsDto.class);
    }
}
