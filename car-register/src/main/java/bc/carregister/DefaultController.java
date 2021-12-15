package bc.carregister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@Controller
public class DefaultController {
    

    @Autowired
    private CarRepository carRepository;

    @GetMapping("*")
    public String getDefault(){
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String getAll(Model model){
         Pageable pageable = PageRequest.of(0,10, Sort.by("made").descending());
         model.addAttribute("cars", carRepository.findAll(pageable));
        return "index";
    }

    
}
