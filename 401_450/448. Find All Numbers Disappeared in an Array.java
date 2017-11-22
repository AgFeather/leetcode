//Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

//Find all the elements of [1, n] inclusive that do not appear in this array.

//Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.


//the first solution I thought is to add nums to a Set, and if n is not contained by Set, add it to result list.
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
    
    
// the second solution I thought do not need the extra space! I add all number (1 ~ nums.length) to the result list, and loop 
//array nums, if list contains nums[i], then remove it.

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
		for (Integer integer : list) {
			System.out.println(integer);
		}
		return list;
    }
    
//there is a big problem in my solutions, they cost too much time, I saw a solution which is very fast because he donot use List operation

List<Integer> list = new ArrayList<>();
		for (int i = 0; i<nums.length; i++) {
			int index = Math.abs(nums[i])-1; //transform the nums[index] into a negative value which means this index is contained by nums
			if (nums[index]>0) {
				nums[index] = -nums[index];
			}
			
		}
		for (int i = 0; i<nums.length; i++) {
			if (nums[i]>0) {
				list.add(i+1);
			}
		}
		return list;
