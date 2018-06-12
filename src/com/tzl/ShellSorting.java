package com.tzl;

/**
 * Created by tzl on 2018/6/12.
 */
public class ShellSorting {
    public static void main(String[] args){
        int[] arr = new int[100000];
        System.out.print("排序前的数组：");
        for (int i = 0; i<100000;i++){
            arr[i] = (int) (Math.random()*10000000);
            System.out.print(arr[i]+"\t");
        }
        System.out.println("");

        int[] result = shellSort(arr);

        for (int i = 0; i<100000;i++){
            System.out.print(result[i]+"\t");
        }
    }

    public static int[] shellSort(int[] arg){
        if (arg == null)
            return null;
        int[] mid = arg.clone();
        int N = mid.length;
        int k = 1;
        long curTime = System.currentTimeMillis();
        while (k < N/3)
            k = 3*k + 1;
        while (k > 0){
            for (int i=k;i<mid.length;i++){
                int temp = mid[i];
                int j;
                for (j=i;j>=k && temp < mid[j-k];j-=k){
                    mid[j] = mid[j-k];
                }
                mid[j] = temp;
            }
            k = k/3;
        }
        double time = (System.currentTimeMillis() - curTime)/1000;
        System.out.println("用时：" + time + " s");
        return mid;
    }
}
