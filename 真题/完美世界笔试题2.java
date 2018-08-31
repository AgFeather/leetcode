
/*
黄金圣斗士欧洛斯要去圣域救雅典娜，需要从左上角出发，每次只能向右或向下走，最后达到右下角见到雅典娜。地图每个位置的值代表圣斗士要遭遇的事情，如果是负数，说明此处有阻击，要让圣斗士损失血量，如果是非负数，代表此处有血瓶，能让圣斗士回血，圣斗士从左上角走到右下角的过程中，走到任何一个位置时，血量都不能少于1，为了保证圣斗士能救出雅典娜，初始血量至少是多少？地图为一个二维数组map，如下矩阵。根据map,返回初始血量。



输入
一个n*m的二维数组

第一行：数组的行数n(n>0)

第二行：数组的列数m(m>0)

第三行：数组，每个位置的血量，行优先

输出
对于每个测试实例，要求输出初始血量


样例输入
3
3
-2 -3 3
-5 10 1
0 30 -5

样例输出
6
 */

/*
一道典型的动态规划问题，和普通的dp问题相比，有两个特点：
1. 二维空间探索
2. 反向dp

思路如下：
1. 对于任意一个位置(i，j)。当前所需要的最少血量，等于位置(i+1, j)和位置(i, j+1)所需血量的最小值
2. 而如果在当前位置可以获得的血量大于下一步所需要血量的最小值，那么到达当前步骤所需的血量为1（因为
到达这个位置会补血，而补充的血量足以支持下一步动作）.
3. 从最后一个位置向前进行状态转移
 */
import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner reader = new Scanner(System.in);
		int x = reader.nextInt();
		int y = reader.nextInt();
		int[][] array = new int[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				array[i][j] = reader.nextInt();
			}
		}
		System.out.println(minHP(array));
	}
	public static int minHP(int[][] m) {
        int x = m.length;
        int y = m[0].length;
        int[][] table = new int[x][y];
        //table[x-1][y-1] = Math.max(1-m[x-1][y-1], 1);
        for (int i = x-1; i>=0; i--) {
            for (int j = y-1; j>=0; j--) {
                if(i+1==x && j+1==y){ // 地图的终点，初始化bp表的第一个值
                	continue;
                    table[i-1][j-1] = Math.max(1-m[i-1][j-1], 1);
                }
                if (i+1==x) { // 地图的下边缘，
                    if (m[i][j] >= table[i][j+1]) {
                        table[i][j] = 1;
                    }else{
                        table[i][j] = table[i][j+1] - m[i][j];
                    }
                }else if (j+1==y) { // 地图的右边缘
                    if (m[i][j] >= table[i+1][j]) {
                        table[i][j] = 1;
                    }else{
                        table[i][j] = table[i+1][j] - m[i][j];
                    }
                }else{ // 该位置的值按照状态转移方程计算
                    int temp = Math.min(table[i+1][j], table[i][j+1]);
                    if (m[i][j] >= temp) {
                        table[i][j] = 1;
                    }else{
                        table[i][j] = temp-m[i][j];
                    }
                }
            }
        }
        return table[0][0];
    }
}
