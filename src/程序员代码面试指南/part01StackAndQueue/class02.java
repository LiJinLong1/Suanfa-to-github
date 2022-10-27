package 程序员代码面试指南.part01StackAndQueue;

import java.util.Stack;

/**
 * @author LiJinLong
 * @version 1.0
 * 两个栈形成的队列
 * @date 2022/9/3 12:43
 */
public class class02 {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();

        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        myQueue.poll();
        System.out.println(myQueue.peek());
    }

}

class MyQueue<V> {
    private Stack<V> stackPush;
    private Stack<V> stackPop;

    public MyQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void add(V v) {
        stackPush.add(v);
    }

    //将队列中的头元素弹出
    public V poll(){
        if (stackPush.isEmpty()&&stackPop.isEmpty()){
            throw new RuntimeException("Queue is empty!");
        }else if(stackPop.isEmpty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }


    //将队列中的头元素返回
    public V peek(){
        if (stackPush.isEmpty()&&stackPop.isEmpty()){
            return null;
        }else if(stackPop.isEmpty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

}
