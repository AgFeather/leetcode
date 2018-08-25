/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 */
/*
变种选择排序，如果用正常思维从头到尾不断插排的话，每次都需要对nums1数组进行移动，耗费大量时间，
所以可以从nums1的尾部开始插排，每次选择nums1和nums2尾部元素进行比较，将较大值插入nums1尾部
注意剩余元素和最后的边界检查
 */
public void merge(int[] nums1, int m, int[] nums2, int n){
    int index = m + n -1;
    m--;
    n--;
    while(m >= 0 && n >= 0){
        if (nums1[m] > nums2[n]) {
            nums1[index--] = nums1[m--];
        }else{
            nums1[index--] = nums2[n--];
        }
    }
    if (n >= 0){
        for (int i = 0; i<=n; i++) {//因为n已经是索引值，所以i<=n
            nums1[i] = nums2[i];
        }
    }
}
