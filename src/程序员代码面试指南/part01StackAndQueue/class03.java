package 程序员代码面试指南.part01StackAndQueue;

import java.util.Stack;

/**
 * @description:使用递归函数逆序栈
 * @author: LiJinLong
 * @createDate: 2022/10/10
 * @version: 1.0
 */
public class class03 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(4);
        stack.add(6);
        stack.add(23);
        stack.add(7);
        reverse(stack);
        System.out.println(stack);

    }
    //将返回的栈底元素压入占中
    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int i =   getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    //移除并返回当前栈底元素
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }

    }
}
