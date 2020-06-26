package sortingAlg;

import java.util.ArrayList;
import java.util.Collections;

public class Swap {
    public static void arr(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void arr(double[] arr, int i,int j){
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void list(ArrayList list,int i,int j){
        Collections.swap(list,  i,  j);
    }
}
