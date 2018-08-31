/*
题目描述
给定一个正整数，编写程序计算有多少对质数的和等于输入的这个正整数，并输出结果。输入值小于1000。
如，输入为10, 程序应该输出结果为2。（共有两对质数的和为10,分别为(5,5),(3,7)）
输入描述:
输入包括一个整数n,(3 ≤ n < 1000)
输出描述:
输出对数
示例1
输入
复制
10
输出
复制
2
 */



import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int i = 2, j = n-1;
        int res = 0;
        while(i <= j){
            if (isSu(i) && isSu(j)) {
                if (i+j == n) {
                    res++;
                    i++;
                    j--;
                }else if(i+j < n){
                    i++;
                }else{
                    j--;
                }
            }else{
                if (!isSu(i)) {
                    i++;
                }
                if (!isSu(j)){
                    j--;
                }
            }
        }
        System.out.println(res);
    }
    public static boolean isSu(int n){
        double temp = Math.sqrt(n);
        for (int i = 2; i<=temp; i++) {
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }
}
