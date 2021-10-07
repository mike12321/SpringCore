package service.impl;

import dao.UserDAO;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getUserById(long userId) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userDAO.getUsersByName(name, pageSize, pageNum);
    }

    @Override
    public User createUser(User user) {
        return userDAO.createUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userDAO.updateUser(user);
    }

    @Override
    public boolean deleteUser(long userId) {
        return userDAO.deleteUser(userId);
    }
}
