package views;

import entities.ActivityEntity;
import entities.UserEntity;
import entities.enums.SortingOrder;
import entities.enums.Status;
import services.ActivityService;
import views.Base.Page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortActivities extends Page {

    private final UserEntity user;


    public SortActivities(UserEntity user) {

        this.user = user;
        run();
    }

    @Override
    protected void run() {

        ActivityService activityService = new ActivityService();

        boolean sorting = true;
        while (sorting) {
            print("sort by ...");
            List<String> actionsList = List.of(
                    "name",
                    "status",
                    "date",
                    "manage activity"
            );
            printOptions(actionsList);
            int opt = selectOpt(4);
            switch (opt) {
                case 1 -> {
                    // name selected

                    printOptions(List.of("ascending", "descending"));
                    int nameSortOrder = selectOpt(2);
                    SortingOrder order = nameSortOrder == 1 ? SortingOrder.Ascending : SortingOrder.Descending;
                    List<ActivityEntity> sortedActivitiesList = activityService.sortByName(user, order);
                   sortedActivitiesList.get(0).printTableHead();
                    int index = 1;
                    for (ActivityEntity act : sortedActivitiesList) act.printAsTableRow(index++);
                }
                case 2 -> {
                    // status selected
                    Map<Status, Integer> order = new HashMap<>();
                    print("what status to show first");
                    List<Status> statuses = new ArrayList<>();
                    statuses.add(Status.Open);
                    statuses.add(Status.Done);
                    statuses.add(Status.Progress);
                    printOptions((List)(statuses));
                    int firstStatusIndexP = selectOpt(3);
                    Status first = statuses.get(firstStatusIndexP-1);
                    order.put(first,1);
                    statuses.remove(first);
                    print("what status to show next");
                    printOptions((List)(statuses));
                    int secondStatusIndexP =selectOpt(2);
                    Status second = statuses.get(secondStatusIndexP - 1);
                    order.put(second , 2);
                    statuses.remove(second);
                    order.put(statuses.get(0),3);

                    List<ActivityEntity> sortedActivitiesList = activityService.sortByStatus(user, order);

                   sortedActivitiesList.get(0).printTableHead();
                    int index = 1;
                    for (ActivityEntity act : sortedActivitiesList) act.printAsTableRow(index++);


                }
                case 3 -> {
                    // date selected

                    printOptions(List.of("Ascending", "Descending"));
                    int dateSortOrder = selectOpt(2);
                    SortingOrder order = dateSortOrder == 1 ? SortingOrder.Ascending : SortingOrder.Descending;
                    List<ActivityEntity> sortedActivitiesList = activityService.sortByName(user, order);
                   sortedActivitiesList.get(0).printTableHead();
                    int index = 1;
                    for (ActivityEntity act : sortedActivitiesList) act.printAsTableRow(index++);
                }
                case 4 -> {

                    sorting = false;
                    new ActivityManager(user);
                }
            }

        }


    }
}
