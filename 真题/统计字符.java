/*
题目描述
给定一个英文字符串,请写一段代码找出这个字符串中首先出现三次的那个英文字符(需要区分大小写)。
输入描述:
输入数据一个字符串，包括字母,数字等。
输出描述:
输出首先出现三次的那个英文字符
示例1
输入
复制
Have you ever gone shopping and
输出
复制
e
 */


import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.nextLine();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i<s.length(); i++) {
                char temp = s.charAt(i);
                if ((temp>='a'&&temp<='z')||(temp>='A'&&temp<='Z')) {
                    int count = map.getOrDefault(temp, 0) + 1;
                    if (count == 3) {
                        System.out.println(temp);
                        break;
                    }
                    map.put(temp, count);
                }
            }
        }
    }
}
