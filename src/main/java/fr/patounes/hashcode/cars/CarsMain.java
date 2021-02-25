package fr.patounes.hashcode.cars;

import fr.patounes.hashcode.cars.data.Output;
import fr.patounes.hashcode.cars.data.Problem;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CarsMain {
    public static void main(String[] args) throws IOException {
        System.out.println("Processing a.txt");
        Problem problem = CarParser.parseInput("src/main/resources/2021/a.txt");
        Output output = ProblemSolver.solve(problem);
        CarParser.produceOutput(output, "src/main/resources/2021/output/a.out");

        System.out.println("Processing b.txt");
        problem = CarParser.parseInput("src/main/resources/2021/b.txt");
        output = ProblemSolver.solve(problem);
        CarParser.produceOutput(output, "src/main/resources/2021/output/b.out");

        System.out.println("Processing c.txt");
        problem = CarParser.parseInput("src/main/resources/2021/c.txt");
        output = ProblemSolver.solve(problem);
        CarParser.produceOutput(output, "src/main/resources/2021/output/c.out");

        System.out.println("Processing d.txt");
        problem = CarParser.parseInput("src/main/resources/2021/d.txt");
        output = ProblemSolver.solve(problem);
        CarParser.produceOutput(output, "src/main/resources/2021/output/d.out");

        System.out.println("Processing e.txt");
        problem = CarParser.parseInput("src/main/resources/2021/e.txt");
        output = ProblemSolver.solve(problem);
        CarParser.produceOutput(output, "src/main/resources/2021/output/e.out");

        System.out.println("Processing f.txt");
        problem = CarParser.parseInput("src/main/resources/2021/f.txt");
        output = ProblemSolver.solve(problem);
        CarParser.produceOutput(output, "src/main/resources/2021/output/f.out");
//        List<Integer> maliste = new LinkedList<>();
//        maliste.add(1);
//        maliste.add(2);
//        maliste.add(3);
//        maliste.sort((o1, o2) -> {
//            if (o1 > o2) {
//                return -1;
//            } else if (o1 < o2) {
//                return 1;
//            }
//            return 0;
//        });
//        System.out.println(maliste);
    }

}
