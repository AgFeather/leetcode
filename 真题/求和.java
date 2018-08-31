/*
题目描述
输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来
输入描述:
每个测试输入包含2个整数,n和m
输出描述:
按每个组合的字典序排列输出,每行输出一种组合
示例1
输入
复制
5 5
输出
复制
1 4
2 3
5
 */


/*
需要复习！！！

考察的是DFS遍历数组
 */
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        recersive(0, n, 0, m, "");

    }
    public static void recersive(int i,int n, int tempSum, int m, String s){
        if (tempSum < m){
            tempSum += i;
            if (i != 0)
                s += i + " ";
        }
        if (tempSum > m){return;}
        if (tempSum == m) {
            System.out.println(s.substring(0, s.length()-1));
        }else{
            for (int j = i+1; j<=n; j++) {
                recersive(j, n, tempSum, m, s);
            }
        }
    }
}
