package 算法2.part01;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2022/9/3 13:29
 */
public class class01 {

    public static void main(String[] args) {


        twoOdd(new int[]{7, 2, 2, 3, 4, 4, 3, 6});
    }

    //找到数组中出现奇数次数的数字（仅有一个）
    public static int oneOdd(int[] arr) {

        if (arr == null || arr.length < 0) {
            return 0;
        }
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        return eor;
    }

    //找到数组中出现奇数次数的数字（仅有两个）
    public static void twoOdd(int[] arr) {
        if (arr == null || arr.length < 0) {
            return;
        }
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        int eorT = eor & (~eor + 1);//提取eor的最右侧的一
        int onlyOne = 0;
        for (int cur : arr) {
            if ((eorT & cur) == 0)
                onlyOne ^= cur;
        }
        System.out.println(onlyOne + "," + (eor ^ onlyOne));
    }
}

