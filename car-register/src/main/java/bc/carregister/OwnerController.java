package bc.carregister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private CarService carService;

    @GetMapping("/owner")
    public String listOwners(Model model){
        model.addAttribute("owners", ownerService.listAll());
        model.addAttribute("cars", carService.listAll());
        return "owner";
    }

    @PostMapping("/owner")
    public String addOwner(@RequestParam String firstname, @RequestParam String lastname){
        ownerService.addOwner(firstname, lastname);
        return "redirect:/owner";
    }

    @GetMapping("/owner/{id}")
    public String getOwner(Model model, @PathVariable Long id){
        model.addAttribute("owner", ownerService.getOwner(id));
        model.addAttribute("cars", carService.listAll());
        return "carToOwner";
    }

    @PostMapping("/owner/{ownerId}/car/{carId}")
    @Transactional
    public String addCarToOwner(@PathVariable Long ownerId, @PathVariable Long carId){
        ownerService.addCarToOwner(ownerId, carId);
        return "redirect:/carToOwner";
    }
    
}
