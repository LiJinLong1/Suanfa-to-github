package 算法中级.class04;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/25 13:53
 */
public class Code01_MinAddChars {
    public static int minAddChars(String s) {
        if (s == null || s == "") {
            return 0;
        }
        char[] str = s.toCharArray();
        int[] next = getNextArray(str);
        for (int i = 0; i < next.length; i++) {
            System.out.println(next[i]);
        }
        return str.length - next[str.length];

    }

    public static int[] getNextArray(char[] str) {
        if (str.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[str.length + 1];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < next.length) {
            if (str[i - 1] == str[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(minAddChars("12"));
    }
}
