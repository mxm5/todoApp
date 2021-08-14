package services;

import entities.ActivityEntity;
import repositories.ActivityRepository;
import repositories.UserRepository;
import services.base.Service;

public class ActivityService extends Service<ActivityEntity, ActivityRepository> {



    public ActivityService(ActivityRepository repository) {
        super(repository);
    }



}
