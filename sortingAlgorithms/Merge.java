package sortingAlg;

public class Merge {
    public static int[] sort(int[] arr){
        int len = arr.length;
        if (len < 2) return arr;
        int mid = len/2;
        int[] left = sortingAlg.arrayFunc.split(arr, 0, mid);
        int[] right = sortingAlg.arrayFunc.split(arr, mid);
        return merge(sort(left),sort(right));
    }
    public static double[] sort(double[] arr){
        int len = arr.length;
        if (len < 2) return arr;
        int mid = len/2;
        double[] left = sortingAlg.arrayFunc.split(arr,0, mid);
        double[] right = sortingAlg.arrayFunc.split(arr, mid);
        return merge(sort(left),sort(right));
    }

    public static int[] merge(int[] left, int[] right){
        int llen = left.length,rlen = right.length;
        int[] result = new int[llen + rlen];
        int i = 0,j = 0,k= 0;
        while (j <llen && k<rlen){
            if (left[j]<right[k]){
                result[i++] = left[j++];
            }else{
                result[i++] = right[k++];
            }
        }
        if (j == llen) while (k < rlen) result[i++] = right[k++];
        if (k == rlen) while (j < llen) result[i++] = right[j++];
        return result;
    }
    public static double[] merge(double[] left, double[] right){

        int llen = left.length,rlen = right.length;
        double[] result = new double[llen + rlen];
        int i = 0,j = 0,k= 0;
        while (j <llen && k<rlen){
            if (left[j]<right[k]){
                result[i++] = left[j++];
            }else{
                result[i++] = right[k++];
            }
        }
        if (j == llen) while (k < rlen) result[i++] = right[k++];
        if (k == rlen) while (j < llen) result[i++] = right[j++];
        return result;
    }
}
