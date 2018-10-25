package bean;

public class User implements Cloneable {
    public static final User NULL_USER = new User();
    private String name;
    private int id;
    private int level;

    public User() {
        this("", 0, 0);
    }

    public User(String name, int id, int level) {
        this.name = name;
        this.id = id;
        this.level = level;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", level=" + level +
                '}';
    }

    //region Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isNew() {
        return id == 0;
    }

    @Override
    public User clone() {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            return NULL_USER;
        }
    }

    public User clone(long l) {
        if (this == NULL_USER) return User.NULL_USER;
        return new User(name, (int) l, level);
    }
    //endregion
}
