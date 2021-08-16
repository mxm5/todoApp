package testers;

import antlr.StringUtils;
import views.Base.Page;

import java.io.PrintStream;

public class tableShow {


    public static void main(String[] args) {

        System.out.println("+" + "-----"+("+" + "-".repeat(33)).repeat(3) + "+");
        for (int i = 0; i < 200; i++) {
            System.out.printf("| %-4d|   %-30s|   %-30s|   %-30s|%n",i+1, "helloe", "bye", "hi");
                 System.out.println("+" + "-----"+("+" + "-".repeat(33)).repeat(3) + "+");

        }


    }
}
