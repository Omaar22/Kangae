package App.service;

import App.model.Course;
import App.model.Game;
import App.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepo;

    public ArrayList<Game> getALLGame() {
        ArrayList<Game> games = (ArrayList<Game>) gameRepo.findAll();
        //.forEach(users::add);
        return games;
    }

    public ArrayList<Game> getGamesInCourse(Course course) {
        return gameRepo.findByCourseId(course.getId());
    }

    public void addGame(Game game) {
        gameRepo.save(game);
    }

    public Game getGame(String id) {
        return gameRepo.findOne(id);
    }

    public Game updateGame(String id, Game game) {
        return gameRepo.save(game);
    }

    public void deleteGame(String id, Game game) {
        gameRepo.delete(game);
    }

}



