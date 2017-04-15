package App.service;

import App.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import App.repository.UserBaseRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserBaseRepository userBaseRepository;

    public User loggedInUser;

    public User signin(String email, String password) {
        User user = userBaseRepository.findByEmail(email);
        if (password != null && user != null && password.equals(user.getPassword())) {
            return loggedInUser = user;
        }
        return null;
    }

    public boolean signup(User user) {
        if (user != null && userBaseRepository.findByEmail(user.getEmail()) != null) {
            return false;
        }
        // todo: validate
        userBaseRepository.save(user);
        return true;
    }
}
