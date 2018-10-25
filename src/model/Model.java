package model;

public interface Model {
    ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers();
    void loadUserById(int userId);
    void deleteUserById(int id);
    void changeUserData(String name, int id, int level);
}
