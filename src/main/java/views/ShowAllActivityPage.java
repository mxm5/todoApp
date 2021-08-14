package views;

import entities.UserEntity;
import views.Base.Page;

public class ShowAllActivityPage extends Page {
    private UserEntity user;
    public ShowAllActivityPage(UserEntity currentUser) {
        user = currentUser;
    }

    @Override
    protected void run() {

    }
}
