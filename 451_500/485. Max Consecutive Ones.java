//Given a binary array, find the maximum number of consecutive 1s in this array.

public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
		int temp = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]==1) {
				temp++;
				if (max<temp) {
					max=temp;
				}
			}
			else {
				temp = 0;
			}
		}
		return max;
    }
