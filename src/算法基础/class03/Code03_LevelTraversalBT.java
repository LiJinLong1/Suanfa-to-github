package 算法基础.class03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的宽度优先遍历
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/2 20:20
 */
public class Code03_LevelTraversalBT {
    public static void level(Node head){
        if(head==null){
            return;
        }
        Queue<Node>  queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            head = queue.poll();
            System.out.println(head.value);
            if(head.left!=null){
                queue.add(head.left);
            }
            if(head.right!=null){
                queue.add(head.right);
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

        level(head);
        System.out.println("========");
    }

}
