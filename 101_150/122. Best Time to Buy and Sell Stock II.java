/*
Say you have an array for which the ith element is the price of a given
 stock on day i.

Design an algorithm to find the maximum profit. You may complete as
 many transactions as you like (ie, buy one and sell one share of
 the stock multiple times). However, you may not engage in multiple
  transactions at the same time (ie, you must sell the stock before
  you buy again).

*/

//本题相当于是：找到所有递增序列 问题的简化版。只需要找到所有递增序列的增加值的和即可
//最开始时思考的较为复杂，想要找到每个子序列的最低点和最高点，然后计算差值，这样做非常麻烦，非常复杂
//后来想到，只需要比较相邻的两个值,当n+1元素的值大于n元素的值时，即加上两者的差


class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0||prices.length == 1) {
			return 0;
		}
        int sum = 0;
		for (int i = 0; i<prices.length-1; i++) {
			if (prices[i+1]>prices[i]) {
				sum+=prices[i+1]-prices[i];
			}
		}
		return sum;
    }
}
