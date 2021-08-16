package repositories;

import entities.ActivityEntity;
import entities.UserEntity;
import repositories.base.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

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

    public  ActivityEntity update(ActivityEntity edit){
        entityManager.getTransaction().begin();
        entityManager.merge(edit);
        entityManager.getTransaction().commit();
       return entityManager.find(ActivityEntity.class , edit.getActivityId());
    }

}
