/*
On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 */


/*
对动态规划思想的简单考察：遍历所有台阶，走到当前台阶的cost为当前台阶前两个台阶cost的最小值+当前cost。
最开始想到申请cost.length长的数组存放所有走到每个台阶的cost值。后来发现之前记录的值已经没有意义
所以只需要申请一个长度为2的数组，表示当前台阶的前两个台阶的cost值，并不断更新这个数组即可。

注意最后返回的值为min(tempCost[0], tempCost[1])，因为输入的cost并不包含终点台阶（终点台阶的cost为0）
 */

 public int minCostClimbingStairs(int[] cost){
     int[] tempCost = new int[2];
     tempCost[0] = cost[0]; tempCost[1] = cost[1];
     for (int i = 2; i<cost.length; i++) {
         int tempVal = Math.min(tempCost[0], tempCost[1]) + cost[i];
         tempCost[0] = tempCost[1];
         tempCost[1] = tempVal;
     }
     return Math.min(tempCost[0], tempCost[1]);
 }
