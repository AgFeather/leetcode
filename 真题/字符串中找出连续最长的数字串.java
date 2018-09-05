/*
题目描述
读入一个字符串str，输出字符串str中的连续最长的数字串
输入描述:
个测试输入包含1个测试用例，一个字符串str，长度不超过255。
输出描述:
在一行内输出str中里连续最长的数字串。
示例1
输入
复制
abcd12345ed125ss123456789
输出
复制
123456789
 */

/*
移动两个指针，不断记录数字串的begin和end，并找到最长的长度。
 */
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int tempBegin = findStrBegin(s, 0);
        int tempEnd = findStrEnd(s, tempBegin);
        int begin = tempBegin, end = tempEnd;
        int maxLen = end - begin;
        for (int i = end; i<s.length();) {
            tempBegin = findStrBegin(s, tempEnd);
            tempEnd = findStrEnd(s, tempBegin);
            if (tempEnd - tempBegin > maxLen) {
                maxLen = tempEnd - tempBegin;
                end = tempEnd;
                begin = tempBegin;
            }
            i = tempEnd;
        }
        System.out.println(s.substring(begin, end));
    }
    public static int findStrEnd(String s, int index){
        for (int i = index; i<s.length(); i++) {
            if (s.charAt(i)>'9' || s.charAt(i)<'0') {
                return i;
            }
        }
        return s.length();
    }
    public static int findStrBegin(String s, int index){
        for (int i = index; i<s.length(); i++) {
            if (s.charAt(i)<='9' && s.charAt(i)>='0') {
                return i;
            }
        }
        return s.length();
    }
}
