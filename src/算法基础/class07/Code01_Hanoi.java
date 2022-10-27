package 算法基础.class07;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/4 19:52
 */
public class Code01_Hanoi {
    public static void hanoi(int n) {
        if (n <= 0) {
            return;
        }
        func(n, "left", "right", "mid");
    }

    private static void func(int n, String from, String to, String other) {
        if (n == 1) {
            System.out.println("Move 1 from " + from + " to " + to);
        }else {
            func(n - 1, from, other, to);
            System.out.println("Move " + n + " from " + from + " to " + to);
            func(n - 1, other, to, from);
        }

    }

    public static void main(String[] args) {
        hanoi(8);
    }
}
