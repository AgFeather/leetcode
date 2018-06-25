/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */


/*
和之前的包含cost的爬楼梯一样，考察简单的动态规划思想。对于第i个台阶，他的走法为第i-1个台阶的走法
加上第i-2个走法的和。(从第i-1个台阶迈一步+从第i-2个台阶迈两步)
 */
 public int climbStairs(int n){
     if (n == 1)
         return 1;
     int[] tempCost = new int[2];
     tempCost[0] = 1;
     tempCost[1] = 2;
     for (int i = 2; i<n;i++ ) {
         int temp = tempCost[0] + tempCost[1];
         tempCost[0] = tempCost[1];
         tempCost[1] = temp;
     }
     return tempCost[1];
 }
