/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.
*/

//将一个字符串的所有char数量统计到一个map中，然后遍历另一个字符串，对比，并且最后map中所有char的个数应为0
class Solution {
    public boolean isAnagram(String s, String t){
		if (s.length()!=t.length()) {
			return false;
		}
		Map<Character,Integer> map = new HashMap<>();
		for (int i = 0;i<s.length() ;i++ ) {
			char tempChar = s.charAt(i);
			if (map.containsKey(tempChar)) {
				map.put(tempChar,map.get(tempChar)+1);
			}
			else
				map.put(tempChar,1);
		}
		for (int i = 0; i<t.length(); i++) {
			char tempChar = t.charAt(i);
			if (!map.containsKey(tempChar)||map.get(tempChar) == 0) {
				return false;
			}
			map.put(tempChar,map.get(tempChar)-1);
		}
		for(Character key:map.keySet()){
			if (map.get(key)!=0) {
				return false;
			}
		}
		return true;

	}
}
//考虑了使用异或方法，后来发现不行，总结起来，异或操作只适用于从一群相同的元素（而且数量需要为偶数）中挑出一个不同的。


//原答案使用hashmap，过于慢，通过对题干的理解，可以知道字符种类只有26种，所以可以使用array代替map，加快速度。
  public boolean isAnagram(String s, String t){
		if (s.length()!=t.length()) {
			return false;
		}
		int[] array = new int[26];
		for (int i=0; i<s.length(); i++) {
			array[s.charAt(i) - 'a']++;
			array[t.charAt(i) - 'a']--;
		}
		for(int i:array){
			if (i!=0) {
				return false;
			}
		}
		return true;
	}
