/*
题目描述
有一条彩色宝石项链，是由很多种不同的宝石组成的，包括红宝石，蓝宝石，钻石，翡翠，珍珠等。有一天国王把项链赏赐给了一个学者，并跟他说，你可以带走这条项链，但是王后很喜欢红宝石，蓝宝石，紫水晶，翡翠和钻石这五种，我要你从项链中截取连续的一小段还给我，这一段中必须包含所有的这五种宝石，剩下的部分你可以带走。如果无法找到则一个也无法带走。请帮助学者找出如何切分项链才能够拿到最多的宝石。
输入描述:
我们用每种字符代表一种宝石，A表示红宝石，B表示蓝宝石，C代表紫水晶，D代表翡翠，E代表钻石，F代表玉石，G代表玻璃等等，我们用一个全部为大写字母的字符序列表示项链的宝石序列，注意项链是首尾相接的。每行代表一种情况。
输出描述:
输出学者能够拿到的最多的宝石数量。每行一个
示例1
输入
复制
ABCYDYE
ATTMBQECPD
输出
复制
1
3
 */

/*
考察点有两个，1.快慢指针组成滑动窗口；2.循环数组
注意，常规方法表示循环数组通常是index%length，也就是取余的方法，但这种方法往往会把自己绕晕
可以通过将原数组double的方式来表示循环数组
 */
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.nextLine();
            s += s;
            int i = 5;
            for (; i<=s.length(); i++) {
                String ss = s.substring(0, i);
                if (cheak(ss)) {
                    break;
                }
            }
            int res = s.length();
            for (int j = 1;i<=s.length(); j++) {
                if (cheak(s.substring(j, i))) {
                    res = Math.min(res, i-j);
                }else{
                    i++;
                }
            }
            System.out.println(s.length()/2 - res);
        }
    }
    public static boolean cheak(String ss){
        return ss.contains("A")&&ss.contains("B")&&ss.contains("C")&&ss.contains("D")&&ss.contains("E");
    }
}
