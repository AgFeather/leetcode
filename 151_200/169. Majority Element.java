/*
Given an array of size n, find the majority element.
The majority element is the element that appears
more than ⌊ n/2 ⌋ times.
*/

//使用map对数组中的元素进行计数,然后找到主要元素
//可以在构建map过程中进行major判断，这样有些情况下可以优化速度
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
