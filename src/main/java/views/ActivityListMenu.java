package views;

import entities.ActivityEntity;
import entities.UserEntity;
import entities.enums.Status;
import services.ActivityService;
import views.Base.Page;

import java.util.List;

public class ActivityListMenu extends Page {
    private UserEntity user;

    public ActivityListMenu(UserEntity currentUser) {
        user = currentUser;
        run();
    }


    @Override
    protected void run() {
        ActivityService activityService = new ActivityService();
        List<ActivityEntity> userActivities = activityService.fetchUserActivities(user);
        print("user : " + user.getFullName());
        int activityIndexer = 1;

        for (ActivityEntity act : userActivities) {
            line();
            print("\tnumber   : " + activityIndexer++);
            print();
            print("\ttitle  : " + act.getActivityName());
            print("\tdate   : " + act.getActivityDueDateInFormat());
            print("\tstatus : " + act.getStatus());
            print("\tnotes  : " + act.getActivityNotes());
        }

        line();

        List<String> actionsList = List.of(
                "edit activity status",
                "show Activities sorted",
                "logout");

        printOptions(actionsList);


        int opt = selectOpt(1);
        switch (opt) {
            case 1 -> editActivityStatus(activityService, userActivities);
            case 2 -> new SortActivities(user);
            case 3 -> new LoginPage();
        }
        run();

    }

    private boolean editActivityStatus(ActivityService activityService, List<ActivityEntity> userActivities) {
        line();
        print("select an activity to edit its status ");
        int opt = selectOpt(userActivities.size());
        ActivityEntity edit = userActivities.get(opt - 1);

        line();
        print(" you selected the activity");
        print("\t\t\tnumber   : " + opt);
        print("\t\t\ttitle  : " + edit.getActivityName());
        print("\t\t\tdate   : " + edit.getActivityDueDateInFormat());
        print("\t\t\tstatus : " + edit.getStatus());
        print("\t\t\tnotes  : " + edit.getActivityNotes());


        printOptions(
                List.of("change status to open",
                        "change status to progress",
                        "change status to done"
                ));
        int status = selectOpt(3);

        switch (status) {
            case 1 -> edit.setStatus(Status.Open);
            case 2 -> edit.setStatus(Status.Progress);
            case 3 -> edit.setStatus(Status.Done);
        }
        return null != activityService.updateStatusForActivity(edit);
    }
}
