package bc.carregister;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    OwnerRepository ownerRepository;

    public List<Car> listAll(){
        return carRepository.findAll();
    }

    public Car getCar(Long carId){
       return carRepository.getById(carId);
    }

    public void addCar(int serialnumber, String registrationnumber,String brand, String model, int made){
       carRepository.save(new Car(serialnumber, registrationnumber, brand, model, made, new ArrayList()));
    }

    public void addOwnerToCar(Long carId, Long ownerId){
        ownerRepository.getById(ownerId).getCars().add(carRepository.getById(carId));
    }
}
