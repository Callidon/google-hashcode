package fr.patounes.hashcode.cars.data;

import java.util.LinkedList;
import java.util.List;

public class Schedule {
    public int intersectionID;
    public int nbIncomingStreets;
    public List<PairSchedule> pairs;

    public Schedule(int intersectionID) {
        this.intersectionID = intersectionID;
        pairs = new LinkedList<>();
    }
}
