package main;

import controller.Controller;
import model.FakeModel;
import model.MainModel;
import model.Model;
import view.EditUserView;
import view.UsersView;

public class Solution {
    private UsersView usersView;

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        UsersView usersView = new UsersView();
//        solution.setUsersView(usersView);
//
////        FakeModel fakeModel = new FakeModel();
//        MainModel mainModel = new MainModel();
//
//
//        Controller controller = new Controller();
//        usersView.setController(controller);
//        controller.setModel(mainModel);
//        usersView.fireEventShowAllUsers();
//        usersView.refresh(controller.getModel().getModelData());
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        EditUserView editUserView = new EditUserView();

        Controller controller = new Controller();
        usersView.setController(controller);
        editUserView.setController(controller);

        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);

        usersView.fireEventShowAllUsers();
        usersView.fireEventShowDeletedUsers();
//        usersView.fireEventOpenUserEditForm(1235);

        editUserView.fireEventUserDeleted(1231);

        editUserView.fireEventUserChanged("Artem@@2", 1239, 15);
        editUserView.fireEventUserChanged("Artem@@333", 0, 20);

        editUserView.refresh(model.getModelData());

        usersView.fireEventShowDeletedUsers();


    }
}
