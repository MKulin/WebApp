package webApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import webApp.data.HumanRepositoryImpl;
import webApp.data.Repository;
import webApp.model.Human;
import webApp.model.Login;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private Repository<Human> repository;

    @Autowired
    public LoginController(Repository<Human> repository){
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showLoginForm(Model model){
        model.addAttribute("login", new Login());
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String loginProcessing(@Valid @ModelAttribute("login") Login login, Errors errors, RedirectAttributes model){
        if(errors.hasErrors()){
            return "login";
        }
            model.addFlashAttribute("human", repository.getByName(login.getUsername()));
            model.addAttribute("username", login.getUsername());
            return "redirect:/{username}";
//        return "login";
    }
}
