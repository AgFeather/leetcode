/*
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".
*/

//使用map统计每个餐厅之间的距离，同时记录最小值，并挑出所有最小值对应的餐厅名，返回String[]
class Solution {
public String[] findRestaurant(String[] list1, String[] list2){
		Map<String,Integer> map = new HashMap<>();
		int min = list1.length;
		for (int i = 0; i<list1.length; i++) {
			for (int j = 0; j<list2.length; j++) {
				if (list2[j] == list1[i]) {
					int temp = i+j;
					if (min>temp) {
						min = temp;
					}
					map.put(list1[i],temp);
					break;
				}
			}
		}
		List<String> list = new ArrayList<>();
		for (String s : map.keySet()) {
			if (map.get(s) == min) {
				list.add(s);
			}
		}

		return list.toArray(new String[list.size()];
	}
}




//O(n+m)  O（n）time
	public String[] findRestaurant(String[] list1, String[] list2){
		Map<String,Integer> map = new HashMap<>();
		int min = Integer.MAX_VALUE;
		List<String> res = new ArrayList<>();
		for (int i = 0; i<list1.length; i++) {
			map.put(list1[i],i);
		}
		for (int i = 0; i<list2.length; i++) {
			Integer j = map.get(list2[i]);
			if (j!=null&& i+j <= min) {
				if (i+j<min) {res.clear(); min = i+j;}
				res.add(list2[i]);
			}
		}
		return res.toArray(new String[res.size()]);
	}
