package views;

import entities.UserEntity;
import repositories.UserRepository;
import services.UserService;
import views.Base.Page;

public class LoginPage extends Page {

    public static final UserService userService = new UserService(new UserRepository());

    @Override
    protected void run() {

        String username = enterValue("enter your user name", 3);

        String password = enterValue("enter your password", 3);

        UserEntity enteredUser = new UserEntity(username,password);

        UserEntity login = userService.login(enteredUser);


        if (login != null) {
            success("login successful");
            new HomePage(login);
        }
        else {
            warning("wrong information");
            new WelcomePage();
        }

    }
}
