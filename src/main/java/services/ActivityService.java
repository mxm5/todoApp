package services;

import entities.ActivityEntity;
import entities.UserEntity;
import entities.enums.SortingOrder;
import entities.enums.Status;
import repositories.ActivityRepository;
import repositories.UserRepository;
import services.base.Service;

import java.util.List;
import java.util.Map;

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


    public List<ActivityEntity> sortByName(UserEntity user , SortingOrder order) {
        return  repository.sortByName( user ,  order);
    }

    public List<ActivityEntity> sortByStatus(UserEntity user, Map<Status,Integer> order){
        return repository.sortByStatus(user,order);
    }

    public void removeActivity(ActivityEntity remove) {
        repository.remove(remove);
    }
}
