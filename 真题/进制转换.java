/*
题目描述
给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
输入描述:
输入为一行，M(32位整数)、N(2 ≤ N ≤ 16)，以空格隔开。
输出描述:
为每个测试实例输出转换后的数，每个输出占一行。如果N大于9，则对应的数字规则参考16进制（比如，10用A表示，等等）
示例1
输入
复制
7 2
输出
复制
111
 */


// 注意判断输入数字的正负号
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int flag = 1;
        if (m < 0) {
            flag = -1;
            m = Math.abs(m);
        }
        System.out.println(helper(m, n, flag));
    }
    public static String helper(int m, int n, int flag){
        StringBuffer sb = new StringBuffer();
        while(m > 0){
            int temp = m%n;
            m /= n;
            if ( temp <= 9) {
                sb.append(temp);
            }else{
                char tempC = (char)('A'+(temp-10));
                sb.append(tempC);
            }
        }
        if (flag == -1) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}
