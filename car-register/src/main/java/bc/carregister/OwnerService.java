package bc.carregister;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    CarRepository carRepository;

    public List<Owner> listAll(){
        return ownerRepository.findAll();
    }

    public void addOwner(String firstname, String lastname){
        ownerRepository.save(new Owner(firstname, lastname, new ArrayList()));
    }
    
}
