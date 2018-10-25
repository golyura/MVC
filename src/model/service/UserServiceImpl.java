package model.service;

import bean.User;
import dao.UserDao;
import util.Util;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDao();


    @Override
    public User deleteUser(long id) {
        User user = userDao.getUserById(id);
        Util.markDeleted(user);
        userDao.createOrUpdate(user);
        return user;
    }

    @Override
    public User createOrUpdateUser(String name, int id, int level) {
        User user = new User(name, id, level);
        return userDao.createOrUpdate(user);
    }
    @Override
    public List<User> getUsersByName(String name) {
        return userDao.getUsersByName(name);
    }
    @Override
    public List<User> getAllDeletedUsers() {
        List<User> result = new ArrayList<>();
        for (User user : userDao.getAllUsers()) {
            if (Util.isUserDeleted(user)) {
                result.add(user);
            }
        }
        return result;
    }
    @Override

    public List<User> getUsersBetweenLevels(int fromLevel, int toLevel) {
        List<User> result = new ArrayList<>();
        for (int i = fromLevel; i <= toLevel; i++) {
            result.addAll(userDao.getUsersByLevel(i));
        }
        return result;
    }
    @Override

    public List<User> filterOnlyActiveUsers(List<User> allUsers) {
        List<User> result = new ArrayList<>();
        for (User user : allUsers) {
            if (User.NULL_USER != user && !Util.isUserDeleted(user)) {
                result.add(user);
            }
        }
        return result;
    }

    @Override
    public User getUsersById(long userId) {
        return userDao.getUserById(userId);
    }
}
