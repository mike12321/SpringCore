package dao.storage;

import model.User;

import java.util.Map;
public class UserStorage {

    Map<Long, User> userStorage;
    private String path;

    public void setUserStorage(Map<Long, User> userStorage) {
        this.userStorage = userStorage;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }


    public Map<Long, User> getUserStorage() {
        return userStorage;
    }
}
