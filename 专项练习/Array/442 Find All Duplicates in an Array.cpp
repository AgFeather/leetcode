/*
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
 */


/*
找到所有在一个数组中出现两次的元素，数组中元素的大小为1~n。
所以可以利用数组本身进行标记。
 */
class Solution {
public:
    vector<int> findDuplicates(vector<int>& nums) {
        int length = nums.size();
        vector<int> res;
        for (size_t i = 0; i < nums.size(); i++) {
            int index = nums[i]-1;
            if (nums[i] > length) {
                index -= length;
            }
            if (nums[index] > length) {
                res.push_back(index+1);
            }else{
                nums[index] += length;
            }
        }
        return res;
    }
};
