package testers;

import entities.ActivityEntity;
import views.Base.Page;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class betterSortTest {
    public static void main(String[] args) {
        EntityManagerFactory todo_app = Persistence.createEntityManagerFactory("todo_app");
        EntityManager entityManager = todo_app.createEntityManager();
        Query query = entityManager.createQuery("""
                select t from ActivityEntity t  order by (case when t.status ='open' then 2
                when t.status ='done' then 3
                else 1
                end) asc""");
        List<ActivityEntity> userActivities = query.getResultList();
        int activityIndexer = 1;

        Page page = new Page() {
            @Override
            protected void run() {

            }
        };


        page.print(("+"+"-".repeat(33)).repeat(3));

        for (ActivityEntity act : userActivities) {
            page.line();
            page.print("\tnumber   : " + activityIndexer++);
            page.print();
            page.print("\ttitle  : " + act.getActivityName());
            page.print("\tdate   : " + act.getActivityDueDateInFormat());
            page.print("\tstatus : " + act.getStatus());
            page.print("\tnotes  : " + act.getActivityNotes());


        }
    }
}
