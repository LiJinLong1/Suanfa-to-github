package 算法中级.class03;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/24 20:13
 */
public class Code02_MoneyProblem {

    public static long func1(int[] d, int[] p) {
        return process(d, p, 0, 0);
    }

    // int[] d  d[i]:i号怪兽的武力
    // int[] p  p[i]: i号怪兽要求的钱
    // hp       当前你所具有的能力
    // index    来到了第index个怪兽的面前
    //目前，你的能力是hp，你来到了index号怪兽的面前，如果要通过后续所有的怪兽，
    // 请返回需要花的最少钱数
    public static int process(int[] d, int[] p, int hp, int index) {
        if (index == d.length) {
            return 0;
        }
        if (hp < d[index]) {
            hp += d[index];
            return p[index] + process(d, p, hp + d[index], index + 1);
        } else {
            return Math.min(process(d, p, hp, index + 1), p[index] + process(d, p, hp + d[index], index + 1));
        }
    }

    public static int dp1(int[] d, int[] p) {
        if (d == null || d.length == 0) {
            return 0;
        }

        int hp = 0;
        for (int i = 0; i < d.length; i++) {
            hp += d[i];
        }
        int dp[][] = new int[d.length + 1][hp + 1];
        for (int i = d.length - 1; i >= 0; i--) {
            for (int j = 0; j <= hp; j++) {
                if (j + d[i] > hp) {
                    continue;
                }
                if (j < d[i]) {
                    dp[i][j] = p[i] + dp[i + 1][j + d[i]];
                } else {
                    dp[i][j] = Math.min(p[i] + dp[i + 1][j + d[i]], dp[i + 1][j]);
                }
            }
        }
        return dp[0][0];
    }

    public static long func2(int[] d, int[] p) {
        int sum = 0;
        for (int num : d) {
            sum += num;
        }
        long[][] dp = new long[d.length + 1][sum + 1];
        for (int i = 0; i <= sum; i++) {
            dp[0][i] = 0;
        }
        for (int cur = d.length - 1; cur >= 0; cur--) {
            for (int hp = 0; hp <= sum; hp++) {
                // 如果这种情况发生，那么这个hp必然是递归过程中不会出现的状态
                // 既然动态规划是尝试过程的优化，尝试过程碰不到的状态，不必计算
                if (hp + d[cur] > sum) {
                    continue;
                }
                if (hp < d[cur]) {
                    dp[cur][hp] = p[cur] + dp[cur + 1][hp + d[cur]];
                } else {
                    dp[cur][hp] = Math.min(p[cur] + dp[cur + 1][hp + d[cur]], dp[cur + 1][hp]);
                }
            }
        }
        return dp[0][0];
    }

    public static long func3(int[] d, int[] p) {
        int sum = 0;
        for (int num : p) {
            sum += num;
        }
        // dp[i][j]含义：
        // 能经过0～i的怪兽，且花钱为j（花钱的严格等于j）时的武力值最大是多少？
        // 如果dp[i][j]==-1，表示经过0～i的怪兽，花钱为j是无法通过的，或者之前的钱怎么组合也得不到正好为j的钱数
        int[][] dp = new int[d.length][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = -1;
            }
        }
        // 经过0～i的怪兽，花钱数一定为p[0]，达到武力值d[0]的地步。其他第0行的状态一律是无效的
        dp[0][p[0]] = d[0];
        for (int i = 1; i < d.length; i++) {
            for (int j = 0; j <= sum; j++) {
                // 可能性一，为当前怪兽花钱
                // 存在条件：
                // j - p[i]要不越界，并且在钱数为j - p[i]时，要能通过0～i-1的怪兽，并且钱数组合是有效的。
                if (j >= p[i] && dp[i - 1][j - p[i]] != -1) {
                    dp[i][j] = dp[i - 1][j - p[i]] + d[i];
                }
                // 可能性二，不为当前怪兽花钱
                // 存在条件：
                // 0~i-1怪兽在花钱为j的情况下，能保证通过当前i位置的怪兽
                if (dp[i - 1][j] >= d[i]) {
                    // 两种可能性中，选武力值最大的
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
            }
        }
        int ans = 0;
        // dp表最后一行上，dp[N-1][j]代表：
        // 能经过0～N-1的怪兽，且花钱为j（花钱的严格等于j）时的武力值最大是多少？
        // 那么最后一行上，最左侧的不为-1的列数(j)，就是答案
        for (int j = 0; j <= sum; j++) {
            if (dp[d.length - 1][j] != -1) {
                ans = j;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(dp1(new int[]{2, 4, 5, 3}, new int[]{5, 5, 6, 7}));
    }
}
