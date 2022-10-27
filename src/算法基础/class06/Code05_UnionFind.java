package 算法基础.class06;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Code05_UnionFind {
    public static class Node<V> {
        V value;

        public Node(V v) {
            value = v;
        }
    }

    public static class UnionFind<V> {
        //所有的节点
        public HashMap<V, Node<V>> nodes;
        //每个节点的父节点
        public HashMap<Node<V>, Node<V>> parents;
        //此节点的并查集中含有的节点个数
        public HashMap<Node<V>, Integer> sizeMap;

        public UnionFind(List<V> values) {
            nodes = new HashMap<>();
            parents = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V cur : values) {
                Node<V> node = new Node<>(cur);
                nodes.put(cur, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        // 给你一个节点，请你往上到不能再往上，把代表返回
        public Node<V> findFather(Node<V> cur) {
            //将路过的节点压到栈中
            Stack<Node<V>> path = new Stack<>();
            while (cur != parents.get(cur)) {
                path.push(cur);
                cur = parents.get(cur);
            }
            while (!path.isEmpty()) {
                //将栈中所有节点的父节点修改为改并查集的顶节点
                parents.put(path.pop(), cur);
            }
            return cur;
        }

        //a,b是否在一个集合中
        public boolean isSameSet(V a, V b) {
            //如果a,b的顶节点是一个那么a,b就在一个集合中
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }

        //将a,b合并成一个集合
        public void union(V a, V b) {
            Node<V> aHead = findFather(nodes.get(a));
            Node<V> bHead = findFather(nodes.get(b));
            if (aHead != bHead) {
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                Node<V> big = aSetSize >= bSetSize ? aHead : bHead;
                Node<V> small = big == aHead ? bHead : aHead;
                parents.put(small, big);
                sizeMap.put(big, aSetSize + bSetSize);
                sizeMap.remove(small);
            }
        }

        //返回总共有多少个集合
        public int sets() {
            return sizeMap.size();
        }

    }
}
