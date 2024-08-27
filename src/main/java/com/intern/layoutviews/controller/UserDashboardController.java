package com.intern.layoutviews.controller;

import com.intern.layoutviews.entity.Layout;
import com.intern.layoutviews.entity.User;
import com.intern.layoutviews.enums.RoleName;
import com.intern.layoutviews.repo.UserRepository;
import com.intern.layoutviews.service.LayoutService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Controller
@RequestMapping("/user")
public class UserDashboardController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LayoutService layoutService;

    @GetMapping("/dashboard")
    public String getUserDashboard(Model model, HttpSession session) {
        User user = getCurrentUser(session);
        if (!Objects.equals(user.getRole(), RoleName.USER.name())) {
            return "redirect:/access-denied";
        }
        Layout userLayout = layoutService.getUserLayout(user.getId());
        if (userLayout != null) {
            model.addAttribute("layout", userLayout);
        }
        model.addAttribute("user", user);
        return "userDashboard";
    }

    private User getCurrentUser(HttpSession session) {
        return (User) session.getAttribute("loggedInUser");
    }
}