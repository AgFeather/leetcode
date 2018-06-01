/*

The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]
 */

/*
比较新颖的一道题，因为是变相找重复的问题，最开始想到的是用位操作。
然后发现题干已经给了提醒：set。所以想法是先用set找到重复的元素，然后同时计算nums和与正确和的差
用重复值+和的差值就是被覆盖掉的数据
 */

 pubilc int[] findErrorNums(int[] nums){
     Set<Integer> set = new HashSet<>();
     int[] res = new int[2];
     int sum = 0;
     for (int i = 0; i<nums.length; i++ ) {
         sum += nums[i];
         if (!set.add(nums[i])) {
             res[0] = nums[i];
         }
     }
     res[1] = res[0] + (1+nums.length)*nums.length/2 - sum;
     return res;
 }
