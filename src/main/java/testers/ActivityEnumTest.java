package testers;

import entities.ActivityEntity;
import entities.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class ActivityEnumTest {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("todo_app");
        EntityManager manager = managerFactory.createEntityManager();
        ActivityEntity activity = new ActivityEntity();
        activity.setActivityName("my third Activity");
        activity.setActivityNotes("hello hi man");
        Date parse = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
             parse = simpleDateFormat.parse("12/11/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(parse != null) activity.setActivityDueDate(new Timestamp(parse.getTime()));

        EntityTransaction transaction = manager.getTransaction();


        UserEntity user2 = manager.find(UserEntity.class, 1L);

        user2.getUserActivities().add(activity);

        transaction.begin();
        manager.persist(activity);
        manager.persist(user2);
        transaction.commit();


        UserEntity user = manager.find(UserEntity.class, 1L);
        Set<ActivityEntity> userActivities = user.getUserActivities();
        for (ActivityEntity activity1 :userActivities)
            System.out.println(activity1);
    }
}
