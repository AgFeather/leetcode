/*
Given an array nums, write a function to move all 0s to
the end of it while maintaining the relative order of
the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12],
after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

//初始化index=0，只需要遍历数组，统计0的个数，
//遇到非零数字就移到当前index处，index++
public void moveZeroes(int[] nums) {
    int zeroCount = 0;
    int indexFont = 0;
    for (int i = 0; i < nums.length; i++) {
		if (nums[i] == 0) {
			zeroCount++;// zeroCount = nums.length-indexFont
		}
		else {
			nums[indexFont] = nums[i];
			indexFont++;
		}
	}
    for(int i = nums.length-1;i>nums.length-zeroCount-1;i--) {
    	nums[i] = 0;
    }
}
