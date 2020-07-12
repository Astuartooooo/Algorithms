package sortingAlg;


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

    public static void number(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
    }
    public static void number(double[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
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
}
