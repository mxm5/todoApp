package testers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class SortingTest {
    public static void main(String[] args) {
        EntityManagerFactory todo_app = Persistence.createEntityManagerFactory("todo_app");
        EntityManager entityManager = todo_app.createEntityManager();
        Query query = entityManager.createQuery("select t from ActivityEntity t where user_id = NULL order by status desc");
        List resultList = query.getResultList();
        for (Object r :resultList) System.out.println(r);
    }
}
