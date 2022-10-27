package 算法基础.class05;

public class Code03_MSumToN {
    public static boolean isMSum1(int n) {
        for (int i = 1; i <= n; i++) {
            int sum = i;
            for (int j = i + 1; j <= n; j++) {
                if (sum + j > n) {
                    break;
                }
                if (sum + j == n) {
                    return true;
                }
                sum += j;

            }
        }
        return false;
    }

    public static boolean isMsum2(int n) {
        return (n & (n - 1)) != 0;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 1000; i++) {
            System.out.println(i + " " + (isMSum1(i) == isMsum2(i)));
        }
    }
}