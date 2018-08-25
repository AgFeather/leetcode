/*
Given an array of integers, find if the array contains any duplicates.
Your function should return true if any value appears at least twice
in the array, and it should return false if every element is distinct.
*/

//最开始的想法是使用map对每个integer进行计数，看是否都为1，过于繁杂

//将nums中所有元素都放入set中，然后比较set和nums的长度，如果相同则表示所有元素不重复
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
		for (int i = 0; i<nums.length; i++) {
			set.add(nums[i]);
		}
		if (set.size()==nums.length) {
			return false;
		}
		return true;
    }
}

//优化方法，通过判断能否加入set中，判断是否重复
public bollean comtainsDuplicate(int[] nums){
    Set<Integer> set = new HashSet<>();
    for(int i:nums)
        if(!set.add(i))
            return ture;
    return false;
}
