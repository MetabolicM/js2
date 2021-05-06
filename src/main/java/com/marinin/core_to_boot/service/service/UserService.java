package com.marinin.core_to_boot.service.service;

import com.marinin.core_to_boot.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService { //nonsense

    List<User> getAllUsers();

    User getUser(int id);

    void save(User user);

    void update(User updatedUser);

    void delete(int id);

}
