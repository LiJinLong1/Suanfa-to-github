package 算法中级.class03;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/24 19:16
 */
public class Code01_LargestComponentSize {

    public static class Node<Integer> {
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class UnionFind {

        public HashMap<Integer, Node<Integer>> nodes;
        public HashMap<Node<Integer>, Node<Integer>> parents;
        public HashMap<Node<Integer>, Integer> sizeMap;

        public UnionFind(int[] arr) {
            this.nodes = new HashMap<>();
            this.parents = new HashMap<>();
            this.sizeMap = new HashMap<>();
            for (Integer i : arr) {
                Node node = new Node(i);
                nodes.put(i, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public Node<Integer> findFather(Node cur) {
            Stack<Node> stack = new Stack<>();
            while (cur != parents.get(cur)) {
                stack.push(cur);
                cur = parents.get(cur);
            }
            while (!stack.isEmpty()) {
                parents.put(stack.pop(), cur);
            }
            return cur;
        }

        public boolean isSameSet(int a, int b) {
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }

        public void union(int a, int b) {
            if (isSameSet(a, b)) {
                return;
            }
            Node<Integer> aHead = findFather(nodes.get(a));
            Node<Integer> bHead = findFather(nodes.get(b));
            int aSetSize = sizeMap.get(aHead);
            int bSetSize = sizeMap.get(bHead);
            Node<Integer> bigNode = aSetSize > bSetSize ? aHead : bHead;
            Node<Integer> smallNode = bigNode == aHead ? bHead : aHead;
            parents.put(smallNode, bigNode);
            sizeMap.put(bigNode, aSetSize + bSetSize);
            sizeMap.remove(smallNode);
        }

        public int sets() {
            return sizeMap.size();
        }
    }

    public static int largestComponentSize(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        UnionFind unionFind = new UnionFind(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int a = arr[i];
                int b = arr[j];
                if (gcd(a, b) > 1) {
                    unionFind.union(a, b);
                }
            }
        }
        return unionFind.sets();
    }

    public static int maxComponentNum(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        UnionFind unionFind = new UnionFind(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int a = arr[i];
                int b = arr[j];
                if (gcd(a, b) > 1) {
                    unionFind.union(a, b);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (Integer i : unionFind.sizeMap.values()) {
            res = Math.max(res, i);
        }
        return res;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 15, 6, 7};
        System.out.println(largestComponentSize(arr));
        System.out.println(maxComponentNum(arr));
    }
}
