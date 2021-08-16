package views;

import entities.UserEntity;
import views.Base.Page;

import java.util.List;

public class SortActivities extends Page {

    private final UserEntity user;

    public SortActivities(UserEntity user) {

        this.user = user;
    }

    @Override
    protected void run() {


        List<String> actionsList = List.of("edit activity",
                "sort activities by status completed first",
                "sort activities by status opened first",
                "sort activities by status progressing first",
                "sort activities by date the newest first",
                "sort activities by date the oldest first",
                "sort activities by title ascending",
                "sort activities by title descending");
        printOptions(actionsList);
    }
}
