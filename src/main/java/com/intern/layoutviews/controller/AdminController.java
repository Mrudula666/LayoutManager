package com.intern.layoutviews.controller;

import com.intern.layoutviews.entity.Layout;
import com.intern.layoutviews.entity.User;
import com.intern.layoutviews.request.AssignmentRequest;
import com.intern.layoutviews.service.LayoutService;
import com.intern.layoutviews.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private LayoutService layoutService;

    @Autowired
    private UserService userService;

    @GetMapping("layouts")
    public List<Layout> getAllLayouts() {
        return layoutService.getAllLayouts();
    }

    @RequestMapping("/getAllLayouts")
    public String showLayoutsPage(Model model) {
        List<Layout> layouts = layoutService.getAllLayouts();
        model.addAttribute("layouts", layouts);
        return "layouts";
    }

    @RequestMapping("/manageLayouts")
    public String showManageLayoutsPage(Model model) {
        List<Layout> layouts = layoutService.getAllLayouts();
        List<User> users = userService.getUsersByRole("User");
        model.addAttribute("layouts", layouts);
        model.addAttribute("users", users);
        return "ManageLayouts";
    }

    @RequestMapping("/updateLayout")
    public String showUpdateLayoutsPage(Model model) {
        List<Layout> layouts = layoutService.getAllLayouts();
        model.addAttribute("layouts", layouts);
        return "updateLayout";
    }


    @PostMapping("/assignLayout")
    public ResponseEntity<String> assignLayoutToUser(@RequestBody AssignmentRequest request) {

        for (Long userId : request.getUserIds()) {
            layoutService.assignLayoutToUser(userId, request.getLayoutId());
        }

        return ResponseEntity.ok("Layout assigned successfully");
    }

    @PutMapping("/updateLayout")
    public ResponseEntity<String> updateLayout(@RequestParam("layoutId") Long id,
                                               @RequestParam("layoutName") String name) {
        layoutService.updateLayout(id, name);
        return ResponseEntity.ok("Layout updated successfully");
    }

    private User getCurrentUser(HttpSession session) {
        return (User) session.getAttribute("loggedInUser");
    }
}
