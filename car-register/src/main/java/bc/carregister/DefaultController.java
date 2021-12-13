package bc.carregister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DefaultController {
    
    @Autowired
    private CarService carService;

    @Autowired
    private OwnerService ownerService;

    @GetMapping("*")
    public String getDefault(){
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String getAll(Model model){
        model.addAttribute("owners", ownerService.listAll());
        model.addAttribute("cars", carService.listAll());
        return "index";
    }

    
}
