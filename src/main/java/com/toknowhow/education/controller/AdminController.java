package com.toknowhow.education.controller;

import com.toknowhow.education.model.Category;
import com.toknowhow.education.model.Resource;
import com.toknowhow.education.service.CategoryService;
import com.toknowhow.education.service.ResourceService;
import com.toknowhow.education.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private UserService userService;

    @Autowired
    private com.toknowhow.education.service.SubcategoryService subcategoryService;

    @GetMapping
    public String adminDashboard(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("subcategories", subcategoryService.getAllSubcategories());
        model.addAttribute("resources", resourceService.getAllResources());
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }

    @PostMapping("/category/add")
    public String addCategory(@RequestParam String name, @RequestParam String description,
            @RequestParam String iconPath) {
        Category category = new Category(null, name, description, iconPath, null, null);
        categoryService.saveCategory(category);
        return "redirect:/admin";
    }

    @PostMapping("/subcategory/add")
    public String addSubcategory(@RequestParam String name, @RequestParam Long categoryId) {
        com.toknowhow.education.model.Subcategory subcategory = new com.toknowhow.education.model.Subcategory();
        subcategory.setName(name);
        Category category = new Category();
        category.setId(categoryId);
        subcategory.setCategory(category);
        subcategoryService.saveSubcategory(subcategory);
        return "redirect:/admin";
    }

    @PostMapping("/resource/add")
    public String addResource(@RequestParam String title, @RequestParam String description,
            @RequestParam String link, @RequestParam String type, @RequestParam Long categoryId,
            @RequestParam Long subcategoryId) {
        Resource resource = new Resource();
        resource.setTitle(title);
        resource.setDescription(description);
        resource.setLink(link);
        resource.setType(type);

        Category category = new Category();
        category.setId(categoryId);
        resource.setCategory(category);

        com.toknowhow.education.model.Subcategory subcategory = new com.toknowhow.education.model.Subcategory();
        subcategory.setId(subcategoryId);
        resource.setSubcategory(subcategory);

        resourceService.saveResource(resource);
        return "redirect:/admin";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/resource/delete/{id}")
    public String deleteResource(@PathVariable Long id) {
        resourceService.deleteResource(id);
        return "redirect:/admin";
    }

    @GetMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/admin";
    }
}
