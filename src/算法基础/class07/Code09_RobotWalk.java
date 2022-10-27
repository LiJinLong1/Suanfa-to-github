package 算法基础.class07;

public class Code09_RobotWalk {
    /**
     * @param N     排成一行的N个位置
     * @param start 当前位置
     * @param K     还剩K步
     * @param aim   终点
     * @return 机器人从cur出发，走过rest步之后，最终停在P的方法数，是多少？
     */
    public static int walk1(int N, int start, int K, int aim) {
        // 机器人当前来到的位置是cur，
        // 机器人还有rest步需要去走，
        // 最终的目标是P，
        // 有哪些位置？1~N
        // 返回：机器人从cur出发，走过rest步之后，最终停在P的方法数，是多少？
        if (N < 2 || start < 1 || start > N || K < 1 || aim < 1 || aim > N) {
            return 0;
        }
        return process1(N, start, K, aim);
    }

    private static int process1(int N, int cur, int rest, int aim) {
        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }
        if (cur == 1) {
            return process1(N, cur + 1, rest - 1, aim);
        } else if (cur == N) {
            return process1(N, cur - 1, rest - 1, aim);
        } else {
            return process1(N, cur + 1, rest - 1, aim) + process1(N, cur - 1, rest - 1, aim);
        }

    }

    public static int walk2(int N, int start, int K, int aim) {
        if (N < 2 || start < 1 || start > N || K < 1 || aim < 1 || aim > N) {
            return 0;
        }
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(N, start, K, aim, dp);
    }

    private static int process2(int N, int cur, int rest, int aim, int[][] dp) {
        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        if (rest == 0) {
            dp[cur][rest] = cur == aim ? 1 : 0;
            return dp[cur][rest];
        }
        if (cur == 1) {
            dp[cur][rest] = process1(N, cur + 1, rest - 1, aim);
            return dp[cur][rest];
        } else if (cur == N) {
            dp[cur][rest] = process1(N, cur - 1, rest - 1, aim);
            return dp[cur][rest];
        } else {
            dp[cur][rest] = process1(N, cur + 1, rest - 1, aim) + process1(N, cur - 1, rest - 1, aim);
            return dp[cur][rest];
        }
    }

    public static int walk3(int N, int start, int K, int aim) {
        if (N < 2 || start < 1 || start > N || K < 1 || aim < 1 || aim > N) {
            return 0;
        }
        int[][] dp = new int[N + 1][K + 1];
        dp[aim][0] = 1;
        for (int rest = 1; rest <= K; rest++) {
            dp[1][rest] = dp[2][rest - 1];
            for (int cur = 2; cur < N; cur++) {
                dp[cur][rest] = dp[cur + 1][rest - 1] + dp[cur - 1][rest - 1];
            }
            dp[N][rest] = dp[N - 1][rest - 1];
        }
        return dp[start][K];
    }

    public static void main(String[] args) {
        System.out.println(walk1(5, 2, 4, 4));
        System.out.println(walk2(5, 2, 4, 4));
        System.out.println(walk3(5, 2, 4, 4));
    }
}