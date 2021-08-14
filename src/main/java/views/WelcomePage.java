package views;

import views.Base.Page;

import java.util.List;

public class WelcomePage extends Page {

    @Override
    protected void run() {

        printOptions(List.of("login", "register", "exit"));
        int select = selectOpt(3);

        switch (select){
            case 1:
                new LoginPage();
                break;
            case 2:
                new RegisterPage();
                break;
            case 3:
                printTitle("good bye");
                print("exiting ...");
                break;
        }

    }


}
