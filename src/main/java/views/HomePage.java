package views;

import entities.UserEntity;
import views.Base.Page;

import java.util.List;

public class HomePage extends Page {
    UserEntity currentUser;

    HomePage(UserEntity current) {
        super();
        this.currentUser = current;
    }

    @Override
    protected void run() {
        printOptions(List.of("show all my todos", "add new todo"));
        int opt = selectOpt(2);
        switch (opt) {
            case 1:
                new ShowAllActivityPage(currentUser);
                break;
            case 2:
                new AddActivity(currentUser);
                break;
        }
    }
}
