package 算法中级.class01;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/23 11:23
 */
public class Code03_TopKSumCrossTwoArrays {
    public static class Node {
        public int index1;
        public int index2;
        public int sum;

        public Node() {
        }

        public Node(int index1, int index2, int sum) {
            this.index1 = index1;
            this.index2 = index2;
            this.sum = sum;
        }
    }

    public static class MaxHeadComp implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.sum - o1.sum;
        }
    }

    public static int[] topKSum(int[] arr1, int[] arr2, int topK) {
        if (arr1 == null || arr2 == null || topK < 1) {
            return null;
        }
        topK = Math.min(topK, arr1.length * arr2.length);
        int[] res = new int[topK];
        int resIndex = 0;

        PriorityQueue<Node> maxHead = new PriorityQueue<>(new MaxHeadComp());

        boolean[][] set = new boolean[arr1.length][arr2.length];
        int i1 = arr1.length - 1;
        int i2 = arr2.length - 1;
        maxHead.add(new Node(i1, i2, arr1[i1] + arr2[i2]));
        set[i1][i2] = true;
        while (resIndex != topK) {
            Node node = maxHead.poll();
            res[resIndex++] = node.sum;
            i1 = node.index1;
            i2 = node.index2;
            if (i1 - 1 > 0 && !set[i1 - 1][i2]) {
                set[i1 - 1][i2] = true;
                maxHead.add(new Node(i1 - 1, i2, arr1[i1 - 1] + arr2[i2]));
            }
            if (i2 - 1 > 0 && !set[i1][i2 - 1]) {
                set[i1][i2 - 1] = true;
                maxHead.add(new Node(i1, i2 - 1, arr1[i1] + arr2[i2 - 1]));
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = topKSum(new int[]{1, 3, 5, 6}, new int[]{1, 3, 5, 6}, 3);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
