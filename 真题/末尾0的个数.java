/*
题目描述
输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
输入描述:
输入为一行，n(1 ≤ n ≤ 1000)
输出描述:
输出一个整数,即题目所求
示例1
输入
复制
10
输出
复制
2
 */

/*
注意：在i%5==0中，仍然需要一个循环，找出i的因子5个数。例如25=5*5，所以25可以拆出2个5，res应该+2。
 */
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = 0;
        for (int i = 1; i<=n; i++) {
            if (i%5 == 0) {
                int temp = i;
                while(temp%5 == 0){
                    res++;
                    temp /= 5;
                }
            }
        }
        System.out.println(res);
    }
}
