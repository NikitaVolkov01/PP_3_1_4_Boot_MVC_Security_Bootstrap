package ru.volkov.PP_3_1_4.spring.boot_MVC_security_bootstrap.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.volkov.PP_3_1_4.spring.boot_MVC_security_bootstrap.dao.RoleDao;
import ru.volkov.PP_3_1_4.spring.boot_MVC_security_bootstrap.models.Role;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public Role getRoleByName(String role) {
        return roleDao.getRoleByName(role);
    }

    @Override
    public Role getRoleById(Long id) {
        return roleDao.getRoleById(id);
    }
    @Transactional
    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }
}
