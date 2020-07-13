

public class sorting_Main {

    public static void main(String[] args) {
        int[] a = arrayFunc.gint(15,0,40);
        a = Merge.mergeSort(a);
        arrayFunc.printArr(a);
    }
}
