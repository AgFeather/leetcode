/*
题目描述
输入n个整数，输出出现次数大于等于数组长度一半的数。
输入描述:
每个测试输入包含 n个空格分割的n个整数，n不超过100，其中有一个整数出现次数大于等于n/2。
输出描述:
输出出现次数大于等于n/2的数。
示例1
输入
复制
3 9 3 2 5 6 7 3 2 3 3 3
输出
复制
3
 */

import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        while(in.hasNext()){
            count++;
            int temp = in.nextInt();
            map.put(temp, map.getOrDefault(temp, 0)+1);
        }
        for (Integer i : map.keySet()) {
            if (map.get(i) >= count/2) {
                System.out.println(i);
                break;
            }
        }
    }
}
