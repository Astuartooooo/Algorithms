
public class Bubble {
    public static void sort(double[] arr) {
        for (int loop = 0; loop < arr.length ; loop++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i+1]) arrayFunc.swapArr(arr, i, i + 1);
            }
        }
    }

    public static void sort(int[] arr) {
        for (int loop = 0; loop < arr.length ; loop++) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i+1]) arrayFunc.swapArr(arr, i, i + 1);
            }
        }
    }
}
