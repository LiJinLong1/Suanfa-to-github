package 算法基础.class02;

import java.util.Stack;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/1 9:17
 */
public class Code02_IsPalindromeList {

    public static boolean isPalindrome1(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Node> stack = new Stack<>();
        Node node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        node = head;
        while (!stack.isEmpty()) {
            if (node.value != stack.pop().value) {
                return false;
            }
            node = node.next;
        }
        return true;
    }

    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<Node>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node pre = null;
        Node curr = slow.next;
        slow.next = null;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        Node node = pre;
        Node n1 = head;
        while (n1 != null && pre != null) {
            if (n1.value != pre.value) {
                return false;
            }
            n1 = n1.next;
            pre = pre.next;
        }
        pre = null;
        curr = node;
        next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return true;
    }
}
