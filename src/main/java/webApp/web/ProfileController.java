package webApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import webApp.data.Repository;
import webApp.model.Human;
import webApp.model.Message;

@Controller
@RequestMapping(value = "/{name}")
public class ProfileController {

    private Repository<Human> repository;

    @Autowired
    public ProfileController(Repository<Human> repository){
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String profile(@PathVariable String name, Model model){
        Human human = repository.getByName(name);
        model.addAttribute(human);
        model.addAttribute("message", new Message(human.getUsername()));
        return "profile";
    }

    @RequestMapping(method = RequestMethod.POST)
    public void chatMessage(@ModelAttribute("message") Message message, @ModelAttribute("human") Human human, Model model){
        //System.out.println(human.getUsername());
        model.asMap().keySet().forEach(System.out::println);
        model.addAttribute("message", message);
        //model.addAttribute("human", repository.getByName(message.getAuthor()));
    }
}
