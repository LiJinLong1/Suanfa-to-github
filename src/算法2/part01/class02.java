package 算法2.part01;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2022/9/3 14:12
 */
public class class02 {

    public static void main(String[] args) {
        System.out.println(minLocal(new int[]{5, 2, 3, 4, 5, 6, 9}));
    }

    //二分法
    public static boolean twoPoints(int[] arr, int target) {
        if (arr == null || arr.length < 0) {
            return false;
        }
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) >> 1;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return false;
    }

    //找到有序数组中最左侧目标数字
    public static int leftSum(int[] arr, int target) {
        if (arr == null || arr.length < 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (arr[mid] == target) {
                index = mid;
                right = mid;
            } else if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }


        }
        return index;
    }

    //在一个无序数组中，找到任意一个局部最小的数
    public static int minLocal(int[] arr) {
        if (arr == null || arr.length < 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        if (arr[left] < arr[left + 1]) return arr[left];
        if (arr[right] < arr[right - 1]) return arr[right];
        while (left < right) {
            int mid = (right + left) >> 1;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) return arr[mid];
            if (arr[mid] > arr[mid - 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
