package ru.volkov.PP_3_1_4.spring.boot_MVC_security_bootstrap.dao;

import ru.volkov.PP_3_1_4.spring.boot_MVC_security_bootstrap.models.Role;

import java.util.List;

public interface RoleDao {
   List<Role> getAllRoles();

    Role getRoleById(Long id);

    Role getRoleByName(String role);

    void addRole(Role role);

}

