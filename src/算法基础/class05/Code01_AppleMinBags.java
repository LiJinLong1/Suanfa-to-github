package 算法基础.class05;

public class Code01_AppleMinBags {
    /* 小虎去买苹果，商店只提供两种类型的塑料袋，每种类型都有任意数量。
         1）能装下6个苹果的袋子
         2) 能装下8个苹果的袋子
     小虎可以自由使用两种袋子来装苹果，但是小虎有强迫症，他要求自己使用的袋子数量必须最少，且使用的每个袋子必须装满。
     给定一个正整数N，返回至少使用多少袋子。如果N无法让使用的每个袋子必须装满，返回-1*/
    public static int minBags(int apple) {
        if (apple < 0) {
            return -1;
        }
        int a8 = apple >> 3;
        int rest = apple - (a8 << 3);
        while (a8 >= 0) {
            if (rest % 6 == 0) {
                return a8 + rest / 6;
            } else {
                a8--;
                rest += 8;
            }
        }
        return -1;
    }

    public static int minBagAwesome(int apple) {
        if ((apple & 1) != 0) {
            return -1;
        }
        if (apple < 18) {
            return apple == 0 ? 0 : (apple == 6 || apple == 8) ? 1 : (apple == 12 || apple == 14 || apple == 16) ? 2 : -1;
        } else {
            return (apple - 18) / 8 + 3;
        }
    }

    public static void main(String[] args) {
        for (int apple = 1; apple < 200; apple++) {
            System.out.println(apple + " : " + minBagAwesome(apple));
        }
    }

}