package dao.impl;

import dao.UserDAO;
import dao.storage.UserStorage;
import model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDAOImpl implements UserDAO {
    private final UserStorage userStorage;

    public UserDAOImpl(UserStorage userStorage) {
        this.userStorage = userStorage;
    }


    @Override
    public User getUserById(long userId) {
        return userStorage.getUserStorage().get(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userStorage.getUserStorage().values().stream()
                .filter(user -> user.getEmail().equals(email))
                .collect(Collectors.toList())
                .get(0);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userStorage.getUserStorage().values().stream()
                .filter(user -> user.getName().equals(name))
                .skip((long) (pageNum - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    @Override
    public User createUser(User user) {
        return userStorage.getUserStorage().put(user.getId(), user);
    }

    @Override
    public User updateUser(User user) {
        return createUser(user);
    }

    @Override
    public boolean deleteUser(long userId) {
        return userStorage.getUserStorage().remove(userId) != null;
    }
}
