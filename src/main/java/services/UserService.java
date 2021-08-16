package services;

import entities.ActivityEntity;
import entities.UserEntity;
import repositories.ActivityRepository;
import repositories.UserRepository;
import services.base.Service;

public class UserService extends Service<UserEntity, UserRepository> {
    private ActivityRepository activityRepository;
    public UserService() {
        super(new UserRepository());
        activityRepository = new ActivityRepository();
    }


    public UserEntity login(UserEntity enteredUser){

       return repository.findByUserNameAndPassWord(enteredUser);
    }

    public boolean createActivity(ActivityEntity newActivity, UserEntity user){
        Boolean aBoolean = activityRepository.addNewActivity(newActivity);

        if(aBoolean) {

            return repository.assignActivity(newActivity, user);
        }
        return false;
    }

    public Boolean register(UserEntity registered) {
        return repository.addNewUser(registered);
    }
}
