package 算法基础.class05;

public class Code02_EatGrass {
    /* 给定一个正整数N,表示有N份青草统一堆放在仓库里有一只牛和一只羊，
    牛先吃，羊后吃，它俩轮流吃草不管是牛还是羊，
    每一轮能吃的草量必须是:1，4，16, 64…(4的某次方)
     谁最先把草吃完，谁获胜
     假设牛和羊都绝顶聪明，都想赢，都会做出理性的决定根据唯一的参数N，返回谁会赢*/
    // 如果n份草，最终先手赢，返回"先手"
    // 如果n份草，最终后手赢，返回"后手"
    public static String whoWin(int n) {
        if (n < 5) {
            return n == 0 || n == 2 ? "后手" : "先手";
        }
        int base = 1;
        while (base <= n) {
            if (whoWin(n - base).equals("后手")) {
                return "先手";
            }
            if (base > n / 4) {
                break;
            }
            base <<= 2;
        }
        return "后手";
    }

    public static String winner(int n) {
        return n % 5 == 0 || n % 5 == 2 ? "后手" : "先手";
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 50; i++) {
            System.out.println(i + " : " + whoWin(i).equals(winner(i)));
        }
    }

}