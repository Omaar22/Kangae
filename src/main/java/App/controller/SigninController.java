package App.controller;

import App.model.User;
import App.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller
public class SigninController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    @RequestMapping(value = "/signout")
    public String signout(HttpServletRequest request, HttpServletResponse response) {
        userService.signOut(request, response);
        return "redirect:/";
    }

}