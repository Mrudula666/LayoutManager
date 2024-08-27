package com.intern.layoutviews.controller;

import com.intern.layoutviews.entity.Layout;
import com.intern.layoutviews.entity.User;
import com.intern.layoutviews.enums.RoleName;
import com.intern.layoutviews.service.LayoutService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private LayoutService layoutService;



    private User getCurrentUser(HttpSession session) {
        return (User) session.getAttribute("loggedInUser");
    }
}
