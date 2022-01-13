package ro.fasttrackit.curs13.homework.ex1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DailyPlanner {

    private final List<DaySchedule> daySchedules;

    public DailyPlanner(List<DaySchedule> daySchedules) {
        this.daySchedules = daySchedules == null
                ? new ArrayList<>()
                : new ArrayList<>(daySchedules);
    }

    public List<DaySchedule> getDayActivities(DayOfWeek dayOfWeek) {
        List<DaySchedule> result = new ArrayList<>();
        for (DaySchedule daySched : daySchedules) {
            if (daySched.getDayOfWeek() == dayOfWeek) {
                result.add(daySched);
            }
        }
        return result;

    }

    public void addDayActivity(DayOfWeek dayOfWeek, String activity) throws NoActivityException {
        for (DaySchedule element : daySchedules) {
            if (element.getDayOfWeek() == dayOfWeek) {
                element.getActivities().add(activity);
            }
        }
        if (activity == null) {
            throw new NoActivityException();
        }
    }

    public void remDayActivity(DayOfWeek dayOfWeek, String activity) throws NoActivityException {
        for (DaySchedule element : daySchedules) {
            if (element.getDayOfWeek() == dayOfWeek) {
                element.getActivities().remove(activity);
            }
        }
        if (activity == null) {
            throw new NoActivityException();
        }
    }

    public Map<DayOfWeek, List<String>> getEndDayActivities(DayOfWeek dayOfWeek, List<String> activities) throws NoActivitiesForDayException {
        Map<DayOfWeek, List<String>> result = new HashMap<>();
        for (DaySchedule day : daySchedules) {
            if (day.getDayOfWeek() == dayOfWeek) {
                result.put(day.getDayOfWeek(), day.getActivities());
            }
        }
        if (activities != null) {
            return result;
        } else {
            throw new NoActivitiesForDayException();
        }
    }

    class NoActivitiesForDayException extends Throwable {
    }

    class NoActivityException extends Exception {
        private String activity;
    }
}