package 算法中级.class02;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/24 15:14
 */
public class Code02_UglyNumber {

    public static boolean isUgly(int num) {
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
    public static int uglyNumber(int n) {
        if (n < 1) {
            return -1;
        }
        int[] help = new int[n];
        help[0] = 1;
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int index = 1;
        while (index < n) {
            help[index] = Math.min(help[i2] * 2, Math.max(help[i3] * 3, help[i5] * 5));
            if (help[index] == help[i2] * 2) {
                i2++;
            } else {
                if (help[index] == help[i3] * 3) {
                    i3++;
                } else {
                    i5++;
                }
            }
            index++;
        }
        return help[n-1];
    }

    public static void main(String[] args) {
        System.out.println(uglyNumber(4567));
    }
}
