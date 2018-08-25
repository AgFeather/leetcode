/*

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
 */

//dp[i][1] means we rob the current house and dp[i][0] means we don't,
public int rob(int[] nums){
    int[][] table = new int[nums.length+1][2];
    for (int i = 1; i<=nums.length; i++) {
        table[i][0] = Math.max(table[i-1][0], table[i-1][1]);
        table[i][1] = num[i - 1] + table[i - 1][0];
    }
    return Math.max(table[num.length][0], table[num.length][1]);
}


public int rob(int[] nums){
    int prevNo = 0;
    int prevYes = 0;
    for (int i : nums) {
        int temp = prevNo;
        prevNo = Math.max(temp, prevYes);
        prevYes = i + temp;
    }
    return Math.max(prevNo, prevYes);
}
