package com.toknowhow.education.controller;

import com.toknowhow.education.model.Comment;
import com.toknowhow.education.model.Resource;
import com.toknowhow.education.model.User;
import com.toknowhow.education.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("totalResources", resourceService.getAllResources().size());
        model.addAttribute("totalUsers", userService.getAllUsers().size() + 10000); // Simulated base + real
        model.addAttribute("totalCategories", categoryService.getAllCategories().size());
        model.addAttribute("competitiveCategory", categoryService.getCategoryById(5L));
        return "index";
    }

    @GetMapping("/category/{id}")
    public String getCategory(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryService.getCategoryById(id));
        model.addAttribute("resources", resourceService.getResourcesByCategory(id));
        return "category";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userDetailsService.registerUser(user, passwordEncoder);
        return "redirect:/login";
    }

    @GetMapping("/resource/{id}")
    public String viewResource(@PathVariable Long id, Model model) {
        Resource resource = resourceService.getResourceById(id);
        model.addAttribute("resource", resource);
        model.addAttribute("comments", commentService.getCommentsByResource(id));
        model.addAttribute("newComment", new Comment());
        return "resource";
    }

    @PostMapping("/resource/{id}/comment")
    @ResponseBody
    public Comment addComment(@PathVariable Long id, @RequestParam String content, Principal principal) {
        if (principal == null)
            return null;

        Resource resource = resourceService.getResourceById(id);
        User user = userService.findByUsername(principal.getName()).orElse(null);

        if (user != null && resource != null) {
            Comment comment = new Comment();
            comment.setContent(content);
            comment.setResource(resource);
            comment.setUser(user);
            return commentService.saveComment(comment);
        }
        return null;
    }
}
