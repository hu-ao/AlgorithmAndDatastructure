package hu_1_stackandqueue;

/**
 * 题目：
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 * 要求：1.pop、push、getMin操作的时间复杂度都是O（1）
 *       2.设计的栈类型可以使用现成的栈结构
 */

import java.util.Stack;

/**
 * 题解：在设计上我们使用两个栈，一个栈用来保存当前栈中的元素，其功能和一个正常的栈没有区别，这个栈记为stackData;
 * 另一个栈用于保存每一步的最小值，这个栈记为stackMin。具体的实现方式有两种：
 */
public class GetMinStack {
    //方案一
    public static class MyStack1{
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;
        public MyStack1(){
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }
        public void push(int newNum)
        {
            if (this.stackMin.isEmpty())
            {
                this.stackMin.push(newNum);
            }
            else if (newNum < this.getmin())
            {
                this.stackMin.push(newNum);
            }
            this.stackData.push(newNum);
        }

        public int pop()
        {
            if (this.stackData.isEmpty())
            {
                throw new RuntimeException("Your stack is empty.");
            }
            int value = this.stackData.pop();
            if (value == this.getmin())
            {
                this.stackMin.pop();
            }
            return value;
        }

        public int getmin()
        {
            if (this.stackMin.isEmpty())
            {
                throw new RuntimeException("Your stack is empty");
            }
            return this.stackMin.peek();
        }
    }
    public static class MyStack2{
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;
        public MyStack2(){
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }
        public void push(int newNum)
        {
            if (this.stackMin.isEmpty())
            {
                this.stackMin.push(newNum);
            }
            else if (newNum < this.getmin())
            {
                this.stackMin.push(newNum);
            }
            else
            {
                int newMin = this.stackMin.peek();
                this.stackMin.push(newMin);
            }
        }

        public int pop()
        {
            if (this.stackData.isEmpty())
            {
                throw new RuntimeException("Your stack is empty");
            }
            this.stackData.pop();
            return this.stackData.pop();
        }
        public int getmin()
        {
            if (this.stackMin.isEmpty())
            {
                throw new RuntimeException("Your stack is empty");
            }
            return this.stackMin.peek();
        }
    }
    public static void main(String[] args) {
        MyStack1 stack1 = new MyStack1();
        stack1.push(3);
        System.out.println(stack1.getmin());
        stack1.push(4);
        System.out.println(stack1.getmin());
        stack1.push(1);
        System.out.println(stack1.getmin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getmin());

        System.out.println("=============");

        MyStack1 stack2 = new MyStack1();
        stack2.push(3);
        System.out.println(stack2.getmin());
        stack2.push(4);
        System.out.println(stack2.getmin());
        stack2.push(1);
        System.out.println(stack2.getmin());
        System.out.println(stack2.pop());
        System.out.println(stack2.getmin());
    }
    /**
     * 方案一和方案二其实都是用stackMin栈保存着stackData每一步的最小值。共同点是所有操作的时间
     * 复杂度都为O（1）、空间复杂度都为O（n）。区别是：方案一种stackMin压入时稍省空间，但是弹出
     * 操作稍费时间；方案二中stackMin压入时稍费空间，但是弹出操作稍省时间
     */
}
