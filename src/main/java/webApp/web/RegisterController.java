package webApp.web;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import webApp.data.HumanRepositoryImpl;
import webApp.data.Repository;
import webApp.model.Human;

import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping(value = "/registration")
public class RegisterController {

    private Repository<Human> repository;

    @Autowired
    public RegisterController(Repository<Human> repository){
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String register(Model model){
        Human human = new Human();
        model.addAttribute("human", human);
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@RequestPart("profileImage") MultipartFile profileImage,
                                      @Valid @ModelAttribute("human") Human human,
                                      RedirectAttributes model,
                                      Errors errors) {
        if (errors.hasErrors()){
            return "registration";
        }
        if (profileImage != null) {
            System.out.println(profileImage.getOriginalFilename().toUpperCase());
            try {
                File f = new File("tmp" + File.separator
                        + human.getUsername()
                        + profileImage.getOriginalFilename()
                        .substring(profileImage
                                .getOriginalFilename()
                                .lastIndexOf('.')));
                FileUtils.touch(f);
                OutputStream out = new FileOutputStream(f);
                out.write(profileImage.getBytes());
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        repository.set(human);
        model.addAttribute("username", human.getUsername());
        model.addFlashAttribute(human);
        return "redirect:/profile/{username}";
    }


}
