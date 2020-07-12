package sortingAlg;

public class Main {

    public static void main(String[] args) {
        int[] a = sortingAlg.arrayFunc.gint(15,0,40);
        sortingAlg.Merge.sort(a);
        sortingAlg.arrayFunc.number(a);
    }
}
