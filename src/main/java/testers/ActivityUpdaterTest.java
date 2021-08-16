package testers;

import entities.ActivityEntity;
import entities.enums.Status;
import entities.UserEntity;
import views.Base.Page;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

public class ActivityUpdaterTest extends Page {

    public static void main(String[] args) {
        EntityManagerFactory todo_app = Persistence.createEntityManagerFactory("todo_app");
        EntityManager entityManager = todo_app.createEntityManager();
        UserEntity userEntity = entityManager.find(UserEntity.class, 1L);
        List<ActivityEntity> userActivities = userEntity.getUserActivities();

        Map<Integer, ActivityEntity> enumeratedActivities = new HashMap<>();
        int k = 1;
        for (ActivityEntity activity : userActivities) {
            System.out.println( k+". \n"+activity);
            enumeratedActivities.put(k, activity);
            k++;
        }

        int i = new
                Scanner(System.in).nextInt();
        boolean b = enumeratedActivities.containsKey(i);
        ActivityEntity selectedActivity = null;
        if(b)
         selectedActivity = enumeratedActivities.get(i);
        System.out.println(selectedActivity);
        System.out.println("selected");

        System.out.println( "1 . open 2.done 3.progress");
        int i1 = new Scanner(System.in).nextInt();

        assert selectedActivity != null;
        selectedActivity.setStatus(Status.Done);

        System.out.println(selectedActivity);

        entityManager.getTransaction().begin();

        entityManager.merge(selectedActivity);
        entityManager.getTransaction().commit();

        UserEntity userEntity2 = entityManager.find(UserEntity.class, 1L);
        List<ActivityEntity> userActivities2 = userEntity.getUserActivities();

        for (ActivityEntity activity : userActivities2)

            System.out.println(k+" \n"+activity);

    }

    @Override
    protected void run() {

    }
}
