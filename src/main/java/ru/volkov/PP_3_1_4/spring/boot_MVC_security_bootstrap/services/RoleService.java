package ru.volkov.PP_3_1_4.spring.boot_MVC_security_bootstrap.services;

import ru.volkov.PP_3_1_4.spring.boot_MVC_security_bootstrap.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    Role getRoleByName(String role);

    Role getRoleById(Long id);

    void addRole(Role role);
}
