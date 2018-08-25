/*
题目描述
一只袋鼠要从河这边跳到河对岸，河很宽，但是河中间打了很多桩子，每隔一米就有一个，每个桩子上都有一个弹簧，袋鼠跳到弹簧上就可以跳的更远。每个弹簧力量不同，用一个数字代表它的力量，如果弹簧力量为5，就代表袋鼠下一跳最多能够跳5米，如果为0，就会陷进去无法继续跳跃。河流一共N米宽，袋鼠初始位置就在第一个弹簧上面，要跳到最后一个弹簧之后就算过河了，给定每个弹簧的力量，求袋鼠最少需要多少跳能够到达对岸。如果无法到达输出-1
输入描述:
输入分两行，第一行是数组长度N (1 ≤ N ≤ 10000)，第二行是每一项的值，用空格分隔。
输出描述:
输出最少的跳数，无法到达输出-1
示例1
输入
复制
5
2 0 1 1 1
输出
复制
4
 */

/*
弹簧上台阶问题，典型的动态规划问题！！！
动态规划最重要的是找到状态，以及状态转移方程。找到这两个关键点的一个方法就是
从任务结束时的状态n，倒推如何从n-1到达n。（这道题就是有多少种方法从一个木桩跳到对岸）
也就是说，跳到最终状态n的最少跳数 = 所有可以直接跳到状态n的状态的最小值+1.
所以，状态转移方程为：
table[i+j] = Math.min(table[i+j], table[i]+1);
其中i表示状态i，j表示在状态i的最大跳跃距离。
 */
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int[] nums = new int[n+1];//注意数组大小n+1，将到岸包含进去
            int[] table = new int[n+1];
            for (int i = 0;i<n ; i++) {
                nums[i] = in.nextInt();
                table[i] = 10000; // 初始化到达每个状态的最少跳数都为最大值
            }
            table[0] = 0; // 第一个位置跳数为0
            table[n] = 10000;
            for (int i = 0; i<n; i++) {
                for (int j = 1; j<=nums[i]; j++) { // 遍历状态i对应的所有可能跳跃距离
                    if (i+j > n) { // 防止数组越界
                        table[n] = Math.min(table[n], table[i]+1);
                    }else{ // 状态转移方程
                        table[i+j] = Math.min(table[i+j], table[i]+1);
                    }
                }
            }
            if (table[n] == 10000)
                System.out.println(-1);
            else
                System.out.println(table[n]);
        }
    }
}
