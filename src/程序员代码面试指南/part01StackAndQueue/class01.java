package 程序员代码面试指南.part01StackAndQueue;

import java.util.Stack;

/**
 * @author LiJinLong
 * @version 1.0
 * 实现一个有getMain功能的栈
 * 实现一个有特殊功能的栈，在实现栈的基本功能上在实现返回栈最小元素的操作
 * @date 2022/9/1 23:46
 */
public class class01 {


}

class MyStack<I extends Number> {
    private Stack<Integer> stackDate;//栈数据
    private Stack<Integer> stackMin;//历史最小值栈

    public int pop(){
        if (stackDate.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }
        int value = stackDate.pop();
        if (value==getMin()){
            stackMin.pop();
        }
            return value;

    }
    public void push(int i){
        if (stackMin.isEmpty()){
            stackMin.push(i);
        }else if (i<getMin()){
            stackMin.push(i);
        }
        stackDate.push(i);
    }

    public int  getMin(){
        if (stackMin.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }else {
            return stackMin.peek();
        }
    }
    public MyStack() {
        stackDate = new Stack<>();
        stackMin = new Stack<>();
    }
}


