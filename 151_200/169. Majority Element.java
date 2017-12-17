/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

*/

//使用map对数组中的元素进行计数,然后找到主要元素
class Solution {
    public int majorityElement(int[] nums) {
    int res = 0;
    Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0;i<nums.length;i++ ) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i],map.get(nums[i])+1);
			}
			else
				map.put(nums[i],1);
      if (map.get(temp)>nums.length/2) {
				res = temp;
        break;
			}
		}
		return res;
    }
}

//一个更巧妙的方法，对数组进行排序，num[n/2]即为result
public int majorityElement1(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length/2];
}
