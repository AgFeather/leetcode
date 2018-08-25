/*
题目描述
请设计一个算法能够完成两个用字符串存储的整数进行相加操作，对非法的输入则返回error
输入描述:
输入为一行，包含两个字符串，字符串的长度在[1,100]。
输出描述:
输出为一行。合法情况输出相加结果，非法情况输出error
示例1
输入
复制
123 123
abd 123
输出
复制
246
Error
 */

java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String[] ss = in.nextLine().split(" ");
            String s1 = ss[0];
            String s2 = ss[1];
            int i = s1.length()-1, j = s2.length()-1, carry = 0;
            StringBuffer sb = new StringBuffer();
            boolean error = false;
            while(i>=0 || j>=0 ){
                if((i>=0&&(s1.charAt(i)>'9' || s1.charAt(i)<'0')) ||
                    (j>=0&&(s2.charAt(j)>'9' || s2.charAt(j)<'0'))){
                        error = true;
                        break;
                    }
                if (i>=0&&j>=0) {
                    int value = s1.charAt(i)+s2.charAt(j)-2*'0'+carry;
                    carry = 0;
                    if (value > 9) {
                        carry = value/10;
                        value %= 10;
                    }
                    sb.append(value+"");
                    i--;
                    j--;
                }else if (i>=0){
                    int value = s1.charAt(i)-'0'+carry;
                    carry = 0;
                    if (value > 9) {
                        carry = value/10;
                        value %= value;
                    }
                    sb.append(value+"");
                    i--;
                }else {
                    int value = s2.charAt(j)-'0'+carry;
                    carry = 0;
                    if (value > 9) {
                        carry = value/10;
                        value %= value;
                    }
                    sb.append(value+"");
                    j--;
                }
            }
            if (carry != 0){sb.append(carry+"");}
            if (error) {
                System.out.println("error");
            }else{
                System.out.println(sb.reverse().toString());
            }

        }
    }
}







//注意int、long均不能满足需求
import java.util.Scanner;
import java.math.BigInteger;
public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        try{
            BigInteger  n = scanner.nextBigInteger();
            BigInteger  m = scanner.nextBigInteger();
            System.out.println(m.add(n));
        }catch(Exception e)
        {
            System.out.println("error");
        }
    }
}
