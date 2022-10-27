package 算法基础.class07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/6 20:48
 */
public class Code02_PrintAllSubsequence {
    public static List<String> subs(String s) {
        if (s == null || s == "") {
            return null;
        }
        char[] str = s.toCharArray();
        String path = "";
        List<String> ans = new ArrayList<>();
        process1(str, ans, 0, path);
        return ans;
    }

    // str 固定参数
    // 来到了str[index]字符，index是位置
    // str[0..index-1]已经走过了！之前的决定，都在path上
    // 之前的决定已经不能改变了，就是path
    // str[index....]还能决定，之前已经确定，而后面还能自由选择的话，
    // 把所有生成的子序列，放入到ans里去
    public static void process1(char[] str, List ans, int index, String path) {
        if (index == str.length) {
            ans.add(path);
            return;
        }
        // 没有要index位置的字符
        process1(str, ans, index + 1, path);
        // 要了index位置的字符
        process1(str, ans, index + 1, path + String.valueOf(str[index]));
    }

    //  去重版
    public static List<String> subsNoRepeat(String s) {
        if (s == null || s == "") {
            return null;
        }
        HashSet<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();
        String path = "";
        char[] str = s.toCharArray();
        process2(str, 0, ans, path, set);
        return ans;
    }

    private static void process2(char[] str, int index, List<String> ans, String path, HashSet<String> set) {
        if (index == str.length) {
            if (!set.contains(path)) {
                set.add(path);
                ans.add(path);

            }
            return;
        }
        process2(str, index + 1, ans, path, set);
        process2(str, index + 1, ans, path + String.valueOf(str[index]), set);
    }

    public static void main(String[] args) {
        String test = "acccc";
        List<String> ans1 = subs(test);
        List<String> ans2 = subsNoRepeat(test);

        for (String str : ans1) {
            System.out.println(str);
        }
        System.out.println("=================");
        for (String str : ans2) {
            System.out.println(str);
        }
        System.out.println("=================");

    }
}
