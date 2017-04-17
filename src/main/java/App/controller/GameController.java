package App.controller;

import App.model.Course;
import App.model.Game;
import App.model.Teacher;
import App.service.CourseService;
import App.service.GameService;
import App.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class GameController {
    @Autowired
    private GameService gameservice;
    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;

        @RequestMapping(value = "/course/{courseName}/create/game")
    public String showCourse(@PathVariable String courseName, Model model) {
        Game game = new Game();
        game.setCourse(courseService.getCourse(courseName));
        if (game.getCourse() == null || game.getCourse().getTeacher().equals(userService.getLoggedInUser())) {
            return "redirect:/"; // todo: return error message
        } else {
            model.addAttribute("game", game);
            return "/create_game_in_course";
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/course/{courseName}/create/game")
    public String addGame(@ModelAttribute(value = "game") Game game, @PathVariable String courseName) {
        // todo: check
        game.setCourse(courseService.getCourse(courseName));
        gameservice.addGame(game);
        return "redirect:/course/" + courseName;
    }


}
