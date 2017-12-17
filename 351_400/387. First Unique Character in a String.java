/*

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.


*/


//讲所有出现字符统计到map中，然后遍历s
class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
    	for (int i = 0; i<s.length(); i++) {
    		if (map.containsKey(s.charAt(i))) {
    			map.put(s.charAt(i),map.get(s.charAt(i))+1);
    		}
    		else{
    			map.put(s.charAt(i),1);
    		}
    	}
    	for (int i = 0; i<s.length(); i++) {
    		if (map.get(s.charAt(i)) == 1) {
    			return i;
    		}
    	}
    	return -1;
    }
}

//一种不需要使用容器的方法：
//因为已经知道，最多有26个英文字母，所以可以用一个数组代替。
    public int firstUniqChar(String s){
    	int[] frequency = new int[26];
    	for (int i = 0; i<s.length; i++) {
    		frequency[s.charAt(i)-'a']++;
    	}
    	for (int i = 0; i<s.length; i++) {
    		if (frequency[s.charAt(i)-'a'] == 1) {
    			return i;
    		}
    	}
    	return -1;
    }
