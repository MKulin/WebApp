package webApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import webApp.data.Repository;
import webApp.model.Human;
import webApp.model.Message;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    @RequestMapping(value = "/chatMessage", method = RequestMethod.POST)
    public void chatMessage(@ModelAttribute("message") Message message, Model model){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            reader.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("message", message);
    }
}
