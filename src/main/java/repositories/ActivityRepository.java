package repositories;

import entities.ActivityEntity;
import entities.UserEntity;
import repositories.base.Repository;

import javax.persistence.Query;
import java.util.List;

public class ActivityRepository extends Repository<ActivityEntity> {


    public List<ActivityEntity> getAllUsersActivity(UserEntity user) {
        
        Query query = entityManager.createQuery("select a from ActivityEntity a ");
        try {
            return ((List<ActivityEntity>) query.getResultList());

        }catch (Exception e){
            return null;
        }

    }


    public Boolean addNewActivity(ActivityEntity activity) {
        Boolean res = Boolean.FALSE;
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
}
