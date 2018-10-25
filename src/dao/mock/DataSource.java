package dao.mock;

import bean.User;

import java.util.LinkedList;
import java.util.List;

public class DataSource {
    private static DataSource dataSource;

    private DataSource() {

    }

    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new DataSource();
        }
        return dataSource;
    }

    private List<User> users = new LinkedList<User>();

    {
        users.add(new User("Yura", 1231, 2));
        users.add(new User("Viktorya", 1235, 22));
        users.add(new User("Artem", 1239, 44));
        users.add(new User("Layka", 133, 9));
    }


    public List<User> getUsers() {
        return users;
    }

    private long maxUserId = 1239;

    public User createOrUpdate(User user) {
        if (user == User.NULL_USER) {
            return new User();
        }

        if (user.getId() == 0) {
            return createNewUser(user);
        } else {
            return updateUser(user);
        }
    }

    private User updateUser(User user) {
        for (User unit : users) {
            if (unit.getId() == user.getId()) {
                unit.setName(user.getName());
                unit.setLevel(user.getLevel());
                return unit;
            }
        }
        return User.NULL_USER;
    }

    private User createNewUser(User user) {
        User clone = user.clone(++maxUserId);
        System.out.println(clone);
        users.add(clone);
        return clone;
    }


}
