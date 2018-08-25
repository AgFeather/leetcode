/*
题目描述
给你六种面额1、5、10、20、50、100元的纸币，假设每种币值的数量都足够多，编写程序求组成N元（N为0-10000的非负整数）的不同组合的个数。
输入描述:
输入为一个数字N，即需要拼凑的面额
输出描述:
输出也是一个数字，为组成N的组合个数。
示例1
输入
复制
5
输出
复制
2
 */



/*
动态规划求解，注意状态转移方程，因为这是一种组合问题，而不是排列问题，
所以在更新时不需要考虑新加入的面值可以有多少种拆分方法
注意种类过多，需要用long保存
*/
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            int money = in.nextInt();
            long[] table = new long[money+1];
            int[] coins = {1,5,10,20,50,100};
            table[0] = 1;
            for (int i =0; i<coins.length; i++) {
                for (int j = 1; j<=money; j++) {
                    if (j >= coins[i]) {
                        table[j] += table[j-coins[i]]; // 因为是无序的，所以这里不需要考虑新加入的coin[i]的排列种类问题
                    }
                }
            }
            System.out.println(table[money]);
        }
    }
}
