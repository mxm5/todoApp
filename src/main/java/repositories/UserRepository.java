package repositories;

import entities.ActivityEntity;
import entities.UserEntity;
import repositories.base.Repository;

import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

public class UserRepository extends Repository<UserEntity> {


    public UserEntity findByUserNameAndPassWord(UserEntity user) {

        Query query = entityManager.createQuery("select u from UserEntity u where u.userName = '" + user.getUserName() + "' and u.userPassword ='" + user.getUserPassword() + "' ");
        try {
            return ((UserEntity) query.getSingleResult());

        } catch (Exception e) {
            return null;
        }

    }


    public Boolean addNewUser(UserEntity registered) {
        Boolean res;
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(registered);
            entityManager.getTransaction().commit();
            res = Boolean.TRUE;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            res = Boolean.FALSE;
        }
        return res;
    }

    public Boolean assignActivity(ActivityEntity newActivity, UserEntity user) {

        boolean res;
        try {
            UserEntity foundUser = entityManager.find(UserEntity.class, user.getUserId());
            entityManager.getTransaction().begin();
            foundUser.getUserActivities().add(newActivity);
            List<ActivityEntity> userActivities = foundUser.getUserActivities();
            for (ActivityEntity activity : userActivities) System.out.println(activity);
            entityManager.getTransaction().commit();
            res = true;

        } catch (Exception e) {
            res = false;
        }

        return res;
    }
}
