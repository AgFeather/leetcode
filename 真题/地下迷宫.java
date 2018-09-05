/*
题目描述
小青蛙有一天不小心落入了一个地下迷宫,小青蛙希望用自己仅剩的体力值P跳出这个地下迷宫。为了让问题简单,假设这是一个n*m的格子迷宫,迷宫每个位置为0或者1,0代表这个位置有障碍物,小青蛙达到不了这个位置;1代表小青蛙可以达到的位置。小青蛙初始在(0,0)位置,地下迷宫的出口在(0,m-1)(保证这两个位置都是1,并且保证一定有起点到终点可达的路径),小青蛙在迷宫中水平移动一个单位距离需要消耗1点体力值,向上爬一个单位距离需要消耗3个单位的体力值,向下移动不消耗体力值,当小青蛙的体力值等于0的时候还没有到达出口,小青蛙将无法逃离迷宫。现在需要你帮助小青蛙计算出能否用仅剩的体力值跳出迷宫(即达到(0,m-1)位置)。
输入描述:
输入包括n+1行:
 第一行为三个整数n,m(3 <= m,n <= 10),P(1 <= P <= 100)
 接下来的n行:
 每行m个0或者1,以空格分隔
输出描述:
如果能逃离迷宫,则输出一行体力消耗最小的路径,输出格式见样例所示;如果不能逃离迷宫,则输出"Can not escape!"。 测试数据保证答案唯一
示例1
输入
复制
4 4 10 1 0 0 1 1 1 0 1 0 1 1 1 0 0 1 1
输出
复制
[0,0],[1,0],[1,1],[2,1],[2,2],[2,3],[1,3],[0,3]
 */



/*
需要复习！！！
考察递归，注意，如果直接对每个位置的上下左右都递归的话会超时，需要将当前的位置不可达，这样不会重复走到这个位置。
同时，本次递归结束后需要将该位置重新置为可到达。
 */
import java.util.*;
public class Main{
    public static String res = "";
    public static boolean flag = false;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int p = in.nextInt();
        int[][] nums = new int[n][m];
        int[][] bp = new int[n][m];
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                nums[i][j] = in.nextInt();
            }
        }
        StringBuffer sb = new StringBuffer();
        helper(nums, 0, 0, p, sb);
        if (flag) {
            System.out.println(res);
        }else{
            System.out.println("Can not escape!");
        }

    }
    public static void helper(int[][] nums, int i, int j, int p, StringBuffer path){
        if (p<0 || i<0 || j<0 || i>=nums.length || j >= nums[0].length || nums[i][j] == 0) {
            return;
        }
        nums[i][j] = 0;// 将当前位置置为不可到达，防止本次递归中，不断重复走该位置
        if ( i == 0 && j == nums[0].length-1) {
            flag = true;
            path.append("[0,"+j+"]");
            res = path.toString();
        }else{
            path.append("["+i+","+j+"],");
            String temp = path.toString();
            helper(nums, i-1, j, p-3, new StringBuffer(temp));
            helper(nums, i+1, j, p, new StringBuffer(temp));
            helper(nums, i, j-1, p-1, new StringBuffer(temp));
            helper(nums, i, j+1, p-1, new StringBuffer(temp));
        }
        nums[i][j] = 1; // 当前位置(i,j)递归结束，需要将该位置恢复成可以到达。否则之后其他路径递归到这个位置时会无法访问
    }
}
