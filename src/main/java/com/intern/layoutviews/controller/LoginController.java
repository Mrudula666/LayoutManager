package com.intern.layoutviews.controller;

import com.intern.layoutviews.entity.User;
import com.intern.layoutviews.enums.RoleName;
import com.intern.layoutviews.repo.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
        if (user.isPresent()) {
            session.setAttribute("loggedInUser", user.get());
            if (Objects.equals(user.get().getRole(), RoleName.ADMIN.name())) {
                return "redirect:/admin/dashboard";
            } else if (Objects.equals(user.get().getRole(), RoleName.USER.name())) {
                return "redirect:/user/dashboard";
            } else {

                session.invalidate();
                return "redirect:/login?error=role";
            }
        } else {
            return "redirect:/login?error";
        }
    }


}
