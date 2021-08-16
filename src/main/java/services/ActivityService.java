package services;

import entities.ActivityEntity;
import entities.UserEntity;
import repositories.ActivityRepository;
import repositories.UserRepository;
import services.base.Service;

import java.util.List;

public class ActivityService extends Service<ActivityEntity, ActivityRepository> {


    public ActivityService() {
        super(new ActivityRepository());

    }

    public List<ActivityEntity> fetchUserActivities(UserEntity user) {
        return repository.getAllUsersActivity(user);
    }

    public ActivityEntity updateStatusForActivity(ActivityEntity activity) {
        return repository.update(activity);
    }


}
