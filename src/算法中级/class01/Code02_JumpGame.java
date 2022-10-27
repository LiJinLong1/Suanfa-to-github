package 算法中级.class01;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/22 17:21
 */
public class Code02_JumpGame {

    public static int jump(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int jump = 0;
        int cur = 0;
        int next = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cur < i) {
                jump++;
                cur = next;
            }
            next = Math.max(next, i + arr[i]);

        }
        return jump;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 2, 1, 2, 1, 5}));
    }
}
