//Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
//some elements appear twice and others appear once.

//Find all the elements of [1, n] inclusive that do not appear in this array.

//Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

//最直接的想法是将nums放入set，然后找到缺失值
public List<Integer> findDisappearedNumbers(int[] nums) {
    Set<Integer> set = new HashSet<>();
	List<Integer> list = new ArrayList<>();
	for (int i = 0; i<nums.length; i++) {
		set.add(nums[i]);
	}
	for (int i = 1; i<nums.length+1; i++) {
		if (!set.contains(i)) {
			list.add(i);
		}
	}
	return list;
}


//第二种方法可以不适用额外空间，直接初始化一个arraylist，然后不断remove
public List<Integer> findDisappearedNumbers(int[] nums) {
	List<Integer> list = new LinkedList<>();
	for (int i = 0; i < nums.length; i++) {
		list.add(i+1);
	}
	for (int i = 0; i < nums.length; i++) {
		if (list.contains(nums[i])) {
			list.remove(new Integer(nums[i]));
		}
	}
	return list;
}
