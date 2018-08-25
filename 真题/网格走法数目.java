/*
题目描述
有一个X*Y的网格，小团要在此网格上从左上角到右下角，只能走格点且只能向右或向下走。请设计一个算法，计算小团有多少种走法。给定两个正整数int x,int y，请返回小团的走法数目。
输入描述:
输入包括一行，逗号隔开的两个正整数x和y，取值范围[1,10]。
输出描述:
输出包括一行，为走法的数目。
示例1
输入
复制
3 2
输出
复制
10
 */

/*
典型的递归算法问题，因为每次走法必须是往右或者是往下，因此不管是到达那个点，
它的必经之路一定是它上方或者左方相邻的那个点，
因此可以得出一个递归表达式：f[m][n]=f[m-1][n]+f[m][n-1]；
这个递归表达式的条件为m,n都不为0的时候，除了这个表达式还需要写出一个已知条件，
f[0][0] = 0;f[{1->m}][0] = 1;f[0][{1->n}] = 1;这样就可以解出最终f[m][n]的值了
 */
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int m = in.nextInt();
            int n = in.nextInt();
            System.out.println(helper(m,n));
        }
    }
    public static int helper(int m, int n){
        if (m == 0|| n == 0) {
            return 1;
        }
        return helper(m-1, n) + helper(m, n-1);
    }
}




public class Main {

    //网格走法数目
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int m,n;
        m = in.nextInt();
        n = in.nextInt();
        int f[][] = new int[11][11];
        f[0][0] = 0;
        for(int i=0; i<=m; i++)
            f[i][0] = 1;
        for(int i=0; i<=n; i++)
            f[0][i] = 1;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++)
                f[i][j] = f[i-1][j] + f[i][j-1];
        }
        System.out.print(f[m][n]);
    }
}
