package App.controller;

import App.model.Student;
import App.model.Teacher;
import App.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignupController {

    @RequestMapping("/signup/teacher")
    public ModelAndView signupTeacher(Model model) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("signup_teacher");
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        mv.addObject("teacher", teacher);
        return mv;
    }

    @RequestMapping("/signup/student")
    public ModelAndView signupStudent(Model model) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("signup_student");
        Student student = new Student();
        model.addAttribute("student", student);
        mv.addObject("student", student);
        return mv;
    }


    @RequestMapping("/signup")
    public String signup() {
        return "/signup";
    }
}
