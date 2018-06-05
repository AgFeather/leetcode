/*
包含min函数的栈

题目描述
定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */


import java.util.*;

public class Solution {
    private ArrayList<Integer> array = null;
    private int min = 0;
    private int index = -1;
    public Solution(){
        array = new ArrayList<Integer>();
    }

    public void push(int node) {
        if (array.size() == 0) {
            min = node;
        }
        min = min<node?min:node;
        array.add(node);
        index++;
    }

    public void pop() {
        int tempValue = array.get(index);
        index--;
        if (min == tempValue) {
            min = top();
            for (int i = 0; i<=index; i++) {
                min = min<array.get(i)?min:array.get(i);
            }
        }
    }

    public int top() {
        return array.get(index);
    }

    public int min() {
        return min;
    }
}
