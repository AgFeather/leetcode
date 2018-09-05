/*
题目描述
给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
输入描述:
输入为两行:
 第一行为两个正整数n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000)
 第二行为n个正整数A[i](32位整数)，以空格隔开。
输出描述:
输出所求的方案数
示例1
输入
复制
5 15 5 5 10 2 3
输出
复制
4
 */

/*
需要复习！！！！
典型的动态规划问题，bp[i][j]表示考虑第i个数时，总和为j的个数。动态转移方程如下：
bp[i][j] = bp[i-1][j] + bp[i-1][j-nums[i]]
也就是说，考虑当前第i个数，sum为j时的个数为：第i-1个数时和为j的个数 + 第i-1个数时和为j-nums[i]的个数

注意bp需要使用long型，否则无法全部通过
 */
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] nums = new int[n];
        long[][] bp = new long[n+1][1001];
        for (int i = 0; i<n; i++) {
            int temp = in.nextInt();
            nums[i] = temp;
            bp[i+1][temp] = 1L;
        }
        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=m; j++) {
                if (j >= nums[i-1]) {
                    bp[i][j] += bp[i-1][j-nums[i-1]] + bp[i-1][j];
                }else{
                    bp[i][j] = bp[i-1][j];
                }
            }
        }
        System.out.println(bp[n][m]);
    }
}
