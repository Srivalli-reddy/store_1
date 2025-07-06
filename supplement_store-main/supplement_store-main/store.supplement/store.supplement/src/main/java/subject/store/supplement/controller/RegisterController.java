package subject.store.supplement.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import subject.store.supplement.entities.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // loads register.jsp
    }

    @PostMapping("/register")
    @Transactional
    public String handleRegister(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String confirmPassword,
            Model model) {

        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match.");
            return "register";
        }

        User user = new User(username, password);
        entityManager.persist(user);

        return "redirect:/login";
    }
}
