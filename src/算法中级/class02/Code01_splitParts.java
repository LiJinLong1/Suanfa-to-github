package 算法中级.class02;

import java.util.HashMap;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/23 16:46
 */
public class Code01_splitParts {
    public static boolean canSplits(int[] arr) {
        if (arr == null || arr.length < 7) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            map.put(sum, i);
            sum += arr[i];
        }
        int lSum = arr[0];
        for (int s1 = 1; s1 < arr.length - 5; s1++) {
            int checkSum = lSum * 2 + arr[s1];
            if (map.containsKey(checkSum)) {
                int s2 = map.get(checkSum);
                checkSum += lSum + arr[s2];
                if (map.containsKey(checkSum)) {
                    int s3 = map.get(checkSum);
                    if (checkSum + lSum + arr[s3] == sum) {
                        return true;
                    }
                }
            }
            lSum += arr[s1];
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canSplits(new int[]{3, 3, 5, 6, 9, 2, 4, 7, 5, 1}));
    }
}
