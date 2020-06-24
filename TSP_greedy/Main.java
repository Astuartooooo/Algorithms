/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tspimproved;

/**
 *
 * @author 81265
 */
import java.util.ArrayList;


/*
    You can modify this file. but I will remove any modification of yours and replace the whole file with mine.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<City> cities = TSPSolver.readFile("D:\\Document\\cw2 files\\R110_1.TXT");
        cities = TSPSolver.solveProblem(cities);
        System.out.printf("Distances: %f\n", TSPSolver.printSolution(cities));
        cities = TSPSolver.improveRoutine(cities);
        System.out.printf("After improving: %f\n", TSPSolver.printSolution(cities));
    }
}
