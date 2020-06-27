package sortingAlg;

public class Main {

    public static void main(String[] args) {
        double[] a = sortingAlg.randomArray.gdb(15,0,40);
        Bubble.sort(a);
        printArray.number(a);
    }
}
