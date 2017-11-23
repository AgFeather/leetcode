Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.



    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        int indexFont = 0;
        for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				zeroCount++;// zeroCount = nums.length-indexFont  so, variable in not necessary
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
