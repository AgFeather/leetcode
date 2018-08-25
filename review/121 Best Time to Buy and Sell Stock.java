/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */


//找到上涨幅度最高的递增子序列（不一定是单调递增）
//首先初始化buyday=0，然后循环，如果发现prices[i]>=prices[i-1]，说明这是一个递增片段，求得如果在i时卖的获利
//如果发现是递减，并且prices[i]<prices[buyday]，说明我们找到了新的最低点，可以用这个最低点当做buyday进行接下来的计算
//而新最低点之前的获利已经被保存，只需要接下来的循环直接对比即可。
public int maxProfit(int[] prices) {
    int res = 0;
	int buyDay = 0;
	for (int i = 1; i<prices.length; i++ ) {
		if (prices[i] >= prices[i-1]) {
			int temp = prices[i] - prices[buyDay];
			res = res>temp?res:temp;
		}else if (prices[i]<prices[buyDay]){
			buyDay = i;
		}
	}
	return res;
}
