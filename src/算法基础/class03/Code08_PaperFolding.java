package 算法基础.class03;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/2 21:06
 */
public class Code08_PaperFolding {
    public static void printAllFolds(int n){
        process(1,n,true);
    }

    public static void process(int i,int n,boolean down){
        if (i>n){
            return;
        }
        process(i+1,n,true);
        System.out.print(down?"凹":"凸");
        process(i+1,n,false);
    }
    public static void main(String[] args) {
        int N = 4;
        printAllFolds(N);
    }
}
