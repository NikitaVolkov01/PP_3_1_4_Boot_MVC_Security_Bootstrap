package ru.volkov.PP_3_1_4.spring.boot_MVC_security_bootstrap.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.volkov.PP_3_1_4.spring.boot_MVC_security_bootstrap.models.Role;
import ru.volkov.PP_3_1_4.spring.boot_MVC_security_bootstrap.models.User;
import ru.volkov.PP_3_1_4.spring.boot_MVC_security_bootstrap.services.RoleService;
import ru.volkov.PP_3_1_4.spring.boot_MVC_security_bootstrap.services.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Init {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public Init(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void initializeDataBase(){
        roleService.addRole(new Role("ROLE_ADMIN"));
        roleService.addRole(new Role("ROLE_USER"));

        Set<Role> adminRole = new HashSet<>();
        Set<Role> userRole = new HashSet<>();
        Set<Role> allRoles = new HashSet<>();

        adminRole.add(roleService.getRoleById(1L));
        userRole.add(roleService.getRoleById(2L));
        allRoles.add(roleService.getRoleById(1L));
        allRoles.add(roleService.getRoleById(2L));

        userService.saveUser(new User("Volkov", "Nikita",22,"admin","admin",adminRole));
        userService.saveUser(new User("TestUser", "TestUser", 20, "user", "user", userRole));
        userService.saveUser(new User("TestAdminUser", "TestAdminUser",25,"adminuser","adminuser",allRoles));
    }
}

