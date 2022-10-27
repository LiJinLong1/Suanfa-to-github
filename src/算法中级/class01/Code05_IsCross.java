package 算法中级.class01;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/23 15:09
 */
public class Code05_IsCross {

    public static boolean isCross(String str1, String str2, String aim) {
        if (str1 == null || str2 == null || aim == null) {
            return false;
        }
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        char[] chaim = aim.toCharArray();
        //1.如果字符1的长度 + 字符1的长度 != aim的字符长度直接false
        if (chaim.length != ch1.length + ch2.length) {
            return false;
        }
        //2.建立二维表dp
        boolean[][] dp = new boolean[ch1.length + 1][ch2.length + 1];
        dp[0][0] = true; //初始化0位置一定为T
        //3.初始化第0行和第0列，和aim相比如果相等则为T
        for (int i = 1; i <= ch1.length; i++) {
            if (ch1[i - 1] != chaim[i - 1]) {
                break;
            }
            dp[i][0] = true;
        }
        for (int j = 1; j <= ch2.length; j++) {
            if (ch2[j - 1] != chaim[j - 1]) {
                break;
            }
            dp[0][j] = true;
        }
        //4.如果ch1[i - 1] == chaim[i + j - 1] && dp[i - 1][j]为T
        // 或者 ch2[j - 1] == chaim[i + j - 1] && dp[i][j - 1]为T
        for (int i = 1; i <= ch1.length; i++) {
            for (int j = 1; j <= ch2.length; j++) {
                if ((ch1[i - 1] == chaim[i + j - 1] && dp[i - 1][j])
                        || (ch2[j - 1] == chaim[i + j - 1] && dp[i][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[ch1.length][ch2.length]; //返回右下角的dp则为结果
    }
}
