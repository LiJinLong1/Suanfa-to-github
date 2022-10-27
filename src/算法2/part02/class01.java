package 算法2.part02;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2022/9/3 15:18
 */
public class class01 {
    public static void main(String[] args) {
        System.out.println(getMax(new int[]{7, 2, 2, 3, 4, 4, 3, 6}));
    }


    public static int getMax(int[] arr){
        return process(arr,0,arr.length-1);
    }

    public static int process(int[] arr, int left, int right) {
        if (left==right){
            return arr[left];
        }
        int mid = left+((right-left)>>1);
        int leftMax = process(arr,left,mid);
        int rightMax = process(arr,mid+1,right);
        return Math.max(leftMax,rightMax);
    }

}
