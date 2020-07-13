

public class Selection {
    public static void sort(double[] arr) {
        for(int i=0;i<arr.length-1;i++){
            int minInd = i;
            for (int j=i+1;j<arr.length;j++){
                if(arr[minInd]>arr[j]){
                    minInd = j;
                }
            }
            Swap.arr(arr,i,minInd);
        }
    }
    public static void sort(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            int minInd = i;
            for (int j=i+1;j<arr.length;j++){
                if(arr[minInd]>arr[j]){
                    minInd = j;
                }
            }
            Swap.arr(arr,i,minInd);
        }
    }
}
