package repositories;

import entities.ActivityEntity;
import entities.UserEntity;
import entities.enums.SortingOrder;
import entities.enums.Status;
import repositories.base.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

public class ActivityRepository extends Repository<ActivityEntity> {


    public List<ActivityEntity> getAllUsersActivity(UserEntity user) {

        Query query = entityManager.createQuery("select a from ActivityEntity a  where user_id = " + user.getUserId());
        try {
            return ((List<ActivityEntity>) query.getResultList());

        } catch (Exception e) {
            return null;
        }

    }


//    public List getUsersActivities(Long userId) {
//
//        Query query = entityManager.createQuery("select t from ActivityEntity t where user_id = " + userId + " order by status asc");
//        try {
//
//            return query.getResultList();
//        } catch (Exception e) {
//            return null;
//        }
//
//
//    }

    public Boolean addNewActivity(ActivityEntity activity) {
        Boolean res;
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(activity);
            entityManager.getTransaction().commit();
            res = Boolean.TRUE;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            res = Boolean.FALSE;
        }
        return res;
    }

    public ActivityEntity update(ActivityEntity edit) {
        entityManager.getTransaction().begin();
        entityManager.merge(edit);
        entityManager.getTransaction().commit();
        return entityManager.find(ActivityEntity.class, edit.getActivityId());
    }


    public List<ActivityEntity> sortByName(UserEntity user, SortingOrder order) {
        String sort = (order == SortingOrder.Ascending) ? "asc" : "desc";
        Query query = entityManager.createQuery("select t from ActivityEntity t where user_id = " + user.getUserId() + " order by activityName " + sort);
        try {
            List<ActivityEntity> resultList = query.getResultList();
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    public List<ActivityEntity> sortByDate(UserEntity user, SortingOrder order) {
        String sort = (order == SortingOrder.Ascending) ? "asc" : "desc";
        Query query = entityManager.createQuery("select t from ActivityEntity t where user_id = " + user.getUserId() + " order by activityDueDate " + sort);
        try {
            List<ActivityEntity> resultList = query.getResultList();
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<ActivityEntity> sortByStatus(UserEntity user, Map<Status, Integer> order) {

        Query query = entityManager.createQuery("select t from ActivityEntity t where user_id = " + user.getUserId() + " order by (case when t.status ='open' then " + order.get(Status.Open) + "\n" +
                "                when t.status ='done' then " + order.get(Status.Done) + "\n" +
                "                else " + order.get(Status.Progress) + "\n" +
                "                end) asc"
        );
        try {
            List<ActivityEntity> resultList = query.getResultList();
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void remove(ActivityEntity remove) {
        entityManager.getTransaction().begin();
        entityManager.remove(remove);
        entityManager.getTransaction().commit();
    }
}
