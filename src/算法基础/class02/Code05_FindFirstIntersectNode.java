package 算法基础.class02;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/1 23:09
 */
public class Code05_FindFirstIntersectNode {

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    // 找到链表第一个入环节点，如果无环，返回null
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node fast = head.next;
        Node slow = head.next.next;
        while (fast.next != null && fast.next.next != null && fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next == null || fast.next.next == null) {
            return null;
        }
        fast = head;
        while (fast != null && slow != null && fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head1 == null) {
            return null;
        }
        int size = 0;
        Node cur1 = head1;
        Node cur2 = head2;
        while (cur1 != null) {
            cur1 = cur1.next;
            size++;
        }
        while (cur2 != null) {
            cur2 = cur2.next;
            size--;
        }
        if (cur1 != cur2) {
            return null;
        }
        cur1 = head1;
        cur2 = head2;
        while (size < 0) {
            cur2 = cur2.next;
        }
        while (size > 0) {
            cur1 = cur1.next;
            size--;
        }
        cur1 = head1;
        cur2 = head2;
        while (cur1 != null && cur2 != null && cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    // 两个有环链表，返回第一个相交节点，如果不想交返回null
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }

}
