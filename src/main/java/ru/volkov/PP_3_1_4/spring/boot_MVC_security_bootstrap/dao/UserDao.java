package ru.volkov.PP_3_1_4.spring.boot_MVC_security_bootstrap.dao;

import ru.volkov.PP_3_1_4.spring.boot_MVC_security_bootstrap.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUser(Long id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    User findByUserName(String username);

}
