package marketplace.price;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<DetailsDto> getUserProductAllDetails(String userId) {
        List<Details> detailsList = detailsRepository.findAll();
        List<Details> results = new ArrayList<>();
        for(Details d: detailsList){
            if(d.getUserId() != null){
                if(d.getUserId().equals(userId)){
                    results.add(d);
                }
            }
        }
        return results.stream().map(r -> modelMapper.map(r, DetailsDto.class)).collect(Collectors.toList());
    }
}
