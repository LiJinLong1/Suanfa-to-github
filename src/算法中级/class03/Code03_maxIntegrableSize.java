package 算法中级.class03;

import java.util.HashSet;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/24 21:21
 */
public class Code03_maxIntegrableSize {
    public static int maxIntegrableSize(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int L = 0; L < arr.length; L++) {
            set.clear();
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int R = L; R < arr.length; R++) {
                if (set.contains(arr[R])) {
                    break;
                }
                set.add(arr[R]);
                max = Math.max(max, arr[R]);
                min = Math.min(min, arr[R]);
                if (max - min == R - L) {
                    res = Math.max(res, R - L + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxIntegrableSize(new int[]{1, 2, 4, 5, 6, 3, 9}));
    }

}
