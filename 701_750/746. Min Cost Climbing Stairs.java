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

//使用递归方式判断，结果虽然对，但是复杂度非常大，当数据输入稍微大写时，即无法运行。
class Solution {
    public int minCostClimbingStairs(int[] cost){
		int x = recursiveClimbing(cost,0);
		int y = recursiveClimbing(cost,1);
		return x>y?y:x;
	}

	public int recursiveClimbing(int[] cost, int i){
		if (i>=cost.length) {
			return 0;
		}
		int x = recursiveClimbing(cost,i+1);
		int y = recursiveClimbing(cost,i+2);
		return cost[i]+(x>y?y:x);
	}
}
