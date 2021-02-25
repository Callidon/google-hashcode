package fr.patounes.hashcode.cars.data;

import java.util.LinkedList;
import java.util.List;

public class Output {
    public int nbIntersectionSpecs;
    public List<Schedule> schedules;

    public Output() {
        schedules = new LinkedList<>();
    }
}
