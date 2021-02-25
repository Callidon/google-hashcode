package fr.patounes.hashcode.cars;

import fr.patounes.hashcode.cars.data.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProblemSolver {
    public static Output solve(Problem problem) {
        // calcul de la popularité
        Map<String, Integer> popularities = new HashMap<>();

        for(Street street: problem.streets) {
            popularities.put(street.streetName, 0);
        }
        for(Car car: problem.cars) {
            for(String streetName: car.path) {
                popularities.put(streetName, popularities.get(streetName) + 1);
            }
        }

        Output output = new Output();
        for(Intersection intersection: problem.intersections) {
            Schedule schedule = new Schedule(intersection.id);

            int nbTop = 2;
            List<Street> rankedStreets = new LinkedList<>(intersection.incomingStreets);
            rankedStreets.sort((o1, o2) -> {
                if (popularities.get(o1.streetName) > popularities.get(o2.streetName)) {
                    return -1;
                } else if (popularities.get(o1.streetName) < popularities.get(o2.streetName)) {
                    return 1;
                }
                return 0;
            });
            List<Integer> top;
            if (nbTop < intersection.incomingStreets.size()) {
                top = rankedStreets.subList(0, nbTop).stream().map(street -> street.id).collect(Collectors.toList());
            } else {
                top = rankedStreets.stream().map(street -> street.id).collect(Collectors.toList());
            }

            for(Street street: intersection.incomingStreets) {
                if (popularities.get(street.streetName) > 0) {
                    if (top.get(0) == street.id) {
                        schedule.pairs.add(new PairSchedule(street.streetName, 3));
                    } else if (top.get(1) == street.id) {
                        schedule.pairs.add(new PairSchedule(street.streetName, 2));
                    } else {
                        schedule.pairs.add(new PairSchedule(street.streetName, 1));
                    }
                }
            }
            if (schedule.pairs.size() > 0) {
                output.schedules.add(schedule);
            }
        }

        return output;
    }
}
