package 算法基础.class07;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/6 21:08
 */
public class Code03_PrintAllPermutations {
    public static List<String> permutation1(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        char[] str = s.toCharArray();
        List<String> ans = new ArrayList<>();
        ArrayList<Character> rest = new ArrayList<>();
        String path = "";
        process1(str, ans, rest, path);
        return ans;
    }

    private static void process1(char[] str, List<String> ans, ArrayList<Character> rest, String path) {
        if (rest.isEmpty()) {
            ans.add(path);
            return;
        }
        int n = rest.size();
        for (int i = 0; i < n; i++) {
            char cur = rest.get(i);
            rest.remove(i);
            process1(str, ans, rest, path + cur);
        }
    }

    public static List<String> permutation2(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        char[] str = s.toCharArray();
        String path = "";
        process2(str, ans, 0);
        return ans;
    }

    public static void process2(char[] str, List<String> ans, int index) {
        if (index == str.length) {
            ans.add(String.valueOf(str));
        } else {
            for (int i = 0; i < str.length; i++) {
                swap(str, index, i);
                process2(str, ans, index + 1);
                swap(str, index, i);
            }
        }

    }

    public static List<String> permutation3(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        char[] str = s.toCharArray();
        process3(str, 0, ans);
        return ans;
    }

    private static void process3(char[] str, int index, List<String> ans) {
        if (index == str.length) {
            ans.add(String.valueOf(str));
        } else {
            boolean[] visited = new boolean[256];
            for (int i = 0; i < str.length; i++) {
                if (!visited[str[i]]) {
                    visited[str[i]] = true;
                    swap(str, index, i);
                    process3(str, index + 1, ans);
                    swap(str, index, i);
                }
            }
        }


    }

    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    public static void main(String[] args) {
        String s = "acc";
        List<String> ans1 = permutation1(s);
        for (String str : ans1) {
            System.out.println(str);
        }
        System.out.println("=======");
        List<String> ans2 = permutation2(s);
        for (String str : ans2) {
            System.out.println(str);
        }
        System.out.println("=======");
        List<String> ans3 = permutation3(s);
        for (String str : ans3) {
            System.out.println(str);
        }
    }
}
