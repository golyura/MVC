package model;

import bean.User;

public class FakeModel implements Model {

    private ModelData modelData;

    public FakeModel() {
        modelData = new ModelData();

    }

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        modelData.getUsers().add(new User("Yura", 1, 3));
        modelData.getUsers().add(new User("Vika", 2, 1));
        modelData.getUsers().add(new User("Artem", 3, 0));
    }

    @Override
    public void loadDeletedUsers() {

    }

    @Override
    public void loadUserById(int userId) {

    }

    @Override
    public void deleteUserById(int id) {

    }

    @Override
    public void changeUserData(String name, int id, int level) {

    }
}
