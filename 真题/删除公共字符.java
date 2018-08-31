/*
题目描述
输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”
输入描述:
每个测试输入包含2个字符串
输出描述:
输出删除后的字符串
示例1
输入
复制
They are students. aeiou
输出
复制
Thy r stdnts.
 */

import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] a = in.nextLine().toCharArray();
        char[] b = in.nextLine().toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i<b.length; i++) {
                set.add(b[i]);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i<a.length; i++) {
            if (!set.contains(a[i])) {
                sb.append(a[i]);
            }
        }
        System.out.println(sb.toString());
    }
}
