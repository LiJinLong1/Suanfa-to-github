package 算法基础.class06;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/4 15:52
 */
public class Code06_BFS {
    // 从node出发，进行宽度优先遍历
    public static void bfs(Node start) {
        if (start == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.add(start);
        set.add(start);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }
}
