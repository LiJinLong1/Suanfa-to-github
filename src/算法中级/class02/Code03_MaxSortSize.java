package 算法中级.class02;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/24 15:35
 */
public class Code03_MaxSortSize {
    public static int maxSortSize(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int right = 0;
        int maxLeft = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < maxLeft)
                right = i;
            maxLeft = Math.max(maxLeft, arr[i]);
        }
        int left = arr.length - 1;
        int minRight = arr[left];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > minRight)
                left = i;
            minRight = Math.min(minRight, arr[i]);
        }
        return left<right?right-left+1:0;
    }

    public static void main(String[] args) {
        System.out.println(maxSortSize(new int[]{1, 2,6,3,5,6,4,5, 8, 9}));
    }
}
