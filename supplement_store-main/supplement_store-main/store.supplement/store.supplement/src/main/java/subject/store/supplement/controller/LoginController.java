package subject.store.supplement.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import subject.store.supplement.entities.User;

@Controller
public class LoginController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // loads login.jsp
    }

    @PostMapping("/login")
    @Transactional
    public String handleLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {

    	try {
            User user = entityManager.createQuery("FROM User WHERE username = :username", User.class)
                                     .setParameter("username", username)
                                     .getSingleResult();

            if (user != null && user.getPassword().equals(password)) {
                model.addAttribute("username", username);
                return "dashboard"; // maps to dashboard.jsp
            } else {
                model.addAttribute("error", "Invalid username or password.");
                return "login";
            }
        } catch (NoResultException e) {
            model.addAttribute("error", "Invalid username or password.");
            return "login";
        }
    }
}