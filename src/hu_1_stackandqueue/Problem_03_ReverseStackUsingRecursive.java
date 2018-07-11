package hu_1_stackandqueue;

import java.util.Stack;

/**
 * 如何仅适用递归函数和栈操作逆序一个栈
 * 题目：
 * 一个栈一次压入1、2、3、4、5，那么从栈顶到栈底分别为5、4、3、2、1。将这个栈转置后，从栈顶到栈底为
 * 1、2、3、4、5，也就是实现栈中元素的逆序，但是只能用递归函数来实现，不能用其他数据结构。
 */
public class Problem_03_ReverseStackUsingRecursive {
    public static int getAndRemoveLastElement(Stack<Integer> stack)
    {
        int result = stack.pop();
        if (stack.isEmpty())
        {
            return result;
        }
        else
        {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }
    public static void reverse(Stack<Integer> stack)
    {
        if (stack.isEmpty())
        {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        reverse(test);
        while (!test.isEmpty())
        {
            System.out.println(test.pop());
        }
    }
}
