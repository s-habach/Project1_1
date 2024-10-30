package com.revature.services;

import com.revature.daos.UserDAO;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDAO uDAO;

    @Autowired
    public UserService(UserDAO uDAO) {
        this.uDAO = uDAO;
    }

    public User createUser(User newUser) {

        if (newUser.getUsername() == null || newUser.getUsername().isBlank()) {
            throw new IllegalArgumentException("Username can't be empty!");
        }
        else if (newUser.getPassword() == null || newUser.getPassword().isBlank()) {
            throw new IllegalArgumentException("Password can't be empty!");
        }
        else if (newUser.getFirst_name() == null || newUser.getFirst_name().isBlank()) {
            throw new IllegalArgumentException("First name can't be empty!");
        }
        else if (newUser.getLast_name() == null || newUser.getLast_name().isBlank()) {
            throw new IllegalArgumentException("Last name can't be empty!");
        }
        return uDAO.save(newUser);
    }

    public List<User> getAllUsers() {
        return uDAO.findAll();
    }

    public void deleteUser(String username) {

        User userToDelete = uDAO.findByUsername(username);

        if (userToDelete == null) {
            throw new IllegalArgumentException("User can't be found!");
        }
        else {
            uDAO.delete(userToDelete);
        }
    }
}
