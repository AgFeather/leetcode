/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1

Input: [3,0,1]
Output: 2
Example 2

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
*/

//异或位运算找不同～
//注意，数组长度从0～nums.length-1，异或时注意i+1
class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
		for (int i = 0; i<nums.length; i++) {
			res ^= (i+1);
			res ^= nums[i];
		}
		return res;
    }
}
