package sortingAlg;


public class randomArray {
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
