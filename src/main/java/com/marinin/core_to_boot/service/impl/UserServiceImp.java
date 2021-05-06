package com.marinin.core_to_boot.service.impl;

import com.marinin.core_to_boot.dao.dao.UserDAO;
import com.marinin.core_to_boot.dao.impl.UserDAOImp;
import com.marinin.core_to_boot.models.User;
import com.marinin.core_to_boot.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserDAO userDAO;

    public UserServiceImp(){}

    @Autowired
    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional
    public void update(User updatedUser) {
        userDAO.update(updatedUser);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDAO.delete(id);
    }
}
