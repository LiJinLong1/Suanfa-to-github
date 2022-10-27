package 算法基础.class02;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/1 8:55
 */
public class Code01_LinkedListMid {
    public static Node midOrUpMidNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static Node midOrDownMidNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast.next == null ? slow : slow.next;
    }

    public static Node midOrUpMidPreNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node fast = head;
        Node slow = head;
        Node cur = null;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            cur = slow;
            slow = slow.next;
        }
        return cur;
    }

    public static Node midOrDownMidPreNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node fast = head;
        Node slow = head;
        Node cur = null;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            cur = slow;
            slow = slow.next;
        }
        return fast.next == null ? cur : slow;
    }

}

class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
        next = null;
    }
}