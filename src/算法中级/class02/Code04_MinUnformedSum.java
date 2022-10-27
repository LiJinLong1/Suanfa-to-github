package 算法中级.class02;

import java.util.Arrays;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/24 16:17
 */
public class Code04_MinUnformedSum {
    public static int unformedSum(int[] arr) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            sum += arr[i];
        }
        int n = arr.length;
        boolean[][] dp = new boolean[n][sum + 1];
        dp[0][arr[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (dp[i - 1][j] || arr[i] == j || (j - arr[i] > 0 && dp[i - 1][j - arr[i]])) {
                    dp[i][j] = true;
                }
            }
        }
        int ans = min;
        for (; ans <= sum; ans++) {
            if (!dp[n - 1][ans]) {
                return ans;
            }
        }
        return sum + 1;
    }

    //arr数组中必有一个1
    public static int unformedSumHasOne(int[] arr){
        if (arr==null||arr.length<1){
            return 0;
        }
        Arrays.sort(arr);
        int range = 1;
        for (int i = 1; i <arr.length ; i++) {
            if (arr[i]>range+1){
                return range+1;
            }
            range+=arr[i];
        }
        return range+1;
    }

    public static void main(String[] args) {
        System.out.println(unformedSum(new int[]{1,2, 3, 5}));
        System.out.println(unformedSumHasOne(new int[]{1,2, 3, 5}));

    }
}
