package App.controller;

import App.model.Course;
import App.model.Student;
import App.service.CourseService;
import App.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UserController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    @RequestMapping("/Hi")
    public Iterable<Student> get() {
        return studentService.getAll();
    }

    @RequestMapping("/show/{courseName}")
    public Course show(@PathVariable String courseName) {
        return courseService.getCourse(courseName);
    }

}
