
/*
Given an array nums and a value val, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example 1:

Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.

It doesn't matter what you leave beyond the returned length.
 */


//这道题本意是想考察快慢双指针，因为按照这个标准输出，我们不仅仅需要返回剩余长度n，也会检查原数组前n位是否是正确数值
//所以我们需要有一个慢指针不断修改值
public int removeElement(int[] nums, int val) {
        int res = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != val){
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }
