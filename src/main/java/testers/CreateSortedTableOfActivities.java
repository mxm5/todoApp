package testers;

import entities.ActivityEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CreateSortedTableOfActivities {

    public static void main(String[] args) {
        {
            EntityManagerFactory todo_app = Persistence.createEntityManagerFactory("todo_app");
            EntityManager entityManager = todo_app.createEntityManager();
//            Query query = entityManager.createQuery("select t from ActivityEntity t where user_id ="+1L+" order by t.activityDueDate asc");
            Query query = entityManager.createQuery("select t from ActivityEntity t where user_id ="+1L+" order by t.activityName asc");
//                    Query query = entityManager.createQuery("select t from ActivityEntity t where user_id ="+1L+" order by (case when t.status ='open' then 2\n" +
//                    "when t.status ='done' then 3\n" +
//                    "else 1\n" +
//                    "end) asc");
            List<ActivityEntity> userActivities = query.getResultList();
            int activityIndexer = 1;


            System.out.println("+" + "-----" + ("+" + "-".repeat(33)).repeat(3) + "+"+"-".repeat(12)+"+");
            System.out.printf("| %-4s|   %-30s|   %-30s|   %-30s|  %-10s|%n", "num", "title", "date","notes", "status");
            System.out.printf("| %-4s|   %-30s|   %-30s|   %-30s|  %-10s|%n", "", "", "", "","");
            System.out.println("+" + "-----" + ("+" + "-".repeat(33)).repeat(3) + "+"+"-".repeat(12)+"+");


            for (ActivityEntity act : userActivities) {

                System.out.printf("| %-4d|   %-30s|   %-30s|   %-30s|  %-10s|%n", activityIndexer++, act.getActivityName(), act.getActivityDueDateInFormat(),act.notesSummery() ,act.getStatus());
                System.out.println("+" + "-----" + ("+" + "-".repeat(33)).repeat(3) + "+"+"-".repeat(12)+"+");


            }




        }
    }

}
