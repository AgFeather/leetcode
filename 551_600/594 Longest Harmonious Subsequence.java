/*
We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

Example 1:
Input: [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 */


/*
注意题干中的exactly意味着如果差值必须为1，为0都不可以。
最开始将题想的太复杂，一直在想用动态规划做，但是发现没办法记录状态。
最后想到本质上就是对每个数的出现次数进行统计，然后再找到每个数相邻的两个数的出现次数，然后找到最大值。
 */
public int findLHS(int[] nums){
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i<nums.length; i++) {
        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }
    int res  = 0;
    for (Integer i : map.keySet()) {
        if (map.containsKey(i+1)) {
            res = Math.max(res, map.get(i) + map.get(i+1));
        }
    }
    return res;
}
