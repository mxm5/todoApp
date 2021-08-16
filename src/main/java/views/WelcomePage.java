package views;

import views.Base.Page;

import java.util.List;

public class WelcomePage extends Page {

    public WelcomePage() {
        run();

    }

    @Override
    protected void run() {

        printOptions(List.of("login", "register", "exit"));
        int select = selectOpt(3);

        switch (select) {
            case 1 -> new LoginPage();
            case 2 -> new RegisterPage();
            case 3 -> {
                printTitle("good bye");
                print("exiting ...");
            }
        }

    }


}
