package 算法基础.class08;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/18 18:57
 */
public class Code02_Manacher {
    public static int manacher(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        char[] str = manacherString(s);
        int[] pArr = new int[str.length];
        int R = -1;
        int C = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < str.length; i++) {
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }

    public static char[] manacherString(String s) {
        char[] str = s.toCharArray();
        char[] res = new char[str.length * 2 + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : str[i >> 1];
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "89123321";
        System.out.println(manacher(s));
    }
}
