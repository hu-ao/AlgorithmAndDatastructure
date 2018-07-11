package hu_1_stackandqueue;

import java.util.Stack;

public class Problem_02_TwoStacksQueue {
    /**
     * 由两个栈组成的队列
     * 题目：
     * 编写一个类，用两个栈实现队列，支持队列的基本操作（add、poll、peek）
     * 解答：栈的特点是先进后出，而队列的特点是先进先出。我们用两个栈正好能把顺序反过来实现类似队列的操作
     */
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public Problem_02_TwoStacksQueue() {
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    public void add(int pushInt) {
        stackPush.push(pushInt);
    }

    public int poll() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty!");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty!");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public static void main(String[] args) {
        Problem_02_TwoStacksQueue test = new Problem_02_TwoStacksQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }
    /**
     * 由两个栈组成的队列必须做到如下两点：
     * 1.如果stackPush要往stackPop中压入数据，那么必须一次性把stackPush中的数据全部压入。
     * 2.如果stackPop不为空，stackPush绝对不能向stackPop中压入数据。
     */
}
