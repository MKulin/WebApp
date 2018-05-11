package webApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import webApp.data.Repository;
import webApp.data.TempRepositoryImpl;
import webApp.model.Human;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    private Repository<Human> repository;

    @Autowired
    public RegisterController(TempRepositoryImpl<Human> repository){
        this.repository = repository;
    }

    /*@RequestMapping(method = RequestMethod.GET)
    public String register(){
        return "register";
    }*/

    @RequestMapping(method = RequestMethod.GET)
    public String john(Model model){
        model.addAttribute("rep", repository);
        return "register";
    }
}
