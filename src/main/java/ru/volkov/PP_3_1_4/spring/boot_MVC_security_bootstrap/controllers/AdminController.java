package ru.volkov.PP_3_1_4.spring.boot_MVC_security_bootstrap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.volkov.PP_3_1_4.spring.boot_MVC_security_bootstrap.models.Role;
import ru.volkov.PP_3_1_4.spring.boot_MVC_security_bootstrap.models.User;
import ru.volkov.PP_3_1_4.spring.boot_MVC_security_bootstrap.services.RoleService;
import ru.volkov.PP_3_1_4.spring.boot_MVC_security_bootstrap.services.UserService;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    String redirect = "redirect:/admin/";


    @GetMapping("/")
    public String getAdminPage(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.getAllRoles());
        return "admin/adminPage";
    }

    @GetMapping("/add")
    public String newUserPage(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.getAllRoles());
        return "admin/newUser";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                             @RequestParam(value = "roles") String[] selectResult) {
        if (bindingResult.hasErrors()) {
            return "admin/newUser";
        }
        Set<Role> roles = new HashSet<>();
        for (String s : selectResult) {
            roles.add(roleService.getRoleByName(s));
        }
        user.setRoles(roles);
        userService.saveUser(user);
        return redirect;
    }

    @PatchMapping(value = "/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                             @RequestParam(value = "roles") String[] selectResult) {
        if (!bindingResult.hasErrors()) {
            Set<Role> roles = new HashSet<>();
            for (String s : selectResult) {
                roles.add(roleService.getRoleByName(s));
            }
            user.setRoles(roles);
            userService.updateUser(user);
        }
        return redirect;
    }

    @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return redirect;
    }
}