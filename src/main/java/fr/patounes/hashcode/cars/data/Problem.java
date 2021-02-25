package fr.patounes.hashcode.cars.data;

import java.util.LinkedList;
import java.util.List;

public class Problem {
    public int duration;
    public int nbIntersections;
    public int nbCars;
    public int nbStreets;
    public int carScore;
    public List<Street> streets;
    public List<Car> cars;
    public List<Intersection> intersections;

    public Problem(int duration, int nbIntersections, int nbCars, int nbStreets, int carScore) {
        this.duration = duration;
        this.nbIntersections = nbIntersections;
        this.nbCars = nbCars;
        this.nbStreets = nbStreets;
        this.carScore = carScore;
        streets = new LinkedList<>();
        cars = new LinkedList<>();
        intersections = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "Problem{" +
                "duration=" + duration +
                ", nbIntersections=" + nbIntersections +
                ", nbCars=" + nbCars +
                ", nbStreets=" + nbStreets +
                ", carScore=" + carScore +
                ", streets=" + streets +
                ", cars=" + cars +
                '}';
    }
}
