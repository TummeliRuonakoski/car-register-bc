package bc.carregister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/owner")
    public String listOwners(Model model){
        model.addAttribute("owners", ownerService.listAll());
        return "owner";
    }

    @PostMapping("owner")
    public String addOwner(@RequestParam String firstname, @RequestParam String lastname){
        ownerService.addOwner(firstname, lastname);
        return "redirect:/owner";
    }

    
}
