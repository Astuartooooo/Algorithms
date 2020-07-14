import java.util.ArrayList;
import java.util.Collections;

public class arrayFunc {
    public static int[] split(int[] arr, int start, int end){
        int len = end - start, i = 0;
        int[] result = new int[len];
        while(i<len) result[i] = arr[i++];
        return result;
    }
    public static int[] split(int[] arr, int start){
        int len = arr.length - start, i = 0;
        int[] result = new int[len];
        while(i<len) result[i] = arr[start+(i++)];
        return result;
    }

    public static double[] split(double[] arr, int start, int end){
        int len = end - start, i = 0;
        double[] result = new double[len];
        while(i<len) result[i] = arr[i++];
        return result;
    }
    public static double[] split(double[] arr, int start){
        int len = arr.length - start, i = 0;
        double[] result = new double[len];
        while(i<len) result[i] = arr[start+(i++)];
        return result;
    }

    public static void printArr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
        System.out.println();
    }
    public static void printArr(double[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
        System.out.println();
    }

    public static int[] gint(int num, int lowbound, int upbound){
        int arr[] = new int[num];
        for (int i=0;i<num;i++){
            arr[i] = (int) (Math.random()*(upbound-lowbound)+lowbound);
        }
        return arr;
    }
    public static double[] gdb(int num, int lowbound, int upbound){
        double arr[] = new double[num];
        for (int i=0;i<num;i++){
            arr[i] =(double)((int) ((Math.random()*(upbound-lowbound)+lowbound)*100))/100;
        }
        return arr;
    }

    public static void swapArr(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void swapArr(double[] arr, int i,int j){
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void swapList(ArrayList list, int i, int j){
        Collections.swap(list,  i,  j);
    }
}
