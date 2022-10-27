package 算法基础.class02;

import java.util.HashMap;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/1 22:48
 */
public class Code04_CopyListWithRandom {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static Node copyRandomList1(Node head) {
        // key 老节点
        // value 新节点
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            // cur 老
            // map.get(cur) 新
            // 新.next ->  cur.next克隆节点找到
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static Node copyRandomList2(Node head){
        if (head==null){
            return head;
        }
        Node cur = head;
        Node next = null;
        while (cur!=null){
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node copy=null;
        while (cur!=null){
            next = cur.next.next;
            copy = cur.next;
            copy.random = cur.random==null?null:cur.random.next;
            cur = next;
        }
        Node res = head.next;
        cur = head;
        while (cur!=null){
            next = cur.next.next;
            copy = cur.next;
            cur.next = next;
            copy.next = next!=null?next.next:null;
        }
        return res;
    }

    
}
