/*
Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

Example 1:
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
Note:
1 <= k <= n <= 30,000.
Elements of the given array will be in the range [-10,000, 10,000].
 */



/*
思路：最开始将题想的过于复杂，想用动态规划思维，最后发现没有必要，于是想到从头到尾遍历，
实现时间复杂度为O(n2)的解（第二个解法）但是时间不通过，最后发现自己讲这个题想的过于复杂
本质上就是一个大小为k的滑动窗口在给定的数组上滑动，计算窗口内元素的最大均值
 */
public double findMaxAverage(int[] nums, int k){
    double res = -10001;
    double sum = 0;
    for (int i = 0; i<k; i++) {
        sum += nums[i];
    }
    res = sum/k;
    for (int i = k; i<nums.length; i++) {
        sum -= nums[i-k];
        sum += nums[i];
        res = Math.max(res, sum/k);
    }
    return res;
}



public double findMaxAverage(int[] nums, int k){
    double res = -10001;
    for (int i = 0; i<nums.length;i++ ) {
        double sum = 0;
        for (int j = i;j<nums.length;j+=k ) {
            if (j+k <= nums.length)
                res = Math.max(res, getAverage(nums, j, k));
        }
    }
    return res;
}
public double getAverage(int[] nums, int begin, int k){
    double res = 0;
    for (int i = begin; i<begin + k; i++) {
        res += nums[i];
    }
    return res/k;
}
