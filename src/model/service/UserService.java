package model.service;

import bean.User;

import java.util.List;

public interface UserService {

    User deleteUser(long id);

    User createOrUpdateUser(String name, int id, int level);

    List<User> getUsersByName(String name);

    List<User> getAllDeletedUsers();

    List<User> getUsersBetweenLevels(int fromLevel, int toLevel);

    List<User> filterOnlyActiveUsers(List<User> allUsers);

    User getUsersById(long userId);
}