/*

首先理解题目意思：
5  2  1  4  3  7这样的输入
除了最自然的6个以外，还有
2（1）4
5 （2 1）4
4 （3）7
共9对
此题可以理解为在两个山峰之间的山峰都比两端低时，两端山峰就是一对，现在就是求有多少对？
 */



/*
需要复习！！
 */
// 动态规划思路，超时，超内存
链接：https://www.nowcoder.com/questionTerminal/e1967ae812ea42e7a3ce57ee1f83b686
来源：牛客网

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        boolean[][] dp = new boolean[n][n];
        int res = n;
        //任意一点与和它相距gap距离的点比较。
        for(int gap = 2;gap<n-1;gap++)
            for(int i=0;i<n;i++){
                if(!dp[i][(i+gap)%n]&&!dp[(i+gap)%n][i]){
                    int k = gap-1;
                    boolean b = true;
                    while(k>0){
                        if(!(arr[(i+k)%n]<=arr[(i+gap)%n]&&arr[(i+k)%n]<=arr[i]))
                            b = false;
                        k--;
                    }
                    if(b){
                        dp[i][(i+gap)%n] = true;
                        dp[(i+gap)%n][i] = true;
                        res++;
                    }
                }
            }
            System.out.println(res);
    }
}


/*
单调栈思路：
找出一个数左右最近的大于他的数，可以用单调栈实现。我们设定单调栈中，从栈顶到栈底依次变大。

假设有数 5  2  1  4  3  7

先放5；2小于5，放2；1小于2，放1；4大于1，则1弹出，1的弹出是由于4，所以4是1右边临近的大于他的数，
2在1下面，所以2是1左面临近大于他的数。相同原理2弹出，4进，3进，7进时同理弹出3,4,5

左      右

1    2        4

2    5        4

3    4        7

4    5        7

5    null    7

7    null   null

总对数=4*2+1。此算法复杂度可以达到O（n），遍历算法O(n^2)


以上算法只适用于，山峰高度都各不相等的情况下，若有相等则：一次遍历将相邻相等山峰合并，二次遍历找最大值开始压栈
 */




 链接：https://www.nowcoder.com/questionTerminal/e1967ae812ea42e7a3ce57ee1f83b686
 来源：牛客网

 import java.util.ArrayList;
 import java.util.List;
 import java.util.Scanner;

 public class Main {
     public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
         int n = scan.nextInt();
         int a[] = new int[n*2];
         for (int i = 0; i < n; i++) {
             a[i] = scan.nextInt();
             a[i+n]= a[i];
         }
         int maxIndex=0,secondIndex=0;
         for(int i=1;i<n;i++){
             if(a[maxIndex]<a[i])maxIndex = i;
         }
         if(maxIndex==0)secondIndex = 1;
         for(int i=1;i<n;i++){
             if(i==maxIndex)continue;
             if(a[secondIndex]<a[i])secondIndex = i;
         }
         int start = maxIndex>secondIndex?secondIndex:maxIndex;
         int mid = maxIndex>secondIndex?maxIndex:secondIndex;
         int end = start+n;
         System.out.println(getCount(a,start,mid)+getCount(a,mid,end)+1);
     }
     static long getCount(int a[],int start,int end){
         if(end-start==1)return 0;
         List<Integer> list = getMaxIndexExceptStartAndEnd(a,start,end);
         long c = (int)list.size();
         int f = list.get(0);
         int l = list.get(list.size()-1);
         long r1 = getCount(a,start,f)+c;
         long r2 = getCount(a,l,end)+c;
         long sum1= c*(c-1)/2;
         for(int i=1;i<list.size();i++){
             sum1 += getCount(a,list.get(i-1),list.get(i));
         }
         return r1+r2+sum1;
     }

     static List<Integer> getMaxIndexExceptStartAndEnd(int []a,int start,int end){
         List<Integer> list = new ArrayList<Integer>();
         int max = start+1;
         list.add(max);
         for(int i=start+2;i<end;i++){
             if(a[max]<a[i]){
                 list.clear();
                 list.add(i);
                 max = i;
             }else if(a[max]==a[i]){
                 list.add(i);
             }
         }
         return list;
     }
 }
