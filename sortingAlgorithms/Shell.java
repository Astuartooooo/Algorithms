

public class Shell {
    public static void sort(int[] arr) {
        int len= arr.length;
        for (int gap = len / 2; gap > 0; gap = gap/ 2) {
            for (int i = gap; i < len; i++) {
                int j = i;
                while ((j-gap)>=0 && arr[j-gap]>arr[j]){
                    Swap.arr(arr, j, j-gap);
                    j = j-gap;
                }
            }
        }
    }

    public static void sort(double[] arr) {
        int len= arr.length;
        for (int gap = len / 2; gap > 0; gap = gap/ 2) {
            for (int i = gap; i < len; i++) {
                int j = i;
                while ((j-gap)>=0 && arr[j-gap]>arr[j]){
                    Swap.arr(arr, j, j-gap);
                    j = j-gap;
                }
            }
        }
    }
}
