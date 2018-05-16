package webApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import webApp.data.Repository;
import webApp.data.TempRepositoryImpl;
import webApp.model.Human;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/registration")
public class RegisterController {

    private Repository<Human> repository;

    @Autowired
    public RegisterController(TempRepositoryImpl<Human> repository){
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String register(Model model){
        Human human = new Human();
        model.addAttribute("human", human);
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@Valid @ModelAttribute("human") Human human, Errors errors){
        if (errors.hasErrors()){
            return "registration";
        }
        repository.set(human);
        return "redirect:/" + human.getUsername();
    }


}
