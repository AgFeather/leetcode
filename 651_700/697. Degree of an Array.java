/*
Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:
Input: [1, 2, 2, 3, 1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:
Input: [1,2,2,3,1,4,2]
Output: 6
*/

// 先用map统计出nums中出现频率次数，并找出最大值
//然后找出频率最大的几个元素，放入set中。
//遍历set中的元素，并找到没一个元素对应的长度，返回最小的

class Solution {
  public int findShortestSubArray(int[] nums) {
    if (nums.length <2) {
			return nums.length;
		}
		Set<Integer> set = new HashSet<>();
		int maxCount = 1;
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i<nums.length; i++) {
			int tempNumber = nums[i];
			if (map.containsKey(tempNumber)) {
				int tempCount = map.get(tempNumber)+1;
				if (maxCount<tempCount) {
					maxCount = tempCount;
				}
				map.put(tempNumber,tempCount);
			}
			else
				map.put(tempNumber,1);
		}
		for(Integer i : map.keySet()){
			if (maxCount == map.get(i)) {
				set.add(i);
			}
		}
		
		int res = nums.length;
		for (Integer i:set) {
			int left = 0;
			int right = nums.length-1;
			for (; left<nums.length; left++) {
				if (nums[left] == i) {
					break;
				}
			}
			for (; right>=0; right--) {
				if (nums[right] == i) {
					break;
				}
			}
			res = res<(right-left)?res:(right-left);
		}
		return res+1;
    }
}
