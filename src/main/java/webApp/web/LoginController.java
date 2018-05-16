package webApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import webApp.data.TempRepositoryImpl;
import webApp.model.Human;
import webApp.model.Login;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private TempRepositoryImpl<Human> repository;

    @Autowired
    public LoginController(TempRepositoryImpl<Human> repository){
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showLoginForm(Model model){
        model.addAttribute("login", new Login());
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String loginProcessing(@Valid @ModelAttribute("login") Login login, Errors errors, Model model){
        if(errors.hasErrors()){
            return "login";
        }
        if (repository.checkIfUserExists(login.getUsername())){
            return "/redirect:" + login.getUsername();
        }
        return "login";
    }
}
