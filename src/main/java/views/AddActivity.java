package views;

import entities.ActivityEntity;
import entities.UserEntity;
import repositories.UserRepository;
import services.UserService;
import views.Base.Page;

import java.sql.Timestamp;
import java.util.Date;

public class AddActivity extends Page {

    public static final UserService userService = new UserService(new UserRepository());


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
        super();
        this.user = user;
        setActivityDateToNow();
        print(activityDueDate);

    }

    @Override
    protected void run() {
        activityName = enterLine("enter your Activity name");

        activityNotes = enterLine("enter your Activity description");

        ActivityEntity newActivityEntity = new ActivityEntity();
        newActivityEntity.setActivityName(activityName);

        newActivityEntity.setActivityNotes(activityNotes);
        newActivityEntity.setActivityDueDate(activityDueDate);

        boolean activity = userService.createActivity(newActivityEntity, user);
        if(activity){
            success("added activity");
            new ShowAllActivityPage(user);
        }

    }
}
