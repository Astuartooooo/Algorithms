

public class Merge {



    public static int[] mergeSort(int[] arr){
        int len = arr.length;
        if (len < 2) return arr;
        int mid = len/2;
        int[] left = arrayFunc.split(arr, 0, mid),right = arrayFunc.split(arr, mid);
        return merge(mergeSort(left),mergeSort(right));
    }
    public static double[] mergeSort(double[] arr){
        int len = arr.length;
        if (len < 2) return arr;
        int mid = len/2;
        double[] left = arrayFunc.split(arr,0, mid),right = arrayFunc.split(arr, mid);;
        return merge(mergeSort(left),mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right){
        int llen = left.length,rlen = right.length;
        int[] result = new int[llen + rlen];
        int i = 0,j = 0,k= 0;
        while (j <llen && k<rlen) result[i++] = (left[j]<right[k])? left[j++]:right[k++];
        while (k<rlen) result[i++] = right[k++];
        while (j<llen) result[i++] = left[j++];
        return result;
    }
    public static double[] merge(double[] left, double[] right){
        int llen = left.length,rlen = right.length;
        double[] result = new double[llen + rlen];
        int i = 0,j = 0,k= 0;
        while (j <llen && k<rlen) result[i++] = (left[j]<right[k])? left[j++]:right[k++];
        while (k<rlen) result[i++] = right[k++];
        while (j<llen) result[i++] = left[j++];
        return result;
    }
}
