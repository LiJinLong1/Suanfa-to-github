package 算法基础.class02;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/1 10:24
 */
public class Code03_SmallerEqualBigger {
    public static Node listPartition1(Node head, int pivot) {
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for (i = 0; i != nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr, pivot);
        for (i = 1; i != nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    public static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].value < pivot) {
                swap(nodeArr, index++, ++small);
            } else if (nodeArr[index].value > pivot) {
                swap(nodeArr, index, --big);
            } else {
                index++;
            }
        }
    }

    public static void swap(Node[] nodeArr, int a, int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

    public static Node listPartition2(Node head, int pivot) {
        Node sH = null; // small head
        Node sT = null; // small tail
        Node eH = null; // equal head
        Node eT = null; // equal tail
        Node mH = null; // big head
        Node mT = null; // big tail
        Node next = null; // save next node
        Node node = head;
        while (node != null) {
            next = node.next;
            node.next = null;
            if (node.value < pivot) {
                if (sH == null) {
                    sH = node;
                    sT = node;
                } else {
                    sT.next = node;
                    sT = node;
                }
            } else if (node.value == pivot) {
                if (eH == null) {
                    eH = node;
                    eT = node;
                } else {
                    eT.next = node;
                    eT = node;
                }
            } else {
                if (mH == null) {
                    mH = node;
                    mT = node;
                } else {
                    mT.next = node;
                    mT = node;
                }
            }
            node = next;
        }
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eT != null) {
            eT.next = mH;
        }
        return sH != null ? sH : (eH != null ? eH : mH);
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);

    }
}
