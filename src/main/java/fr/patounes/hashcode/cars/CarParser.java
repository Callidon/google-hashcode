package fr.patounes.hashcode.cars;

import fr.patounes.hashcode.cars.data.*;

import java.io.*;

public class CarParser {

    public static Problem parseInput(String filePath) {
        int bufferSize = 8 * 1024;
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath), bufferSize)) {
                String line = reader.readLine();
                String[] firstLine = line.split(" ");

                // read problem inputs
                int duration = Integer.parseInt(firstLine[0]);
                int nbIntersections = Integer.parseInt(firstLine[1]);
                int nbStreets = Integer.parseInt(firstLine[2]);
                int nbCars = Integer.parseInt(firstLine[3]);
                int carScore = Integer.parseInt(firstLine[4]);
                Problem problem = new Problem(duration, nbIntersections, nbCars, nbStreets, carScore);

                // build streets
                for(int i = 0; i < nbStreets; i++) {
                    line = reader.readLine();
                    String[] currentLine = line.split(" ");
                    int startIntersectionID = Integer.parseInt(currentLine[0]);
                    int endIntersectionID = Integer.parseInt(currentLine[1]);
                    String streetName = currentLine[2];
                    int streetDuration = Integer.parseInt(currentLine[3]);
                    problem.streets.add(new Street(i, startIntersectionID, endIntersectionID, streetName, streetDuration));
                }

                // build cars
                for(int i = 0; i < nbCars; i++) {
                    line = reader.readLine();
                    String[] currentLine = line.split(" ");
                    int nbStreetsToTravel = Integer.parseInt(currentLine[0]);
                    Car car = new Car(i, nbStreetsToTravel);
                    for(int j = 0; j < nbStreetsToTravel; j++) {
                        car.path.add(currentLine[j + 1]);
                    }
                    problem.cars.add(car);
                }

                // build intersections
                for(int i = 0; i < problem.nbIntersections; i ++) {
                    problem.intersections.add(new Intersection(i));
                }
                for(Street street: problem.streets) {
                    problem.intersections.get(street.endIntersectionID).incomingStreets.add(street);
                }

                return problem;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void produceOutput(Output output, String outputPath)  throws IOException {
        File file = new File(outputPath);
        // create file beforehand
        file.createNewFile();
        try (PrintWriter writer = new PrintWriter(file, "UTF-8")) {
            writer.println(output.schedules.size());

            for(Schedule schedule: output.schedules) {
                writer.println(schedule.intersectionID);
                writer.println(schedule.pairs.size());

                for(PairSchedule pairSchedule: schedule.pairs) {
                    writer.println(String.format("%s %d", pairSchedule.streetName, pairSchedule.greenDuration));
                }
            }
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
