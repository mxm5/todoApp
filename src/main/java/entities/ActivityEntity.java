package entities;

import entities.base.EntityModel;
import entities.enums.Status;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


@Entity
public class ActivityEntity extends EntityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int activityId;

    private String activityName;

    private String activityNotes;

    private Timestamp activityDueDate;

    @Column(length = 8, columnDefinition = "varchar(8) default 'Open'",nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.Open;

    public ActivityEntity() {
    }


    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityNotes() {
        return activityNotes;
    }

    public void setActivityNotes(String activityNotes) {
        this.activityNotes = activityNotes;
    }

    public Timestamp getActivityDueDate() {
        return activityDueDate;
    }

    public void setActivityDueDate(Timestamp activityDueDate) {
        this.activityDueDate = activityDueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public String getActivityDueDateInFormat() {
//        https://stackoverflow.com/questions/5121976/is-there-a-date-format-to-display-the-day-of-the-week-in-java
        SimpleDateFormat sdfTime = new SimpleDateFormat("EEE dd MMM yyyy");
//        sdfTime.setTimeZone(java.util.TimeZone.getTimeZone("GMT+4:30"));
        try {
            return sdfTime.format(activityDueDate);
        }catch (Exception e){
            return "no date assigned";
        }
    }





    @Override
    public String toString() {
        return "ActivityEntity{" +
                "activityId=" + activityId +
                ", activityName='" + activityName + '\'' +
                ", activityNotes='" + activityNotes + '\'' +
                ", activityDueDate=" + activityDueDate +
                ", status=" + status +
                '}';
    }
}
