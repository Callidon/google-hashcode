package fr.patounes.hashcode.cars.data;

import java.util.LinkedList;
import java.util.List;

public class Car {
    public int id;
    public int nbStreetsToVisit;
    public List<String> path;

    public Car(int id, int nbStreetsToVisit) {
        this.id = id;
        this.nbStreetsToVisit = nbStreetsToVisit;
        this.path = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", nbStreetsToVisit=" + nbStreetsToVisit +
                ", path=" + path +
                '}';
    }
}
