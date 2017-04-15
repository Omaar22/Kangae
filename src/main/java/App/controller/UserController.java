package App.controller;

import App.model.Student;
import App.model.Teacher;
import App.model.User;
import App.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import App.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.POST, value = "/signin")
    public User signin(@ModelAttribute(value = "user") User user) {
        if (user == null)
            return null;
        return userService.signin(user.getEmail(), user.getPassword());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signup/student")
    public boolean signup(@ModelAttribute(value = "student") Student student) {
        return userService.signup(student);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signup/teacher")
    public boolean signup(@ModelAttribute(value = "teacher") Teacher teacher) {
        return userService.signup(teacher);
    }

    @RequestMapping("/Hi")
    public Iterable<Student> get() {
        return studentService.getAll();
    }

}
