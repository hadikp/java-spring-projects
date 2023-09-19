package marketplace.price;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DetailsService {

    private DetailsRepository detailsRepository;
    private ModelMapper modelMapper;

    public List<DetailsDto> getAllDetails() {
        List<Details> detailsList = detailsRepository.findAll();
        return detailsList.stream().map(d -> modelMapper.map(d, DetailsDto.class)).collect(Collectors.toList());
    }
}
