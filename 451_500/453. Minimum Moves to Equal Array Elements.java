/*
Given a non-empty integer array of size n, find the minimum number of moves required to
make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:
Input:
[1,2,3]
Output:
3

Explanation:
[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
*/

//本问题相当于将输入数组中每个元素之间的差值归零，所以：
//对n-1个数都加一，等价于对一个数减一（都等价于两者之间的差减一），所以只需要找到最小值然后对每个值与最小值的差进行求和即可

public int minMoves(int[] nums) {
    int min = nums[0];
	for (int i = 0; i<nums.length; i++) {
		if (nums[i]<min) {
			min = nums[i];
		}
	}
	int res = 0;
	for (int i = 0; i<nums.length; i++) {
		res+=nums[i]-min;
	}
	return res;
}
