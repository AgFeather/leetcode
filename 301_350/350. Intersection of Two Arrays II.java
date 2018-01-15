/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
*/
//map计数问题

class Solution {
	public int[] intersect(int[] nums1, int[] nums2){
		List<Integer> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i<nums1.length; i++) {
			map.put(nums1[i], map.getOrDefault(nums1[i],0)+1);
		}
		for (int i = 0; i<nums2.length; i++) {
			if (map.containsKey(nums2[i])&&map.get(nums2[i])>0) {
				list.add(nums2[i]);
				map.put(nums2[i],map.get(nums2[i])-1);
			}
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}
