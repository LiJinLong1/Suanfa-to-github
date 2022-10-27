package 算法基础.class03;

import java.util.Stack;

public class Code02_UnRecursiveTraversalBT {

    public static void pre(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
            System.out.println(head.value);
        }
    }

    public static void in(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.value);
                head = head.right;
            }
        }
    }

    public static void pos1(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack1 = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            stack1.push(head);
            if (head.left != null) {
                stack.push(head.left);
            }
            if (head.right != null) {
                stack.push(head.right);
            }

        }
        while (!stack1.isEmpty()) {
            System.out.println(stack1.pop().value);
        }
    }

    //只使用一个栈
    public static void pos2(Node h){
        if (h==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(h);
        Node c = null;
        while (!stack.isEmpty()) {
            c = stack.peek();
            if (c.left != null && h != c.left && h != c.right) {
                stack.push(c.left);
            } else if (c.right != null && h != c.right) {
                stack.push(c.right);
            } else {
                System.out.print(stack.pop().value + " ");
                h = c;
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        pre(head);
        System.out.println("========");
        in(head);
        System.out.println("========");
        pos1(head);
        System.out.println("========");

    }

}