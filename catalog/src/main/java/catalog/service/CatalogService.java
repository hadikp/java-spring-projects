package catalog.service;

import catalog.dto.CatalogDto;
import catalog.entity.Catalog;
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


    public List<CatalogDto> getAllCatalogs() {
        List<Catalog> catalogs = repository.findAll();
        return catalogs.stream().map(c -> modelMapper.map(c, CatalogDto.class)).collect(Collectors.toList());
    }
}
