package sortingAlg;

public class Insertion {
    public static void sort(int[] arr){
        for (int i=1;i<arr.length+1;i++){
            int preInd = i-1;
            while(preInd>0&&arr[preInd-1]>arr[preInd]){
                Swap.arr(arr,preInd-1,preInd);
                preInd--;
            }
        }
    }
    public static void sort(double[] arr){
        for (int i=1;i<arr.length+1;i++){
            int preInd = i-1;
            while(preInd>0&&arr[preInd-1]>arr[preInd]){
                Swap.arr(arr,preInd-1,preInd);
                preInd--;
            }
        }
    }
}
