package App.service;

import App.model.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import App.repository.UserBaseRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public class UserService {
    @Autowired
    private UserBaseRepository userBaseRepository;
    @Autowired
    protected AuthenticationManager authenticationManager;

    public void signOut(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
            request.getSession().invalidate();
        }
    }

    public boolean isLoggedIn() {
        return getLoggedInUser() != null;
    }

    public boolean signup(User user, HttpServletRequest request) {
        if (!isNewEmail(user)) {
            return false;
        }
        userBaseRepository.save(user);
        // manually sign in
        authenticateUserAndSetSession(user, request);
        return true;
    }

    private void authenticateUserAndSetSession(User user, HttpServletRequest request) {
        String userEmail = user.getEmail();
        String password = user.getPassword();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userEmail, password);
        // generate session if one doesn't exist
        request.getSession();
        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }


    private boolean isNewEmail(User user) {
        return userBaseRepository.findByEmail(user.getEmail()) == null;
    }

    public User getLoggedInUser() {
        return userBaseRepository.findByEmail(getLoggedInUserEmail());
    }

    private String getLoggedInUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
