package App.controller;

import App.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {

    @RequestMapping("/")
    public String home() {
        return "/home";
    }
}
