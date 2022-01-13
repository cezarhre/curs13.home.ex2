package ro.fasttrackit.curs13.homework.ex1;

import java.util.*;

public class DaySchedule {

    private final DayOfWeek dayOfWeek;
    private final List<String> activities;

    public DaySchedule(DayOfWeek dayOfWeek, List<String> activities){
        this.dayOfWeek = dayOfWeek;
        this.activities = activities ==null
                ? new ArrayList<>()
                : new ArrayList<>(activities);
    }

    public List<String> getActivities() {
        return activities;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DaySchedule)) return false;
        DaySchedule that = (DaySchedule) o;
        return getDayOfWeek() == that.getDayOfWeek() && Objects.equals(getActivities(), that.getActivities());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDayOfWeek(), getActivities());
    }

    @Override
    public String toString() {
        return "DaySchedule{" +
                "dayOfWeek=" + dayOfWeek +
                ", activities=" + activities +
                '}';
    }
}
