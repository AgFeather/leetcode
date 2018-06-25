/*
Given an integer array nums, find the contiguous subarray (containing at least one number)
 which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

 */


/*
解题思路：标准动态规划思想：
1. 使用一个大小为[nums.length][2]大小的数组记录状态：
2. 对于nums中的每个数字，都有两个状态，table[i][0]表示没有加入该数到子序列的最大和，table[i][1]表示将该数加入到子序列后的最大和
3：两个状态转移方程：
对于table[i][0] = max(table[i-1][0], table[i-1][1])。表示不考虑nums[i]时子序列的最大值为是否加入前一个数的最大值
对于table[i][1] = max(table[i-1][1]+nums[i], nums[i])。表示加入nums[i]时子序列的最大值要么是只有nums[i]的值，要么是加入前一个数后子序列的值+nums[i]

时间复杂度为O(n)
 */
public int maxSubArray(int[] nums){
    if(nums.length == 1) return nums[0];
    int[][] table = new int[nums.length][2];
    table[0][0] = Integer.MIN_VALUE;
    table[0][1] = nums[0];
    for (int i = 1; i<nums.length; i++) {
        table[i][0] = Math.max(table[i-1][0], table[i-1][1]);
        table[i][1] = Math.max(nums[i], table[i-1][1]+nums[i]);
    }
    return Math.max(table[nums.length-1][0], table[nums.length-1][1]);
}


//一个更精致的不需要额外空间的动态规划解，核心思想相同
public static int maxSubArray(int[] A) {
    int maxSoFar=A[0], maxEndingHere=A[0];
    for (int i=1;i<A.length;++i){
    	maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
    	maxSoFar=Math.max(maxSoFar, maxEndingHere);
    }
    return maxSoFar;
}



//常规解法，用一个二维数组记录所有子序列的和并找到最大，时间复杂度为：O(n2)
public int maxSubArray(int [] nums){
    int[][] table = new int[nums.length][nums.length];
    int max = nums[0];
    for (int i = 0; i<nums.length; i++) {
        for (int j = i;j<nums.length ; j++) {
            if (i == j) {
                table[i][j] = nums[i];
            }
            else{
                table[i][j] = table[i][j-1] + nums[j];
            }
            max = Math.max(max, table[i][j]);
        }
    }
    return max;
}
