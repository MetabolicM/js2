package com.marinin.core_to_boot.dao.dao;

import com.marinin.core_to_boot.models.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<User> getAllUsers();

    User getUser(int id);

    void save(User user);

    void update(User incomingUser);

    void delete(int id);

    Optional<User> loadUserByUsername(String userName);
}
