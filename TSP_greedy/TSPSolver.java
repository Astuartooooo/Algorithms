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
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TSPSolver {

    public static double[][] distanceMat;

    public static ArrayList<City> readFile(String fileName) {
        Scanner scanner = null;
        ArrayList<City> citylist = new ArrayList<>();
        try {
            scanner = new Scanner(new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split("\\s+");
            City city = new City(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]));
            citylist.add(city);
        }
        distanceMat = new double[citylist.size()][citylist.size()];
        for (int i = 0; i < citylist.size(); i++) {
            for (int j = i; j < citylist.size(); j++) {
                if (i == j) {
                    distanceMat[i][j] = 0;
                } else {
                    distanceMat[i][j] = distanceMat[j][i] = citylist.get(i).distance(citylist.get(j));
                }
            }
        }
        return citylist;
    }

    public static double retDis(ArrayList<City> routine, int index1, int index2) {
        return distanceMat[routine.get(index1).getId()][routine.get(index2).getId()];
    }

    public static double retDis(ArrayList<City> routine, int index1, int index2, int index3) {
        return distanceMat[routine.get(index1).getId()][routine.get(index2).getId()] + distanceMat[routine.get(index2).getId()][routine.get(index3).getId()];
    }

    public static ArrayList<City> solveProblem(ArrayList<City> citiesToVisit) {
        ArrayList<City> routine = new ArrayList<>();
        routine.add(citiesToVisit.get(0));
        citiesToVisit.remove(0);
        int loopcounter = citiesToVisit.size();
        for (int i = 0; i < loopcounter; i++) {
            int listIndex = 0;
            double distance = Integer.MAX_VALUE;
            for (int n = 0; n < citiesToVisit.size(); n++) {
                if (distance > routine.get(routine.size() - 1).distance(citiesToVisit.get(n))) {
                    distance = routine.get(routine.size() - 1).distance(citiesToVisit.get(n));
                    listIndex = n;
                }
            }
            routine.add(citiesToVisit.get(listIndex));
            citiesToVisit.remove(listIndex);
        }

        routine.add(routine.get(0));
        return routine;
    }

    public static double printSolution(ArrayList<City> routine) {
        double ans = 0;
        for (int n = 0; n < routine.size() - 1; n++) {
            System.out.print(routine.get(n).getId() + "->");
        }
        System.out.println(routine.get(routine.size() - 1).getId());

        for (int i = 1; i < routine.size(); i++) {
            ans += routine.get(i - 1).distance(routine.get(i));
        }
        return ans;
    }

    public static double evaluateRoutine(ArrayList<City> routine) {
        double totalDistance = 0.0;
        for (int i = 0; i < routine.size() - 1; i++) {
            totalDistance += routine.get(i).distance(routine.get(i + 1));
        }
        return totalDistance;
    }

    private static void moveCity(ArrayList<City> routine, int from, int to) {
        routine.add(to, routine.get(from));
        routine.remove((from <= to) ? from : from + 1);
    }

    public static double evalMove(ArrayList<City> routine, int from, int to) {
        double oldDistance = retDis(routine, to, to - 1) + retDis(routine, from - 1, from, from + 1);
        double newDistance = retDis(routine, to - 1, from, to) + retDis(routine, from - 1, from + 1);
        return oldDistance - newDistance;
    }

    public static boolean moveFirstImprove(ArrayList<City> routine) {
        for (int i = 1; i < routine.size() - 1; i++) {
            for (int j = 1; j < routine.size() - 1; j++) {
                if (Math.abs(i - j) > 1) {
                    double diff = evalMove(routine, i, j);
                    if (diff > 0) {//0.00001
                        moveCity(routine, i, j);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void swapCity(ArrayList<City> routine, int index1, int index2) {
        Collections.swap(routine, index1, index2);
    }

    public static double evalSwap(ArrayList<City> routine, int i, int j) {
        double oldDistance = (i + 1 == j) ? retDis(routine, i, i - 1) + retDis(routine, j, j + 1) : retDis(routine, i - 1, i, i + 1) + retDis(routine, j - 1, j, j + 1);
        double newDistance = (i + 1 == j) ? retDis(routine, i - 1, j) + retDis(routine, i, j + 1) : retDis(routine, i - 1, j, i + 1) + retDis(routine, j - 1, i, j + 1);
        return oldDistance - newDistance;
    }

    public static boolean swapFirstImprove(ArrayList<City> routine) {
        for (int i = 1; i < routine.size() - 1; i++) {
            for (int j = i + 1; j < routine.size() - 1; j++) {
                double diff = evalSwap(routine, i, j);
                if (diff > 0) {
                    swapCity(routine, i, j);
                    return true;
                }
            }
        }
        return false;
    }

    public static void blockReverseCity(ArrayList<City> routine, int index1, int index2) {
        for (int i = 0; i < ((index2 - index1 + 1) / 2); i++) {
            Collections.swap(routine, index1 + i, index2 - i);
        }
    }

    public static double evalBlockReverse(ArrayList<City> routine, int index1, int index2) {
        double oldDistance = retDis(routine, index1, index1 - 1) + retDis(routine, index2, index2 + 1);
        double newDistance = retDis(routine, index2, index1 - 1) + retDis(routine, index1, index2 + 1);
        return oldDistance - newDistance;
    }

    public static boolean blockReverseFirstImprove(ArrayList<City> routine) {
        for (int i = 1; i < routine.size() - 1; i++) {
            for (int j = i + 3; j < routine.size() - 1; j++) {
                double diff = evalBlockReverse(routine, i, j);
                if (diff > 0) {
                    blockReverseCity(routine, i, j);
                    return true;
                }
            }
        }
        return false;
    }

    public static void blockInsertCity(ArrayList<City> routine, int index1, int index2, int index3) {
        for (int i = 0; i < index3 - index2 + 1; i++) {
            moveCity(routine, index2 + i, index1 + i);
        }
    }

    public static double evalBlockInsert(ArrayList<City> routine, int index1, int index2, int index3) {
        double oldDistance = retDis(routine, index1 - 1, index1) + retDis(routine, index2 - 1, index2) + retDis(routine, index3, index3 + 1);
        double newDistance = retDis(routine, index1 - 1, index2) + retDis(routine, index1, index3) + retDis(routine, index2 - 1, index3 + 1);
        return oldDistance - newDistance;
    }

    public static boolean blockInsertFirstImprove(ArrayList<City> routine) {
        for (int i = 1; i < routine.size() - 1; i++) {
            for (int j = i + 4; j < routine.size() - 1; j++) {
                int k = (i + j) / 2;
//                int k = (int) ((Math.random() * (j - 1 - i)) + i + 2);
                double diff = evalBlockInsert(routine, i, k, j);
                if (diff > 0) {
                    blockInsertCity(routine, i, k, j);
                    return true;

                }
            }
        }
        return false;
    }

    public static void reversedBlockInsertCity(ArrayList<City> routine, int from, int mid, int to) {
        if (from > to) {
            blockReverseCity(routine, mid + 1, from);
            blockInsertCity(routine, to, mid + 1, from);
        } else {
            blockReverseCity(routine, from, mid - 1);
            blockInsertCity(routine, from, mid, to);
        }
    }

    public static double evalReversedBlockInsert(ArrayList<City> routine, int from, int mid, int to) {
        if (from > to) {
            double oldDistance = retDis(routine, to - 1, to) + retDis(routine, mid + 1, mid) + retDis(routine, from, from + 1);
            double newDistance = retDis(routine, to - 1, from) + retDis(routine, to, mid + 1) + retDis(routine, mid, from + 1);
            return oldDistance - newDistance;
        } else {
            double oldDistance = retDis(routine, from - 1, from) + retDis(routine, mid - 1, mid) + retDis(routine, to, to + 1);
            double newDistance = retDis(routine, from - 1, mid) + retDis(routine, from, to + 1) + retDis(routine, mid - 1, to);
            return oldDistance - newDistance;
        }
    }

    public static boolean reversedBlockInsertImprove(ArrayList<City> routine) {
        for (int i = 1; i < routine.size() - 1; i++) {
            for (int j = 1; j < routine.size() - 1; j++) {
                if (Math.abs(i - j) > 4) {
                    int k = (i + j) / 2;
                    double diff = evalReversedBlockInsert(routine, i, k, j);
                    if (diff > 0) {
                        reversedBlockInsertCity(routine, i, k, j);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static ArrayList<City> improveRoutine(ArrayList<City> routine) {
        while (blockReverseFirstImprove(routine)||moveFirstImprove(routine)||swapFirstImprove(routine)||blockInsertFirstImprove(routine)||reversedBlockInsertImprove(routine)) {
        }
        return routine;
    }
}
//blockReverseFirstImprove(routine)||moveFirstImprove(routine)||swapFirstImprove(routine)||blockInsertFirstImprove(routine)||reversedBlockInsertImprove(routine)