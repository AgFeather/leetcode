/*
Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example 1:
Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
For the left two athletes, you just need to output their relative ranks according to their scores.

*/

//首先对所有score进行从大到小排序，生成sortArray，然后再次遍历原始nums数组，对每一个元素，查找其在sortArray中的index
//如果index<3，返回金银铜牌，否则返回index+1的字符串
//问题：1 选择排序仍然没有熟练掌握；2 在java中，函数传递参数为指针，即在函数中对数组进行更改时，直接修改地址中保存的变量（原函数中的数组已经被改变）
class Solution {
	public String findIndex(int[] sortNums,int num){
		int i = 0;
		for (;i<sortNums.length ;i++ ) {
			if (num == sortNums[i]) {
				break;
			}
		}
		i++;
		switch (i) {
			case 1:
			return "Gold Medal";
	
			case 2:
			return "Silver Medal";

			case 3:
			return "Bronze Medal";

			default:
			return i+"";
		}
	}


	public String[] findRelativeRanks(int[] nums){
		String[] res = new String[nums.length];
		int[] sortNums = null;
		sortNums = sortArray(nums);
		for (int i = 0; i<nums.length; i++) {
			res[i] = findIndex(sortNums,nums[i]);
		}
		return res;	
	}
	public int[] sortArray(int[] nums){
		int[] res = new int[nums.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = nums[i];
		}
		for (int i = 0 ; i < res.length; i++) {
			int max = i;
			for (int j = i; j < res.length; j++) {
				if (res[j]>res[max]) {
					max = j;
				}
			}
			int temp =	res[i];
			res[i] =	res[max];
			res[max] = temp;
		}
		return res;
	}
}
