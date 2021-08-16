package views;

import entities.ActivityEntity;
import entities.UserEntity;
import services.UserService;
import views.Base.Page;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddActivity extends Page {

    public static final UserService userService = new UserService();


    private UserEntity user;
    private String activityName;
    private String activityNotes;
    private Timestamp activityDueDate;
    private String activityCategory;


    void setActivityDateToNow() {
        Date date = new Date();
        this.activityDueDate = new Timestamp(date.getTime());
    }

    AddActivity(UserEntity user) {

        this.user = user;
        setActivityDateToNow();
//        print(activityDueDate);

//        https://stackoverflow.com/questions/21796497/how-to-extract-date-and-time-from-a-string-timestamp-in-java
//        from stack overflow
        SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm a");
        sdfTime.setTimeZone(java.util.TimeZone.getTimeZone("GMT+4:30"));
        String dateStr = sdfTime.format(activityDueDate);
        print("Tehran " + dateStr);
        run();
    }

    @Override
    protected void run() {
        activityName = enterLine("enter your Activity name");

        activityNotes = enterLine("enter your Activity description");

        line();

        ActivityEntity newActivityEntity = new ActivityEntity();
        newActivityEntity.setActivityName(activityName);
        newActivityEntity.setActivityNotes(activityNotes);
        newActivityEntity.setActivityDueDate(activityDueDate);

        boolean activity = userService.createActivity(newActivityEntity, user);
        if (activity) {
            success("added activity");
            new ActivityManager(user);
        }

    }
}
