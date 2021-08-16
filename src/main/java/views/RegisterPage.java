package views;

import entities.UserEntity;
import repositories.UserRepository;
import services.UserService;
import views.Base.Page;

public class RegisterPage extends Page {
    public static final UserService userService = new UserService();


    public RegisterPage() {
        run();
    }

    @Override
    protected void run() {
        String fullName = enterValue("enter your full name", 3);
        String userName = enterValue("enter your personal user name", 3);

        String password;
        while (true) {
             password = enterValue("enter your your password", 3);
            String confirm = enterValue("confirm your password", 3);
            if(password.equals(confirm))break;
        }

        UserEntity registered = new UserEntity(fullName, userName, password);
        Boolean result = userService.register(registered);
        if (result) {
            success(" you registered");
            new LoginPage();
        }
        else
            new WelcomePage();

    }
}
