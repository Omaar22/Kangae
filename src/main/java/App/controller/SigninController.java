package App.controller;

import App.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SigninController {

    @RequestMapping("/signin")
    public ModelAndView signin(Model model) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("signin");
        User user = new User() ;
        model.addAttribute("user", user);
        mv.addObject("user", user);
        return mv;
    }

}
