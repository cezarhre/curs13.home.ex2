package ro.fasttrackit.curs13.homework.ex1;

import java.util.*;

import static java.util.List.*;

public class DailyMain {
    public static void main(String[] args) throws DailyPlanner.NoActivitiesForDayException,DailyPlanner.NoActivityException {

        DailyPlanner dailyPlanner = new DailyPlanner(of(

                new DaySchedule(DayOfWeek.MONDAY, List.of("Activitati culturale","Clasica","Opera")),
                new DaySchedule(DayOfWeek.TUESDAY, List.of("Activitati sportive in sala","Activitati sportive afara")),
                new DaySchedule(DayOfWeek.WEDNESDAY, List.of("Lectura")),
                new DaySchedule(DayOfWeek.THURSDAY, List.of()),
                new DaySchedule(DayOfWeek.FRIDAY, List.of("Intilnire cu prietenii")),
                new DaySchedule(DayOfWeek.SATURDAY, List.of("Munte"," Gratar")),
                new DaySchedule(DayOfWeek.SUNDAY, List.of("Activitati in familie"))
        ));

        System.out.println(dailyPlanner.getDayActivities(DayOfWeek.MONDAY));
        System.out.println(dailyPlanner.getEndDayActivities(DayOfWeek.MONDAY,List.of()));
        dailyPlanner.addDayActivity(DayOfWeek.MONDAY,"Muzica simfonica");
        System.out.println(dailyPlanner.getEndDayActivities(DayOfWeek.MONDAY,List.of()));
        dailyPlanner.addDayActivity(DayOfWeek.TUESDAY,"Baschet");
        dailyPlanner.addDayActivity(DayOfWeek.FRIDAY,"Activitati cu vecinii");
        dailyPlanner.remDayActivity(DayOfWeek.MONDAY,"Clasica");
        System.out.println(dailyPlanner.getEndDayActivities(DayOfWeek.MONDAY,List.of()));
        System.out.println(dailyPlanner.getEndDayActivities(DayOfWeek.TUESDAY,List.of()));
        System.out.println(dailyPlanner.getEndDayActivities(DayOfWeek.FRIDAY,List.of()));

    }
}
