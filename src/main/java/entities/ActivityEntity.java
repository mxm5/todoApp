package entities;

import entities.base.EntityModel;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;


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
