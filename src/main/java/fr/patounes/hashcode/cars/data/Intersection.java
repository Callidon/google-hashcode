package fr.patounes.hashcode.cars.data;

import java.util.LinkedList;
import java.util.List;

public class Intersection {
    public int id;
    public List<Street> incomingStreets;

    public Intersection(int id) {
        this.id = id;
        incomingStreets = new LinkedList<>();
    }
}
