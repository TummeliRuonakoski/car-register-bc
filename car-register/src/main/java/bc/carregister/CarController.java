package bc.carregister;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    OwnerService ownerService;

    @GetMapping("/cars")
    public String getCars(Model model){
        model.addAttribute("cars", carService.listAll());
        return "cars";
    }

    @PostMapping("/cars")
    public String addCar(@RequestParam int serialnumber, @RequestParam String registrationnumber, @RequestParam String brand, @RequestParam String model, @RequestParam int made){
        carService.addCar(serialnumber, registrationnumber, brand, model, made);
        return "redirect:/cars";
    }

    @GetMapping("/cars/{id}")
    public String viewCar(Model model, @PathVariable Long id){
        model.addAttribute("car", carService.getCar(id));
        model.addAttribute("owners", ownerService.listAll());
        return "car";
    }


    
}
