/*
Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 */



//查找最长递归子序列
public int findLengthOfLCIS(int[] nums) {
    if (nums.length == 1)
        return 1;
    if (nums.length == 0)
        return 0;
    int longest = 1;
    int currentLength = 1;
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] > nums[i-1]) {
            currentLength ++;
        }
        else {
            longest = longest>currentLength?longest:currentLength;
            currentLength = 1;
        }
    }
    longest = longest>currentLength?longest:currentLength;
    return longest;
}
