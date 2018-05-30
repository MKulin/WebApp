package webApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import webApp.data.Repository;
import webApp.model.Human;
import webApp.model.Message;

@Controller
@RequestMapping(value = "/profile")
public class ProfileController {

    private Repository<Human> repository;

    @Autowired
    public ProfileController(Repository<Human> repository){
        this.repository = repository;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String profile(@PathVariable String name, Model model){
        Human human = repository.getByName(name);
        model.addAttribute(human);
        return "profile";
    }

    @RequestMapping(method = RequestMethod.POST)
    public Model chatMessage(@ModelAttribute Message message, Model model){
        System.out.println(message.getText());
        System.out.println(model.asMap().get("human"));
        model.addAttribute("message", message);
        return model;
    }
}
