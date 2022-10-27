package 算法基础.class02;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/1 9:03
 */
public class test {
    public static void main(String[] args) {
        Node test = null;
        test = new Node(0);
        test.next = new Node(1);
        test.next.next = new Node(2);
        test.next.next.next = new Node(3);
        test.next.next.next.next = new Node(3);
        test.next.next.next.next.next = new Node(2);
        test.next.next.next.next.next.next = new Node(1);
        test.next.next.next.next.next.next.next = new Node(0);
//        test.next.next.next.next.next.next.next.next = new Node(8);
        //Node node = Code01_LinkedListMid.midOrUpMidNode(test);
//        Node node = Code01_LinkedListMid.midOrDownMidNode(test);
//        Node node = Code01_LinkedListMid.midOrUpMidPreNode(test);
//        Node node = Code01_LinkedListMid.midOrDownMidPreNode(test);
        boolean b = Code02_IsPalindromeList.isPalindrome3(test);
        System.out.println(b);
    }
}
