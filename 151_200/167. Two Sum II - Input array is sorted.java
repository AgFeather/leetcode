/*
Given an array of integers that is already sorted in ascending order,
 find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such
that they add up to the target, where index1 must be less than
index2. Please note that your returned answers (both index1 and
index2) are not zero-based.

You may assume that each input would have exactly one solution
and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/


//解题思路：非常清晰，因为是已经排序好的array，所以只需要设定头部和尾部两个指针
//根据条件不断移动即可
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int indexl = 0, indexr = numbers.length-1;
		while (true) {
			if (numbers[indexl]+numbers[indexr]==target) {
				break;
			}
			else if (numbers[indexl]+numbers[indexr]>target) {
				indexr--;
			}
			else
				indexl++;
		}
		int[] res = {indexl+1,indexr+1};
		return res;
    }
}
