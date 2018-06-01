/*
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */


import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        int temp=0;
        while(!stack1.isEmpty()){
            temp = stack1.pop();
            if (stack1.isEmpty())
                break;
            stack2.push(temp);
        }
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return temp;
    }
}
