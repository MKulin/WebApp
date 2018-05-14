package webApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import webApp.data.TempRepositoryImpl;
import webApp.model.Human;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    private TempRepositoryImpl<Human> repository;

    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String profile(@PathVariable String name, Model model){
        Human human = repository.getByName(name);
        model.addAttribute(human);
        return "profile";
    }
}
