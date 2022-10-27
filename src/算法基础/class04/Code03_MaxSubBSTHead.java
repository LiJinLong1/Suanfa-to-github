package 算法基础.class04;

import java.util.ArrayList;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/3 9:20
 */
public class Code03_MaxSubBSTHead {

    public static Node maxSubBSTHead1(Node head) {
        if (head == null) {
            return null;
        }
        return process(head).maxSubBSTHead;
    }

    //子树的信息
    public static class Info {
        //最大二叉搜索树的头节点
        public Node maxSubBSTHead;
        //最大二叉搜索树的节点数
        public int maxSubBSTSize;
        //最小值
        public int min;
        //最大值
        public int max;

        public Info(Node maxSubBSTHead, int maxSubBSTSize, int min, int max) {
            this.maxSubBSTHead = maxSubBSTHead;
            this.maxSubBSTSize = maxSubBSTSize;
            this.min = min;
            this.max = max;
        }


    }

    public static Info process(Node x) {
        if (x == null) {
            return new Info(null, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int min = x.value;
        int max = x.value;
        Node maxSubBSTHead = null;
        int maxSubBSTSize = 0;

        min = Math.min(Math.min(leftInfo.min, rightInfo.min), min);

        max = Math.max(Math.max(leftInfo.max, rightInfo.max), max);

        if (leftInfo.maxSubBSTHead == x.left && rightInfo.maxSubBSTHead == x.right && leftInfo.max < x.value && rightInfo.min > x.value) {
            maxSubBSTHead = x;
            maxSubBSTSize = leftInfo.maxSubBSTSize + rightInfo.maxSubBSTSize + 1;
        } else if (rightInfo.maxSubBSTSize > leftInfo.maxSubBSTSize) {
            maxSubBSTHead = rightInfo.maxSubBSTHead;
            maxSubBSTSize = rightInfo.maxSubBSTSize;
        } else {
            maxSubBSTHead = leftInfo.maxSubBSTHead;
            maxSubBSTSize = leftInfo.maxSubBSTSize;
        }


        return new Info(maxSubBSTHead, maxSubBSTSize, min, max);
    }


    public static int getBSTSize(Node head) {
        if (head == null) {
            return 0;
        }
        ArrayList<Node> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).value <= arr.get(i - 1).value) {
                return 0;
            }
        }
        return arr.size();
    }

    public static void in(Node head, ArrayList<Node> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    public static Node maxSubBSTHead2(Node head) {
        if (head == null) {
            return null;
        }
        if (getBSTSize(head) != 0) {
            return head;
        }
        Node leftAns = maxSubBSTHead1(head.left);
        Node rightAns = maxSubBSTHead1(head.right);
        return getBSTSize(leftAns) >= getBSTSize(rightAns) ? leftAns : rightAns;
    }

    // for test
    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (maxSubBSTHead1(head) != maxSubBSTHead2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }
}
