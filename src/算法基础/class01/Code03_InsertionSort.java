package 算法基础.class01;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/11/24 14:52
 * 插入排序
 */
public class Code03_InsertionSort {
    public static void insertionSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        //不止一个数
        for (int i = 1; i <arr.length ; i++) {
            //0~i做到有序
            for (int j = i-1; j >=0&&arr[j]>arr[j+1]; j--) {
                swap(arr,j,j+1);
            }
        }


    }

    public static void swap(int[] arr, int L, int R) {
        int tmp = arr[L];
        arr[L] = arr[R];
        arr[R] = tmp;
    }
}
