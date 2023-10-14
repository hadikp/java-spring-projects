package p.expired;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import p.property.PropertyService;

@Service
public class ExpiredDocument {

    @Autowired
    private PropertyService propertyService;

    @PostConstruct
    public void expiredProperty(){
        propertyService.expiredProperty();
    }
}
