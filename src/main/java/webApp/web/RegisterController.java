package webApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import webApp.data.Repository;
import webApp.data.TempRepositoryImpl;
import webApp.model.Human;

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
        model.addAttribute("rep", repository.get(0));
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(Human human){
        repository.set(human);
        return "redirect:/" + human.getName();
    }


}
