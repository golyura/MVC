package view;

import controller.Controller;
import model.ModelData;

public class EditUserView implements View {
    private Controller controller;

    public void fireEventUserDeleted(int id) {
        controller.onUserDelete(id);
    }

    public void fireEventUserChanged(String name, int id, int level) {
        controller.onUserChange(name, id, level);
    }

    @Override
    public void refresh(ModelData modelData) {
        System.out.println("User to be edited:");
        System.out.println("\t" + modelData.getActiveUser());
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
