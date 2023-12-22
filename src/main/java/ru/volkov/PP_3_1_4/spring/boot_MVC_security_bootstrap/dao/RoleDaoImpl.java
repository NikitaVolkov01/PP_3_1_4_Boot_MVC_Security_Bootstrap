package ru.volkov.PP_3_1_4.spring.boot_MVC_security_bootstrap.dao;

import org.springframework.stereotype.Repository;
import ru.volkov.PP_3_1_4.spring.boot_MVC_security_bootstrap.models.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role getRoleByName(String role) {
        TypedQuery<Role> query = entityManager.createQuery("select r from Role r where r.role=:name", Role.class).setParameter("name", role);
        return query.getSingleResult();
    }

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }


}
