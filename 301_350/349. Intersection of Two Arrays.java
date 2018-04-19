/*
Given two arrays, write a function to compute
their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.


*/


public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set = new HashSet<>();
    Set<Integer> intersect = new HashSet<>();
    for (int i = 0; i < nums1.length; i++) {
        set.add(nums1[i]);
    }
    for (int i = 0; i < nums2.length; i++) {
        if (set.contains(nums2[i])) {
            intersect.add(nums2[i]);
        }
    }
    int[] result = new int[intersect.size()];
    int i = 0;
    for (Integer num : intersect) {
        result[i++] = num;
    }
    return result;
}


//通过python set的操作，可以非常便捷的完成该题，可以看出python的便捷性
/*
def intersection(self, nums1, nums2):
        set1 = set(nums1)
        set2 = set(nums2)
        return list(set1&set2)

        */
