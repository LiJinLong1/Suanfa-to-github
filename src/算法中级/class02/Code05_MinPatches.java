package 算法中级.class02;



/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/24 16:49
 */
public class Code05_MinPatches {
    public static int minPatches(int[] arr,int range){
        int patches = 0;
        int touch = 0;
        for (int i = 0; i <arr.length ; i++) {
            while (arr[i]>touch+1){
                touch+=touch+1;
                patches++;
                if (touch>=range){
                    return patches;
                }
            }
            touch+=arr[i];
            if (touch>=range){
                return patches;
            }
        }
        while (touch<range){
            touch+=touch+1;
            patches++;
        }
        return patches;
    }

    public static void main(String[] args) {
        System.out.println(minPatches(new int[]{1,5,7},15));
    }
}
