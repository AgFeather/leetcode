/*
Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:
Input: [1,2,3]
Output: 6
Example 2:
Input: [1,2,3,4]
Output: 24
Note:
The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
*/


//三个数相乘的最大值，只可能产生于：最大的三个数相乘的值;或者当最大的正数和绝对值最大的两个负数相乘
class Solution {
  public int maximumProduct(int[] nums) {
    Arrays.sort(nums);
		int x = nums[nums.length-1];
		int y = nums[nums.length-2];
		int z = nums[nums.length-3];
		int res1 = x*y*z;
		int res2 = nums[0]*nums[1]*x;
		return res1>res2?res1:res2;
    }
}
