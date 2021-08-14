package testers;

import entities.ActivityEntity;
import entities.UserEntity;
import repositories.ActivityRepository;
import repositories.UserRepository;
import services.UserService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class OneToManyTest  {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("todo_app");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        UserRepository userRepository = new UserRepository();
        ActivityRepository activityRepository = new ActivityRepository();

        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(2L);

        List<ActivityEntity> allUsersActivity = activityRepository.getAllUsersActivity(userEntity);
        System.out.println(activityRepository);

        transaction.commit();
        manager.close();
        factory.close();

    }
}
